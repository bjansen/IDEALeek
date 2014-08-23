// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import com.plopiplop.leekwars.psi.LSElementList;
import com.plopiplop.leekwars.psi.LSSingleExpression;
import com.plopiplop.leekwars.psi.LSVisitor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LSElementListImpl extends ASTWrapperPsiElement implements LSElementList {

  public LSElementListImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LSVisitor) ((LSVisitor)visitor).visitElementList(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<LSSingleExpression> getSingleExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LSSingleExpression.class);
  }

}
