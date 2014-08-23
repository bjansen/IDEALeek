// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LSMultiplicativeExpression extends PsiElement {

  @Nullable
  LSMultiplicativeExpression getMultiplicativeExpression();

  @NotNull
  List<LSPrefixExpression> getPrefixExpressionList();

  @Nullable
  PsiElement getOpDivide();

  @Nullable
  PsiElement getOpModulo();

  @Nullable
  PsiElement getOpPow();

  @Nullable
  PsiElement getOpTimes();

}
