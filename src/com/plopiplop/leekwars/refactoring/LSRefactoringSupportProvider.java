package com.plopiplop.leekwars.refactoring;

import com.intellij.lang.refactoring.RefactoringSupportProvider;
import com.intellij.psi.PsiElement;
import com.intellij.refactoring.RefactoringActionHandler;
import com.plopiplop.leekwars.psi.LSFunctionDeclaration;
import com.plopiplop.leekwars.psi.LSVariableDeclaration;
import org.jetbrains.annotations.NotNull;

public class LSRefactoringSupportProvider extends RefactoringSupportProvider {
    @Override
    public boolean isInplaceRenameAvailable(@NotNull PsiElement element, PsiElement context) {
        if (context != null && context.getContainingFile() != element.getContainingFile()) {
            return false;
        }

        return element instanceof LSVariableDeclaration;
    }

    @Override
    public boolean isMemberInplaceRenameAvailable(@NotNull PsiElement element, PsiElement context) {
        return element instanceof LSFunctionDeclaration;
    }

    @NotNull
    @Override
    public RefactoringActionHandler getIntroduceVariableHandler() {
        return new LSIntroduceVariableHandler();
    }
}
