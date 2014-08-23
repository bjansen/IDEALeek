// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

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
