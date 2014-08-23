// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.plopiplop.leekwars.psi.LSArgumentList;
import com.plopiplop.leekwars.psi.LSArguments;
import com.plopiplop.leekwars.psi.LSVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.plopiplop.leekwars.psi.LSTypes.OP_LPAREN;
import static com.plopiplop.leekwars.psi.LSTypes.OP_RPAREN;

public class LSArgumentsImpl extends ASTWrapperPsiElement implements LSArguments {

  public LSArgumentsImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LSVisitor) ((LSVisitor)visitor).visitArguments(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public LSArgumentList getArgumentList() {
    return findChildByClass(LSArgumentList.class);
  }

  @Override
  @NotNull
  public PsiElement getOpLparen() {
    return findNotNullChildByType(OP_LPAREN);
  }

  @Override
  @NotNull
  public PsiElement getOpRparen() {
    return findNotNullChildByType(OP_RPAREN);
  }

}
