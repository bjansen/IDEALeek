// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LSLogicOrExpression extends PsiElement {

  @NotNull
  List<LSAdditiveExpression> getAdditiveExpressionList();

  @NotNull
  List<LSBitwiseExpression> getBitwiseExpressionList();

  @NotNull
  List<LSCompareExpression> getCompareExpressionList();

  @NotNull
  List<LSLogicAndExpression> getLogicAndExpressionList();

  @Nullable
  LSLogicOrExpression getLogicOrExpression();

  @NotNull
  List<LSMultiplicativeExpression> getMultiplicativeExpressionList();

  @NotNull
  List<LSPrefixExpression> getPrefixExpressionList();

  @NotNull
  List<LSShiftExpression> getShiftExpressionList();

  @Nullable
  PsiElement getOpLogicalOr();

  @Nullable
  PsiElement getOpOr();

}
