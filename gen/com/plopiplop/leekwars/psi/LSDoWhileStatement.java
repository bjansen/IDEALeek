// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface LSDoWhileStatement extends PsiElement {

  @Nullable
  LSBlock getBlock();

  @Nullable
  LSBreakStatement getBreakStatement();

  @Nullable
  LSContinueStatement getContinueStatement();

  @Nullable
  LSDoWhileStatement getDoWhileStatement();

  @Nullable
  LSEmptyStatement getEmptyStatement();

  @Nullable
  LSEos getEos();

  @Nullable
  LSExpressionStatement getExpressionStatement();

  @Nullable
  LSForStatement getForStatement();

  @Nullable
  LSIfStatement getIfStatement();

  @Nullable
  LSReturnStatement getReturnStatement();

  @Nullable
  LSVariableStatement getVariableStatement();

  @Nullable
  LSWhileCondition getWhileCondition();

  @Nullable
  LSWhileStatement getWhileStatement();

  @NotNull
  PsiElement getKwDo();

}
