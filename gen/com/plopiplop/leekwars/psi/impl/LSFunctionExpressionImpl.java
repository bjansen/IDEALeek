// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.plopiplop.leekwars.psi.LSBlock;
import com.plopiplop.leekwars.psi.LSFormalParameterList;
import com.plopiplop.leekwars.psi.LSFunctionExpression;
import com.plopiplop.leekwars.psi.LSVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.plopiplop.leekwars.psi.LSTypes.KW_FUNCTION;
import static com.plopiplop.leekwars.psi.LSTypes.OP_LPAREN;
import static com.plopiplop.leekwars.psi.LSTypes.OP_RPAREN;

public class LSFunctionExpressionImpl extends ASTWrapperPsiElement implements LSFunctionExpression {

    public LSFunctionExpressionImpl(ASTNode node) {
        super(node);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof LSVisitor) ((LSVisitor) visitor).visitFunctionExpression(this);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public LSBlock getBlock() {
        return findChildByClass(LSBlock.class);
    }

    @Override
    @Nullable
    public LSFormalParameterList getFormalParameterList() {
        return findChildByClass(LSFormalParameterList.class);
    }

    @Override
    @NotNull
    public PsiElement getKwFunction() {
        return findNotNullChildByType(KW_FUNCTION);
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
