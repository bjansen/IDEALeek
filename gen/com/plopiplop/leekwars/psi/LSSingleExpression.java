// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface LSSingleExpression extends PsiElement {

  @Nullable
  LSAdditiveExpression getAdditiveExpression();

  @Nullable
  LSAssignExpression getAssignExpression();

  @Nullable
  LSBitwiseExpression getBitwiseExpression();

  @Nullable
  LSCompareExpression getCompareExpression();

  @Nullable
  LSLogicAndExpression getLogicAndExpression();

  @Nullable
  LSLogicOrExpression getLogicOrExpression();

  @Nullable
  LSMultiplicativeExpression getMultiplicativeExpression();

  @Nullable
  LSPrefixExpression getPrefixExpression();

  @Nullable
  LSShiftExpression getShiftExpression();

  @Nullable
  LSTernaryExpression getTernaryExpression();

}
