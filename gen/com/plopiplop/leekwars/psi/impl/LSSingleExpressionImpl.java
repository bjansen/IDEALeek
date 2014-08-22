// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.plopiplop.leekwars.psi.LSAdditiveExpression;
import com.plopiplop.leekwars.psi.LSAssignExpression;
import com.plopiplop.leekwars.psi.LSBitwiseExpression;
import com.plopiplop.leekwars.psi.LSCompareExpression;
import com.plopiplop.leekwars.psi.LSLogicAndExpression;
import com.plopiplop.leekwars.psi.LSLogicOrExpression;
import com.plopiplop.leekwars.psi.LSMultiplicativeExpression;
import com.plopiplop.leekwars.psi.LSPrefixExpression;
import com.plopiplop.leekwars.psi.LSShiftExpression;
import com.plopiplop.leekwars.psi.LSSingleExpression;
import com.plopiplop.leekwars.psi.LSTernaryExpression;
import com.plopiplop.leekwars.psi.LSVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LSSingleExpressionImpl extends ASTWrapperPsiElement implements LSSingleExpression {

  public LSSingleExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LSVisitor) ((LSVisitor)visitor).visitSingleExpression(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public LSAdditiveExpression getAdditiveExpression() {
      return findChildByClass(LSAdditiveExpression.class);
  }

  @Override
  @Nullable
  public LSAssignExpression getAssignExpression() {
      return findChildByClass(LSAssignExpression.class);
  }

  @Override
  @Nullable
  public LSBitwiseExpression getBitwiseExpression() {
      return findChildByClass(LSBitwiseExpression.class);
  }

  @Override
  @Nullable
  public LSCompareExpression getCompareExpression() {
      return findChildByClass(LSCompareExpression.class);
  }

  @Override
  @Nullable
  public LSLogicAndExpression getLogicAndExpression() {
      return findChildByClass(LSLogicAndExpression.class);
  }

  @Override
  @Nullable
  public LSLogicOrExpression getLogicOrExpression() {
      return findChildByClass(LSLogicOrExpression.class);
  }

  @Override
  @Nullable
  public LSMultiplicativeExpression getMultiplicativeExpression() {
      return findChildByClass(LSMultiplicativeExpression.class);
  }

  @Override
  @Nullable
  public LSPrefixExpression getPrefixExpression() {
      return findChildByClass(LSPrefixExpression.class);
  }

  @Override
  @Nullable
  public LSShiftExpression getShiftExpression() {
      return findChildByClass(LSShiftExpression.class);
  }

  @Override
  @Nullable
  public LSTernaryExpression getTernaryExpression() {
      return findChildByClass(LSTernaryExpression.class);
  }

}
