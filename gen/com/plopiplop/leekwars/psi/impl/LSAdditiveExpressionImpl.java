// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import com.plopiplop.leekwars.psi.LSAdditiveExpression;
import com.plopiplop.leekwars.psi.LSMultiplicativeExpression;
import com.plopiplop.leekwars.psi.LSPrefixExpression;
import com.plopiplop.leekwars.psi.LSVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.plopiplop.leekwars.psi.LSTypes.OP_MINUS;
import static com.plopiplop.leekwars.psi.LSTypes.OP_PLUS;

public class LSAdditiveExpressionImpl extends ASTWrapperPsiElement implements LSAdditiveExpression {

    public LSAdditiveExpressionImpl(ASTNode node) {
        super(node);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof LSVisitor) ((LSVisitor) visitor).visitAdditiveExpression(this);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public LSAdditiveExpression getAdditiveExpression() {
        return findChildByClass(LSAdditiveExpression.class);
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
    public PsiElement getOpMinus() {
        return findChildByType(OP_MINUS);
    }

    @Override
    @Nullable
    public PsiElement getOpPlus() {
        return findChildByType(OP_PLUS);
    }

}
