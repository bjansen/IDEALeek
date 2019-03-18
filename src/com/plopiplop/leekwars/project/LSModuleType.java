package com.plopiplop.leekwars.project;

import com.intellij.ide.util.projectWizard.ModuleBuilderListener;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.vcs.changes.RunnableBackgroundableWrapper;
import com.plopiplop.leekwars.actions.DownloadScriptsTask;
import com.plopiplop.leekwars.actions.UpdateAPITask;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class LSModuleType extends ModuleType<LSModuleBuilder> implements ModuleBuilderListener {

    public static final LSModuleType INSTANCE = new LSModuleType();

    @NonNls
    private static final String ID = "LEEKSCRIPT_MODULE";

    public LSModuleType() {
        super(ID);
    }

    @NotNull
    @Override
    public LSModuleBuilder createModuleBuilder() {
        LSModuleBuilder builder = new LSModuleBuilder();

        builder.addListener(this);

        return builder;
    }

    @NotNull
    @Override
    public String getName() {
        return "LeekScript";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Creates a new module containing LeekScript files";
    }

    @Override
    public Icon getNodeIcon(@Deprecated boolean isOpened) {
        return IconLoader.getIcon("/icons/leek.png");
    }

    @Override
    public void moduleCreated(@NotNull final Module module) {
        RunnableBackgroundableWrapper wrapper = new RunnableBackgroundableWrapper(module.getProject(), "Preparing project...", new Runnable() {
            @Override
            public void run() {
                new UpdateAPITask(module.getProject(), null).run();
                new DownloadScriptsTask(module.getProject()).run();
            }
        });

        ProgressManager.getInstance().run(wrapper);

    }
}
