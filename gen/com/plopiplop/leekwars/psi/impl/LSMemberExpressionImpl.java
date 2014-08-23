// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import com.plopiplop.leekwars.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LSMemberExpressionImpl extends ASTWrapperPsiElement implements LSMemberExpression {

    public LSMemberExpressionImpl(ASTNode node) {
        super(node);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof LSVisitor) ((LSVisitor) visitor).visitMemberExpression(this);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public LSFunctionExpression getFunctionExpression() {
        return findChildByClass(LSFunctionExpression.class);
    }

    @Override
    @Nullable
    public LSPrimaryExpression getPrimaryExpression() {
        return findChildByClass(LSPrimaryExpression.class);
    }

    @Override
    @NotNull
    public List<LSSingleExpression> getSingleExpressionList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, LSSingleExpression.class);
    }

}
