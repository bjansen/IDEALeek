// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.plopiplop.leekwars.psi.LSSingleExpression;
import com.plopiplop.leekwars.psi.LSVisitor;
import com.plopiplop.leekwars.psi.LSWhileCondition;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.plopiplop.leekwars.psi.LSTypes.*;

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
  public LSSingleExpression getSingleExpression() {
      return findChildByClass(LSSingleExpression.class);
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
