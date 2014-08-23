// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LSForStatement extends PsiElement {

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
  LSExpressionStatement getExpressionStatement();

  @NotNull
  List<LSForInitializer> getForInitializerList();

  @Nullable
  LSForStatement getForStatement();

  @Nullable
  LSIfStatement getIfStatement();

  @Nullable
  LSInitialiser getInitialiser();

  @Nullable
  LSReturnStatement getReturnStatement();

  @NotNull
  List<LSSingleExpression> getSingleExpressionList();

  @Nullable
  LSVariableStatement getVariableStatement();

  @Nullable
  LSWhileStatement getWhileStatement();

  @NotNull
  PsiElement getKwFor();

  @Nullable
  PsiElement getKwIn();

  @Nullable
  PsiElement getOpColon();

  @Nullable
  PsiElement getOpLparen();

  @Nullable
  PsiElement getOpRparen();

}
