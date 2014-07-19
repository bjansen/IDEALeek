package com.plopiplop.leekwars.actions;

import com.intellij.compiler.CompilerMessageImpl;
import com.intellij.compiler.progress.CompilerTask;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.compiler.CompilerMessageCategory;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.EmptyRunnable;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.plopiplop.leekwars.model.LeekWarsServer;
import com.plopiplop.leekwars.options.PluginNotConfiguredException;
import com.plopiplop.leekwars.psi.LSFile;

import java.io.IOException;

public class UploadScriptAction extends AnAction {
    @Override
    public void update(AnActionEvent e) {
        Project project = getEventProject(e);
        VirtualFile[] files = LangDataKeys.VIRTUAL_FILE_ARRAY.getData(e.getDataContext());
        boolean lksFound = false;

        if (project != null && files != null) {
            PsiManager manager = PsiManager.getInstance(project);

            for (VirtualFile virtualFile : files) {
                PsiFile psiFile = manager.findFile(virtualFile);
                lksFound = psiFile instanceof LSFile;

                if (lksFound) {
                    break;
                }
            }
        }
        e.getPresentation().setEnabled(lksFound);
        e.getPresentation().setVisible(lksFound);
    }

    @Override
    public void actionPerformed(AnActionEvent evt) {
        final Project project = getEventProject(evt);
        final VirtualFile[] files = LangDataKeys.VIRTUAL_FILE_ARRAY.getData(evt.getDataContext());

        if (project == null || files == null) {
            return;
        }
        PsiDocumentManager.getInstance(project).commitAllDocuments();
        FileDocumentManager.getInstance().saveAllDocuments();

        PsiManager manager = PsiManager.getInstance(project);

        for (VirtualFile file : files) {
            PsiFile psiFile = manager.findFile(file);

            if (psiFile instanceof LSFile) {
                String[] parts = file.getNameWithoutExtension().split("__");

                if (parts.length == 2) {
                    try {
                        LeekWarsServer.getInstance().uploadScript(parts[1], parts[0], psiFile.getText());
                        Notifications.Bus.notify(new Notification("LeekScript", "LeekWars Script", "Script uploaded", NotificationType.INFORMATION));
                    } catch (CompilationException e) {
                        CompilerTask task = new CompilerTask(project, "LeekScript", false, false, false, true);
                        task.start(EmptyRunnable.getInstance(), null);
                        task.addMessage(new CompilerMessageImpl(project, CompilerMessageCategory.ERROR, e.getMessage(), file, e.getLine(), e.getCharacter(), null));
                        e.printStackTrace();
                    } catch (PluginNotConfiguredException e) {
                        // TODO refactor everywhere these catch are used
                        Notifications.Bus.notify(new Notification("LeekScript", "Can't connect to LeekWars server", "Please configure the LeekScript plugin", NotificationType.ERROR));
                    } catch (IOException e) {
                        Notifications.Bus.notify(new Notification("LeekScript", "Error", "Can't reach LeekWars server :(", NotificationType.ERROR));
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
