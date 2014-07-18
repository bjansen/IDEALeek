package com.plopiplop.leekwars.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.vcs.changes.RunnableBackgroundableWrapper;

public class DownloadScriptsAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        RunnableBackgroundableWrapper wrapper = new RunnableBackgroundableWrapper(e.getProject(), "Downloading scripts from LeekWars server...", new DownloadScriptsTask(e.getProject()));

        ProgressManager.getInstance().run(wrapper);
    }
}
