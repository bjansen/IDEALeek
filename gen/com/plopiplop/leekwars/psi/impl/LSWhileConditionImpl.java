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

public class LSWhileConditionImpl extends ASTWrapperPsiElement implements LSWhileCondition {

  public LSWhileConditionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LSVisitor) ((LSVisitor)visitor).visitWhileCondition(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public LSExpressionSequence getExpressionSequence() {
    return findChildByClass(LSExpressionSequence.class);
  }

  @Override
  @NotNull
  public PsiElement getKwWhile() {
    return findNotNullChildByType(KW_WHILE);
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
