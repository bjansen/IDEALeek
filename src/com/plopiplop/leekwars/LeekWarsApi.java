package com.plopiplop.leekwars;

import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

public class LeekWarsApi {

    private LeekWarsApi() {
    }

    public static final String LEEKWARS_API_FILE = "leekwars-api.lks";

    @NotNull
    public static PsiFile getApiPsiFile(PsiElement element) {
        PsiDirectory directory = element.getContainingFile().getParent();

        if (directory == null) {
            throw new IllegalArgumentException("Parent directory of " + element.getContainingFile().getName() + " not found");
        }
        PsiFile file = directory.findFile(LEEKWARS_API_FILE);

        if (file == null) {
            throw new IllegalArgumentException(LEEKWARS_API_FILE + " not found");
        }

        return file;
    }
}
