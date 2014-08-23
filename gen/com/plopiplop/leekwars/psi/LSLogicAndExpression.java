// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LSLogicAndExpression extends PsiElement {

  @NotNull
  List<LSAdditiveExpression> getAdditiveExpressionList();

  @NotNull
  List<LSBitwiseExpression> getBitwiseExpressionList();

  @NotNull
  List<LSCompareExpression> getCompareExpressionList();

  @Nullable
  LSLogicAndExpression getLogicAndExpression();

  @NotNull
  List<LSMultiplicativeExpression> getMultiplicativeExpressionList();

  @NotNull
  List<LSPrefixExpression> getPrefixExpressionList();

  @NotNull
  List<LSShiftExpression> getShiftExpressionList();

  @Nullable
  PsiElement getOpAnd();

  @Nullable
  PsiElement getOpLogicalAnd();

}
