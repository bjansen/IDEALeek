// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import com.plopiplop.leekwars.psi.LSFormalParameterList;
import com.plopiplop.leekwars.psi.LSParameter;
import com.plopiplop.leekwars.psi.LSVisitor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LSFormalParameterListImpl extends ASTWrapperPsiElement implements LSFormalParameterList {

  public LSFormalParameterListImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LSVisitor) ((LSVisitor)visitor).visitFormalParameterList(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<LSParameter> getParameterList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LSParameter.class);
  }

}
