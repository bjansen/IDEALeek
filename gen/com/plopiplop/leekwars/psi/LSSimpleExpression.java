// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface LSSimpleExpression extends PsiElement {

  @Nullable
  LSArrayLiteral getArrayLiteral();

  @Nullable
  LSExpressionSequence getExpressionSequence();

  @Nullable
  LSLiteral getLiteral();

  @Nullable
  LSPostfixOperator getPostfixOperator();

  @Nullable
  LSPrefixOperator getPrefixOperator();

  @Nullable
  LSSingleExpression getSingleExpression();

  @Nullable
  LSVariableReference getVariableReference();

  @Nullable
  PsiElement getOpLparen();

  @Nullable
  PsiElement getOpRparen();

}
