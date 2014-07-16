package com.plopiplop.leekwars;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import org.jetbrains.annotations.NotNull;

public class LeekWarsApi {

    private LeekWarsApi() {
    }

    public static final String LEEKWARS_API_FILE = "leekwars-api.lks";

    @NotNull
    public static PsiFile getApiPsiFile(Project project) throws ApiNotFoundException {

        VirtualFile genRoot = getGenRoot(project);
        PsiFile file = null;

        if (genRoot != null && genRoot.exists()) {
            PsiDirectory directory = PsiManager.getInstance(project).findDirectory(genRoot);

            if (directory != null) {
                file = directory.findFile(LEEKWARS_API_FILE);
            }
        }

        if (file == null) {
            throw new ApiNotFoundException(LEEKWARS_API_FILE + " not found");
        }

        return file;
    }

    public static VirtualFile getGenRoot(Project project) {
        Module module = ModuleManager.getInstance(project).getModules()[0];
        VirtualFile[] sourceRoots = ModuleRootManager.getInstance(module).getSourceRoots(false);

        for (VirtualFile sourceRoot : sourceRoots) {
            if (sourceRoot.getName().equals("gen")) {
                return sourceRoot;
            }
        }

        return null;
    }
}
