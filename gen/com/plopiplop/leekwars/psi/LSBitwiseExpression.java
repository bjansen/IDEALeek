// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LSBitwiseExpression extends PsiElement {

  @NotNull
  List<LSAdditiveExpression> getAdditiveExpressionList();

  @Nullable
  LSBitwiseExpression getBitwiseExpression();

  @NotNull
  List<LSMultiplicativeExpression> getMultiplicativeExpressionList();

  @NotNull
  List<LSPrefixExpression> getPrefixExpressionList();

  @NotNull
  List<LSShiftExpression> getShiftExpressionList();

  @Nullable
  PsiElement getOpBinaryAnd();

  @Nullable
  PsiElement getOpBinaryOr();

  @Nullable
  PsiElement getOpXor();

}
