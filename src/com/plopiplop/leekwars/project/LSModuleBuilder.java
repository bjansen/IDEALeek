package com.plopiplop.leekwars.project;

import com.intellij.ide.util.projectWizard.ModuleBuilder;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

public class LSModuleBuilder extends ModuleBuilder {
    @Override
    public void setupRootModel(ModifiableRootModel modifiableRootModel) throws ConfigurationException {
        ContentEntry contentEntry = doAddContentEntry(modifiableRootModel);

        if (contentEntry != null && contentEntry.getFile() != null) {
            VirtualFile srcDirectory;
            try {
                srcDirectory = contentEntry.getFile().createChildDirectory(this, "src");
                contentEntry.addSourceFolder(srcDirectory, false);
            } catch (IOException e) {
                throw new ConfigurationException(e.getMessage(), "Unable to create src folder");
            }
        }
    }

    @Override
    public ModuleType getModuleType() {
        return LSModuleType.INSTANCE;
    }

    @Nullable
    @Override
    public ModuleWizardStep getCustomOptionsStep(WizardContext context, Disposable parentDisposable) {
        return new LSModuleWizardStep();
    }
}
