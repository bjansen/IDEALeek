// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import com.plopiplop.leekwars.psi.LSKeyval;
import com.plopiplop.leekwars.psi.LSSingleExpression;
import com.plopiplop.leekwars.psi.LSVisitor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.plopiplop.leekwars.psi.LSTypes.OP_COLON;

public class LSKeyvalImpl extends ASTWrapperPsiElement implements LSKeyval {

    public LSKeyvalImpl(ASTNode node) {
        super(node);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof LSVisitor) ((LSVisitor) visitor).visitKeyval(this);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<LSSingleExpression> getSingleExpressionList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, LSSingleExpression.class);
    }

    @Override
    @NotNull
    public PsiElement getOpColon() {
        return findNotNullChildByType(OP_COLON);
    }

}
