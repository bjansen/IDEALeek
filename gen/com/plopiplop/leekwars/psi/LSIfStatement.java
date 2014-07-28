// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LSIfStatement extends PsiElement {

  @Nullable
  LSElseBlock getElseBlock();

  @NotNull
  LSExpressionSequence getExpressionSequence();

  @NotNull
  LSThenBlock getThenBlock();

  @NotNull
  PsiElement getKwIf();

  @NotNull
  PsiElement getOpLparen();

  @NotNull
  PsiElement getOpRparen();

}
