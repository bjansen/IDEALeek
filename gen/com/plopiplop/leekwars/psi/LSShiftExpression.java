// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LSShiftExpression extends PsiElement {

  @NotNull
  List<LSAdditiveExpression> getAdditiveExpressionList();

  @NotNull
  List<LSMultiplicativeExpression> getMultiplicativeExpressionList();

  @NotNull
  List<LSPrefixExpression> getPrefixExpressionList();

  @Nullable
  LSShiftExpression getShiftExpression();

  @Nullable
  PsiElement getOpLshift();

  @Nullable
  PsiElement getOpRshift();

  @Nullable
  PsiElement getOpUnsignedRshift();

}
