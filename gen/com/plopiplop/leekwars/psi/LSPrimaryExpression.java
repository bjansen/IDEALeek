// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface LSPrimaryExpression extends LSNamedElement {

  @Nullable
  LSArrayLiteral getArrayLiteral();

  @Nullable
  LSLiteral getLiteral();

  @Nullable
  LSSingleExpression getSingleExpression();

  @Nullable
  PsiElement getIdentifier();

  @Nullable
  PsiElement getOpLparen();

  @Nullable
  PsiElement getOpRparen();

}
