// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.plopiplop.leekwars.psi.LSTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.plopiplop.leekwars.psi.*;

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
  public List<LSBlock> getBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LSBlock.class);
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
