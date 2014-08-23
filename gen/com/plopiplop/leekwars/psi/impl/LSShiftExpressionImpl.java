// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import com.plopiplop.leekwars.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.plopiplop.leekwars.psi.LSTypes.*;

public class LSShiftExpressionImpl extends ASTWrapperPsiElement implements LSShiftExpression {

    public LSShiftExpressionImpl(ASTNode node) {
        super(node);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof LSVisitor) ((LSVisitor) visitor).visitShiftExpression(this);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<LSAdditiveExpression> getAdditiveExpressionList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, LSAdditiveExpression.class);
    }

    @Override
    @NotNull
    public List<LSMultiplicativeExpression> getMultiplicativeExpressionList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, LSMultiplicativeExpression.class);
    }

    @Override
    @NotNull
    public List<LSPrefixExpression> getPrefixExpressionList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, LSPrefixExpression.class);
    }

    @Override
    @Nullable
    public LSShiftExpression getShiftExpression() {
        return findChildByClass(LSShiftExpression.class);
    }

    @Override
    @Nullable
    public PsiElement getOpLshift() {
        return findChildByType(OP_LSHIFT);
    }

    @Override
    @Nullable
    public PsiElement getOpRshift() {
        return findChildByType(OP_RSHIFT);
    }

    @Override
    @Nullable
    public PsiElement getOpUnsignedRshift() {
        return findChildByType(OP_UNSIGNED_RSHIFT);
    }

}
