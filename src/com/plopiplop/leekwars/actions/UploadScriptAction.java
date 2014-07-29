package com.plopiplop.leekwars.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vcs.changes.RunnableBackgroundableWrapper;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.plopiplop.leekwars.psi.LSFile;

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
        Project project = getEventProject(evt);

        if (project != null) {
            PsiDocumentManager.getInstance(project).commitAllDocuments();
        }
        FileDocumentManager.getInstance().saveAllDocuments();

        UploadScriptTask task = new UploadScriptTask(project, evt.getDataContext());
        final RunnableBackgroundableWrapper wrapper = new RunnableBackgroundableWrapper(evt.getProject(), "Uploading script...", task);
        ProgressManager.getInstance().run(wrapper);
    }
}