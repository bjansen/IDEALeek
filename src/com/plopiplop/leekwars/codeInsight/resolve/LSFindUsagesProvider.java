package com.plopiplop.leekwars.codeInsight.resolve;

import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.TokenSet;
import com.plopiplop.leekwars.parser.LeekScriptLexer;
import com.plopiplop.leekwars.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LSFindUsagesProvider implements FindUsagesProvider {
    @Nullable
    @Override
    public WordsScanner getWordsScanner() {
        return new DefaultWordsScanner(new LeekScriptLexer(), TokenSet.create(LSTypes.IDENTIFIER),
                TokenSet.create(LSTypes.COMMENT, LSTypes.MULTILINE_COMMENT), TokenSet.create(LSTypes.STRING));
    }

    @Override
    public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
        return psiElement instanceof LSNamedElement;
    }

    @Nullable
    @Override
    public String getHelpId(@NotNull PsiElement psiElement) {
        return null;
    }

    @NotNull
    @Override
    public String getType(@NotNull PsiElement element) {
        if (element instanceof LSFunctionDeclaration) {
            return "Function declaration";
        } else if (element.getParent() instanceof LSVariableStatement) {
            String scope = ((LSVariableStatement) element.getParent()).isGlobal() ? "Global" : "Local";
            return scope + " variable";
        } else if (element.getParent() instanceof LSForInitializer) {
            return "Local variable";
        } else if (element instanceof LSParameter) {
            return "Function parameter";
        }
        return "LOLILOL";
    }

    @NotNull
    @Override
    public String getDescriptiveName(@NotNull PsiElement element) {
        return getNodeText(element, true);
    }

    @NotNull
    @Override
    public String getNodeText(@NotNull PsiElement element, boolean useFullName) {
        if (element instanceof LSFunctionDeclaration) {
            return ((LSFunctionDeclaration) element).getSignature();
        } else if (element instanceof LSNamedElement) {
            return ((LSNamedElement) element).getName();
        } else if (element instanceof LSFile) {
            return ((LSFile) element).getName();
        }

        throw new UnsupportedOperationException("Cannot get node text for element of type " + element.getClass().getName());
    }
}
