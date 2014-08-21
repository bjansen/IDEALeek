// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface LSIfStatement extends PsiElement {

  @Nullable
  LSElseBlock getElseBlock();

  @Nullable
  LSSingleExpression getSingleExpression();

  @Nullable
  LSThenBlock getThenBlock();

  @NotNull
  PsiElement getKwIf();

  @Nullable
  PsiElement getOpLparen();

  @Nullable
  PsiElement getOpRparen();

}
