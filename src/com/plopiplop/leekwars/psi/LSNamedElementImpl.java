package com.plopiplop.leekwars.psi;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
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
        throw new UnsupportedOperationException();
    }

    @Override
    public PsiReference getReference() {
        PsiElement id = getNameIdentifier();

        return new LSReference(id, new TextRange(id.getStartOffsetInParent(), id.getStartOffsetInParent() + id.getTextLength()));
    }
}