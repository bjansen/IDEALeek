// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.plopiplop.leekwars.psi.LSMemberExpression;
import com.plopiplop.leekwars.psi.LSMethodCall;
import com.plopiplop.leekwars.psi.LSPrefixExpression;
import com.plopiplop.leekwars.psi.LSPrefixOperator;
import com.plopiplop.leekwars.psi.LSSuffixExpression;
import com.plopiplop.leekwars.psi.LSVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LSPrefixExpressionImpl extends ASTWrapperPsiElement implements LSPrefixExpression {

    public LSPrefixExpressionImpl(ASTNode node) {
        super(node);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof LSVisitor) ((LSVisitor) visitor).visitPrefixExpression(this);
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
    public LSPrefixExpression getPrefixExpression() {
        return findChildByClass(LSPrefixExpression.class);
    }

    @Override
    @Nullable
    public LSPrefixOperator getPrefixOperator() {
        return findChildByClass(LSPrefixOperator.class);
    }

    @Override
    @Nullable
    public LSSuffixExpression getSuffixExpression() {
        return findChildByClass(LSSuffixExpression.class);
    }

}
