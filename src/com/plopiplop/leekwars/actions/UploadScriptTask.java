package com.plopiplop.leekwars.actions;

import com.intellij.compiler.CompilerMessageImpl;
import com.intellij.compiler.progress.CompilerTask;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.compiler.CompilerMessageCategory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.EmptyRunnable;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.plopiplop.leekwars.model.LeekWarsServer;
import com.plopiplop.leekwars.options.PluginNotConfiguredException;
import com.plopiplop.leekwars.psi.LSFile;

import java.io.IOException;

public class UploadScriptTask implements Runnable {
    private final Project project;
    private final DataContext dataContext;

    public UploadScriptTask(Project eventProject, DataContext dataContext) {
        this.project = eventProject;
        this.dataContext = dataContext;
    }

    @Override
    public void run() {
        ApplicationManager.getApplication().runReadAction(new Runnable() {
            @Override
            public void run() {
                final VirtualFile[] files = LangDataKeys.VIRTUAL_FILE_ARRAY.getData(dataContext);

                if (project == null || files == null) {
                    return;
                }

                PsiManager manager = PsiManager.getInstance(project);

                for (final VirtualFile file : files) {
                    PsiFile psiFile = manager.findFile(file);

                    if (psiFile instanceof LSFile) {
                        String[] parts = file.getNameWithoutExtension().split("__");

                        if (parts.length == 2) {
                            try {
                                LeekWarsServer.getInstance().uploadScript(parts[1], parts[0], psiFile.getText());
                                Notifications.Bus.notify(new Notification("LeekScript", "LeekWars Script", "Script uploaded", NotificationType.INFORMATION));
                            } catch (final CompilationException e) {
                                reportException(e, file);
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
        });
    }

    private void reportException(final CompilationException e, final VirtualFile file) {
        ApplicationManager.getApplication().invokeLater(new Runnable() {
            @Override
            public void run() {
                ApplicationManager.getApplication().runWriteAction(new Runnable() {
                    @Override
                    public void run() {
                        CompilerTask task = new CompilerTask(project, "LeekScript", false, false, false, true);
                        task.start(EmptyRunnable.getInstance(), null);
                        task.addMessage(new CompilerMessageImpl(project, CompilerMessageCategory.ERROR, e.getMessage(), file, e.getLine(), e.getCharacter(), null));
                        e.printStackTrace();
                    }
                });
            }
        });
    }

}
