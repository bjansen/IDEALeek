// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import com.plopiplop.leekwars.psi.LSAdditiveExpression;
import com.plopiplop.leekwars.psi.LSBitwiseExpression;
import com.plopiplop.leekwars.psi.LSCompareExpression;
import com.plopiplop.leekwars.psi.LSLogicAndExpression;
import com.plopiplop.leekwars.psi.LSMultiplicativeExpression;
import com.plopiplop.leekwars.psi.LSPrefixExpression;
import com.plopiplop.leekwars.psi.LSShiftExpression;
import com.plopiplop.leekwars.psi.LSVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.plopiplop.leekwars.psi.LSTypes.OP_AND;
import static com.plopiplop.leekwars.psi.LSTypes.OP_LOGICAL_AND;

public class LSLogicAndExpressionImpl extends ASTWrapperPsiElement implements LSLogicAndExpression {

    public LSLogicAndExpressionImpl(ASTNode node) {
        super(node);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof LSVisitor) ((LSVisitor) visitor).visitLogicAndExpression(this);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<LSAdditiveExpression> getAdditiveExpressionList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, LSAdditiveExpression.class);
    }

    @Override
    @NotNull
    public List<LSBitwiseExpression> getBitwiseExpressionList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, LSBitwiseExpression.class);
    }

    @Override
    @NotNull
    public List<LSCompareExpression> getCompareExpressionList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, LSCompareExpression.class);
    }

    @Override
    @Nullable
    public LSLogicAndExpression getLogicAndExpression() {
        return findChildByClass(LSLogicAndExpression.class);
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
    @NotNull
    public List<LSShiftExpression> getShiftExpressionList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, LSShiftExpression.class);
    }

    @Override
    @Nullable
    public PsiElement getOpAnd() {
        return findChildByType(OP_AND);
    }

    @Override
    @Nullable
    public PsiElement getOpLogicalAnd() {
        return findChildByType(OP_LOGICAL_AND);
    }

}
