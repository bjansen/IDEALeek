// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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

  @Nullable
  LSSimpleExpression getSimpleExpression();

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
