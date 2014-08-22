// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.plopiplop.leekwars.psi.LSMemberExpression;
import com.plopiplop.leekwars.psi.LSMethodCall;
import com.plopiplop.leekwars.psi.LSSuffixExpression;
import com.plopiplop.leekwars.psi.LSVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.plopiplop.leekwars.psi.LSTypes.OP_DEC;
import static com.plopiplop.leekwars.psi.LSTypes.OP_INC;

public class LSSuffixExpressionImpl extends ASTWrapperPsiElement implements LSSuffixExpression {

    public LSSuffixExpressionImpl(ASTNode node) {
        super(node);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof LSVisitor) ((LSVisitor) visitor).visitSuffixExpression(this);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public LSMemberExpression getMemberExpression() {
        return findChildByClass(LSMemberExpression.class);
    }

    @Override
    @Nullable
    public LSMethodCall getMethodCall() {
        return findChildByClass(LSMethodCall.class);
    }

    @Override
    @Nullable
    public LSSuffixExpression getSuffixExpression() {
        return findChildByClass(LSSuffixExpression.class);
    }

    @Override
    @Nullable
    public PsiElement getOpDec() {
        return findChildByType(OP_DEC);
    }

    @Override
    @Nullable
    public PsiElement getOpInc() {
        return findChildByType(OP_INC);
    }

}
