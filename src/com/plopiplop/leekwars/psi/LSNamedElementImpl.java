package com.plopiplop.leekwars.psi;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReference;
import com.intellij.psi.search.LocalSearchScope;
import com.intellij.psi.search.SearchScope;
import com.intellij.util.IncorrectOperationException;
import com.intellij.util.PlatformIcons;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public abstract class LSNamedElementImpl extends ASTWrapperPsiElement implements LSNamedElement {
    public LSNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public String getName() {
        if (getNameIdentifier() != null) {
            return getNameIdentifier().getText();
        }
        return null;
    }

    @Nullable
    @Override
    public PsiElement getNameIdentifier() {
        if (this instanceof LSFunctionDeclaration) {
            LSFunctionName functionName = ((LSFunctionDeclaration) this).getFunctionName();
            return functionName == null ? null : functionName.getIdentifier();
        } else if (this instanceof LSForInitializer) {
            return ((LSForInitializer) this).getReferenceExpression().getIdentifier();
        }

        return findChildByType(LSTypes.IDENTIFIER);
    }

    @Override
    public PsiElement setName(@NonNls @NotNull String name) throws IncorrectOperationException {
        PsiElement nameIdentifier = getNameIdentifier();
        PsiElement newIdentifier = PsiUtils.createIdentifierFromText(getProject(), name);
        if (nameIdentifier != null) {
            getNode().replaceChild(nameIdentifier.getNode(), newIdentifier.getNode());
        }
        return this;
    }

    @Override
    public PsiReference getReference() {
        if (this instanceof LSReferenceExpression) {
            return new LSReference(this, new TextRange(0, getTextLength()));
        }

        return null;
    }

    @NotNull
    @Override
    public SearchScope getUseScope() {
        PsiElement element = this;

        if (element instanceof LSFunctionName) {
            element = element.getParent();
        }

        if (!(PsiUtils.findParentBlock(element) instanceof PsiFile)) {
            return new LocalSearchScope(getContainingFile());
        }

        return super.getUseScope();
    }

    @Nullable
    @Override
    public Icon getIcon(int flags) {
        if (this instanceof LSFunctionDeclaration) {
            return PlatformIcons.FUNCTION_ICON;
        } else if (this instanceof LSVariableDeclaration || this instanceof LSForInitializer) {
            return PlatformIcons.VARIABLE_ICON;
        } else if (this instanceof LSParameter) {
            return PlatformIcons.PARAMETER_ICON;
        }

        return super.getIcon(flags);
    }
}