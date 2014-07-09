package com.plopiplop.leekwars.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.vcs.changes.RunnableBackgroundableWrapper;
import com.plopiplop.leekwars.model.ModelManager;

public class UpdateAPIAction extends AnAction {

    private ModelManager modelManager;

    public UpdateAPIAction() {

    }

    public UpdateAPIAction(ModelManager modelManager) {
        this.modelManager = modelManager;
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
        RunnableBackgroundableWrapper wrapper = new RunnableBackgroundableWrapper(e.getProject(), "Fetching data from LeekWars server...", new UpdateAPITask(e.getProject(), modelManager));

        ProgressManager.getInstance().run(wrapper);
    }
}
