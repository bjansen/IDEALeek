// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LSSimpleExpression extends PsiElement {

  @Nullable
  LSArrayLiteral getArrayLiteral();

  @Nullable
  LSExpressionSequence getExpressionSequence();

  @Nullable
  LSLiteral getLiteral();

  @Nullable
  LSMethodCall getMethodCall();

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
