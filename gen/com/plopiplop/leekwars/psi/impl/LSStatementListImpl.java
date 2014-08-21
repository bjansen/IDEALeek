// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import com.plopiplop.leekwars.psi.LSBreakStatement;
import com.plopiplop.leekwars.psi.LSContinueStatement;
import com.plopiplop.leekwars.psi.LSDoWhileStatement;
import com.plopiplop.leekwars.psi.LSEmptyStatement;
import com.plopiplop.leekwars.psi.LSExpressionStatement;
import com.plopiplop.leekwars.psi.LSForStatement;
import com.plopiplop.leekwars.psi.LSIfStatement;
import com.plopiplop.leekwars.psi.LSReturnStatement;
import com.plopiplop.leekwars.psi.LSStatementList;
import com.plopiplop.leekwars.psi.LSVariableStatement;
import com.plopiplop.leekwars.psi.LSVisitor;
import com.plopiplop.leekwars.psi.LSWhileStatement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LSStatementListImpl extends ASTWrapperPsiElement implements LSStatementList {

  public LSStatementListImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LSVisitor) ((LSVisitor)visitor).visitStatementList(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<LSBreakStatement> getBreakStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LSBreakStatement.class);
  }

  @Override
  @NotNull
  public List<LSContinueStatement> getContinueStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LSContinueStatement.class);
  }

  @Override
  @NotNull
  public List<LSDoWhileStatement> getDoWhileStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LSDoWhileStatement.class);
  }

  @Override
  @NotNull
  public List<LSEmptyStatement> getEmptyStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LSEmptyStatement.class);
  }

  @Override
  @NotNull
  public List<LSExpressionStatement> getExpressionStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LSExpressionStatement.class);
  }

  @Override
  @NotNull
  public List<LSForStatement> getForStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LSForStatement.class);
  }

  @Override
  @NotNull
  public List<LSIfStatement> getIfStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LSIfStatement.class);
  }

  @Override
  @NotNull
  public List<LSReturnStatement> getReturnStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LSReturnStatement.class);
  }

  @Override
  @NotNull
  public List<LSVariableStatement> getVariableStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LSVariableStatement.class);
  }

  @Override
  @NotNull
  public List<LSWhileStatement> getWhileStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LSWhileStatement.class);
  }

}
