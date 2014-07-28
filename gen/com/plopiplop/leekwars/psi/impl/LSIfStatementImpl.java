// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.plopiplop.leekwars.psi.LSTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.plopiplop.leekwars.psi.*;

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
  @NotNull
  public LSExpressionSequence getExpressionSequence() {
    return findNotNullChildByClass(LSExpressionSequence.class);
  }

  @Override
  @NotNull
  public LSThenBlock getThenBlock() {
    return findNotNullChildByClass(LSThenBlock.class);
  }

  @Override
  @NotNull
  public PsiElement getKwIf() {
    return findNotNullChildByType(KW_IF);
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
