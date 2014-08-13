// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import com.plopiplop.leekwars.psi.LSKeyval;
import com.plopiplop.leekwars.psi.LSKeyvalList;
import com.plopiplop.leekwars.psi.LSVisitor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LSKeyvalListImpl extends ASTWrapperPsiElement implements LSKeyvalList {

    public LSKeyvalListImpl(ASTNode node) {
        super(node);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof LSVisitor) ((LSVisitor) visitor).visitKeyvalList(this);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<LSKeyval> getKeyvalList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, LSKeyval.class);
    }

}