// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LSSingleExpression extends PsiElement {

  @Nullable
  LSSimpleExpression getSimpleExpression();

  @Nullable
  LSSingleExpression getSingleExpression();

  @Nullable
  LSVariableReference getVariableReference();

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
  PsiElement getOpModulo();

  @Nullable
  PsiElement getOpNotEquals();

  @Nullable
  PsiElement getOpPlus();

  @Nullable
  PsiElement getOpTernary();

  @Nullable
  PsiElement getOpTimes();

}
