// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import com.plopiplop.leekwars.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.plopiplop.leekwars.psi.LSTypes.*;

public class LSForStatementImpl extends ASTWrapperPsiElement implements LSForStatement {

  public LSForStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LSVisitor) ((LSVisitor)visitor).visitForStatement(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public LSBlock getBlock() {
    return findChildByClass(LSBlock.class);
  }

  @Override
  @Nullable
  public LSBreakStatement getBreakStatement() {
    return findChildByClass(LSBreakStatement.class);
  }

  @Override
  @Nullable
  public LSContinueStatement getContinueStatement() {
    return findChildByClass(LSContinueStatement.class);
  }

  @Override
  @Nullable
  public LSDoWhileStatement getDoWhileStatement() {
    return findChildByClass(LSDoWhileStatement.class);
  }

  @Override
  @Nullable
  public LSEmptyStatement getEmptyStatement() {
    return findChildByClass(LSEmptyStatement.class);
  }

  @Override
  @Nullable
  public LSExpressionStatement getExpressionStatement() {
    return findChildByClass(LSExpressionStatement.class);
  }

  @Override
  @NotNull
  public List<LSForInitializer> getForInitializerList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LSForInitializer.class);
  }

  @Override
  @Nullable
  public LSForStatement getForStatement() {
    return findChildByClass(LSForStatement.class);
  }

  @Override
  @Nullable
  public LSIfStatement getIfStatement() {
    return findChildByClass(LSIfStatement.class);
  }

  @Override
  @Nullable
  public LSInitialiser getInitialiser() {
    return findChildByClass(LSInitialiser.class);
  }

  @Override
  @Nullable
  public LSReturnStatement getReturnStatement() {
    return findChildByClass(LSReturnStatement.class);
  }

  @Override
  @NotNull
  public List<LSSingleExpression> getSingleExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LSSingleExpression.class);
  }

  @Override
  @Nullable
  public LSVariableStatement getVariableStatement() {
    return findChildByClass(LSVariableStatement.class);
  }

  @Override
  @Nullable
  public LSWhileStatement getWhileStatement() {
    return findChildByClass(LSWhileStatement.class);
  }

  @Override
  @NotNull
  public PsiElement getKwFor() {
    return findNotNullChildByType(KW_FOR);
  }

  @Override
  @Nullable
  public PsiElement getKwIn() {
    return findChildByType(KW_IN);
  }

  @Override
  @Nullable
  public PsiElement getOpColon() {
    return findChildByType(OP_COLON);
  }

  @Override
  @Nullable
  public PsiElement getOpLparen() {
    return findChildByType(OP_LPAREN);
  }

  @Override
  @Nullable
  public PsiElement getOpRparen() {
    return findChildByType(OP_RPAREN);
  }

}
