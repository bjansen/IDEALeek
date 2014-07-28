// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.plopiplop.leekwars.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.plopiplop.leekwars.psi.LSTypes.*;

public class LSIfStatementImpl extends ASTWrapperPsiElement implements LSIfStatement {

  public LSIfStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LSVisitor) ((LSVisitor)visitor).visitIfStatement(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public LSElseBlock getElseBlock() {
    return findChildByClass(LSElseBlock.class);
  }

  @Override
  @Nullable
  public LSExpressionSequence getExpressionSequence() {
      return findChildByClass(LSExpressionSequence.class);
  }

  @Override
  @Nullable
  public LSThenBlock getThenBlock() {
      return findChildByClass(LSThenBlock.class);
  }

  @Override
  @NotNull
  public PsiElement getKwIf() {
    return findNotNullChildByType(KW_IF);
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
