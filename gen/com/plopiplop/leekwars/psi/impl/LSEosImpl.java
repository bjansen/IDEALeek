// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.plopiplop.leekwars.psi.LSEos;
import com.plopiplop.leekwars.psi.LSVisitor;
import org.jetbrains.annotations.NotNull;

import static com.plopiplop.leekwars.psi.LSTypes.OP_SEMICOLON;

public class LSEosImpl extends ASTWrapperPsiElement implements LSEos {

  public LSEosImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LSVisitor) ((LSVisitor)visitor).visitEos(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getOpSemicolon() {
    return findNotNullChildByType(OP_SEMICOLON);
  }

}
