// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.plopiplop.leekwars.psi.*;
import org.jetbrains.annotations.NotNull;

public class LSMethodCallImpl extends ASTWrapperPsiElement implements LSMethodCall {

  public LSMethodCallImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LSVisitor) ((LSVisitor)visitor).visitMethodCall(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public LSArguments getArguments() {
    return findNotNullChildByClass(LSArguments.class);
  }

  @Override
  @NotNull
  public LSReferenceExpression getReferenceExpression() {
      return findNotNullChildByClass(LSReferenceExpression.class);
  }

  public int getNbArguments() {
    return LSPsiImplUtil.getNbArguments(this);
  }

}
