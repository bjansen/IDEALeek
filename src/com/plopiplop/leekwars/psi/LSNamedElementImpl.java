package com.plopiplop.leekwars.psi;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.roots.FileIndexFacade;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReference;
import com.intellij.psi.search.LocalSearchScope;
import com.intellij.psi.search.SearchScope;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class LSNamedElementImpl extends ASTWrapperPsiElement implements LSNamedElement {
    public LSNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public String getName() {
        return getNameIdentifier().getText();
    }

    @Nullable
    @Override
    public PsiElement getNameIdentifier() {
        return findChildByType(LSTypes.IDENTIFIER);
    }

    @Override
    public PsiElement setName(@NonNls @NotNull String name) throws IncorrectOperationException {
        return PsiUtils.createIdentifierFromText(getProject(), name);
    }

    @Override
    public PsiReference getReference() {
        PsiElement id = getNameIdentifier();

        return new LSReference(id, new TextRange(0, id.getTextLength()));
    }

    @NotNull
    @Override
    public SearchScope getUseScope() {
        if (!(PsiUtils.findParentBlock(this) instanceof PsiFile)) {
            return new LocalSearchScope(getContainingFile());
        }

        return super.getUseScope();
    }
}