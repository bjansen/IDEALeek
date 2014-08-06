// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface LSSingleExpression extends PsiElement {

  @Nullable
  LSSimpleExpression getSimpleExpression();

  @Nullable
  LSSingleExpression getSingleExpression();

  @Nullable
  LSVariableReference getVariableReference();

  @Nullable
  PsiElement getOpAnd();

    @Nullable
  PsiElement getOpAndEq();

  @Nullable
  PsiElement getOpAssign();

  @Nullable
  PsiElement getOpBinaryAnd();

  @Nullable
  PsiElement getOpBinaryOr();

  @Nullable
  PsiElement getOpColon();

  @Nullable
  PsiElement getOpDivide();

  @Nullable
  PsiElement getOpDivideEq();

  @Nullable
  PsiElement getOpEquals();

  @Nullable
  PsiElement getOpGe();

  @Nullable
  PsiElement getOpGt();

  @Nullable
  PsiElement getOpIdentityEquals();

  @Nullable
  PsiElement getOpIdentityNotEquals();

  @Nullable
  PsiElement getOpLe();

  @Nullable
  PsiElement getOpLogicalAnd();

  @Nullable
  PsiElement getOpLogicalOr();

  @Nullable
  PsiElement getOpLt();

  @Nullable
  PsiElement getOpMinus();

  @Nullable
  PsiElement getOpMinusEq();

  @Nullable
  PsiElement getOpModulo();

  @Nullable
  PsiElement getOpNotEquals();

    @Nullable
    PsiElement getOpOr();

  @Nullable
  PsiElement getOpOrEq();

  @Nullable
  PsiElement getOpPlus();

  @Nullable
  PsiElement getOpPlusEq();

  @Nullable
  PsiElement getOpTernary();

  @Nullable
  PsiElement getOpTimes();

  @Nullable
  PsiElement getOpTimesEq();

}
