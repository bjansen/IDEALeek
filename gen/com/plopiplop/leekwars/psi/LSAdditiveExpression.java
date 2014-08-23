// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LSAdditiveExpression extends PsiElement {

  @Nullable
  LSAdditiveExpression getAdditiveExpression();

  @NotNull
  List<LSMultiplicativeExpression> getMultiplicativeExpressionList();

  @NotNull
  List<LSPrefixExpression> getPrefixExpressionList();

  @Nullable
  PsiElement getOpMinus();

  @Nullable
  PsiElement getOpPlus();

}
