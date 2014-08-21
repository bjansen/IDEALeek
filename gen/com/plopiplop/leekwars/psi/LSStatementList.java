// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface LSStatementList extends PsiElement {

  @NotNull
  List<LSBreakStatement> getBreakStatementList();

  @NotNull
  List<LSContinueStatement> getContinueStatementList();

  @NotNull
  List<LSDoWhileStatement> getDoWhileStatementList();

  @NotNull
  List<LSEmptyStatement> getEmptyStatementList();

  @NotNull
  List<LSExpressionStatement> getExpressionStatementList();

  @NotNull
  List<LSForStatement> getForStatementList();

  @NotNull
  List<LSIfStatement> getIfStatementList();

  @NotNull
  List<LSReturnStatement> getReturnStatementList();

  @NotNull
  List<LSVariableStatement> getVariableStatementList();

  @NotNull
  List<LSWhileStatement> getWhileStatementList();

}
