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

public class LSSingleExpressionImpl extends ASTWrapperPsiElement implements LSSingleExpression {

  public LSSingleExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LSVisitor visitor) {
    visitor.visitSingleExpression(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LSVisitor) accept((LSVisitor)visitor);
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
