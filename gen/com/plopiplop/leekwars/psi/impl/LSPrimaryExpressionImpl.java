// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.plopiplop.leekwars.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.plopiplop.leekwars.psi.LSTypes.OP_LPAREN;
import static com.plopiplop.leekwars.psi.LSTypes.OP_RPAREN;

public class LSPrimaryExpressionImpl extends ASTWrapperPsiElement implements LSPrimaryExpression {

    public LSPrimaryExpressionImpl(ASTNode node) {
        super(node);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof LSVisitor) ((LSVisitor) visitor).visitPrimaryExpression(this);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public LSArrayLiteral getArrayLiteral() {
        return findChildByClass(LSArrayLiteral.class);
    }

    @Override
    @Nullable
    public LSLiteral getLiteral() {
        return findChildByClass(LSLiteral.class);
    }

    @Override
    @Nullable
    public LSReferenceExpression getReferenceExpression() {
        return findChildByClass(LSReferenceExpression.class);
    }

    @Override
    @Nullable
    public LSSingleExpression getSingleExpression() {
        return findChildByClass(LSSingleExpression.class);
    }

    @Override
    @Nullable
    public PsiElement getOpLparen() {
        return findChildByType(OP_LPAREN);
    }

    @Override
    @Nullable
    public PsiElement getOpRparen() {
        return findChildByType(OP_RPAREN);
    }

}
