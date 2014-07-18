package com.plopiplop.leekwars.actions;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.plopiplop.leekwars.model.LeekWarsServer;
import com.plopiplop.leekwars.options.PluginNotConfiguredException;
import com.plopiplop.leekwars.psi.PsiUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DownloadScriptsTask implements Runnable {
    private static final Pattern TOKEN_REGEX = Pattern.compile("var __TOKEN = '([^']+)';");
    private static final Pattern AI_IDS_REGEX = Pattern.compile("__AI_IDS = \\[([^\\]]+)\\];");
    private static final Pattern AI_NAMES_REGEX = Pattern.compile("__AI_NAMES = \\[([^\\]]+)\\];");

    private Map<String, String> files = new LinkedHashMap<>();
    private Project project;

    public DownloadScriptsTask(Project project) {
        this.project = project;
    }

    @Override
    public void run() {
        Document editor;

        try {
            editor = LeekWarsServer.getInstance().getEditor();
            parseScriptTags(editor);

            ApplicationManager.getApplication().invokeLater(new Runnable() {
                @Override
                public void run() {
                    ApplicationManager.getApplication().runWriteAction(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                downloadFiles();
                            } catch (IOException | PluginNotConfiguredException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            });
        } catch (IOException e) {
            Notifications.Bus.notify(new Notification("LeekScript", "Error", "Can't reach LeekWars server :(", NotificationType.ERROR));
            e.printStackTrace();
        } catch (PluginNotConfiguredException e) {
            Notifications.Bus.notify(new Notification("LeekScript", "Can't connect to LeekWars server", "Please configure the LeekScript plugin", NotificationType.ERROR));
        }
    }

    private void parseScriptTags(Document editor) {
        Elements scripts = editor.select("head script");

        for (Element script : scripts) {
            Matcher matcher = TOKEN_REGEX.matcher(script.data());

            if (matcher.matches()) {
                LeekWarsServer.getInstance().setToken(matcher.group(1));
            }

            matcher = AI_IDS_REGEX.matcher(script.data());

            if (matcher.matches()) {
                parseIdentifiers(matcher);
            }

            matcher = AI_NAMES_REGEX.matcher(script.data());

            if (matcher.matches()) {
                parseNames(matcher);
            }
        }
    }

    private void downloadFiles() throws IOException, PluginNotConfiguredException {
        Module module = ModuleManager.getInstance(project).getModules()[0];
        VirtualFile[] sourceRoots = ModuleRootManager.getInstance(module).getSourceRoots(false);
        PsiDirectory srcDirectory = null;

        for (VirtualFile sourceRoot : sourceRoots) {
            if (!sourceRoot.getName().equals("gen")) {
                srcDirectory = PsiManager.getInstance(project).findDirectory(sourceRoot);
            }
        }

        assert srcDirectory != null;

        for (Map.Entry<String, String> entry : files.entrySet()) {
            Document leekScript = LeekWarsServer.getInstance().downloadScript(entry.getKey());

            String fileName = String.format("%s__%s.lks", entry.getValue(), entry.getKey());

            PsiFile file = PsiUtils.createDummyFile(project, fileName, StringEscapeUtils.unescapeHtml(leekScript.body().html()));

            PsiFile existingFile = srcDirectory.findFile(fileName);

            if (existingFile == null) {
                srcDirectory.add(file);
            } else {
                assert existingFile.getViewProvider().getDocument() != null;
                existingFile.getViewProvider().getDocument().setText(file.getText());
            }
        }
    }

    private void parseNames(Matcher matcher) {
        String[] names = matcher.group(1).split(",");
        int i = 0;

        for (Map.Entry<String, String> entry : files.entrySet()) {
            entry.setValue(names[i].substring(1, names[i].length() - 1));
            i++;
        }
    }

    private void parseIdentifiers(Matcher matcher) {
        for (String id : matcher.group(1).split(",")) {
            files.put(id, null);
        }
    }
}
