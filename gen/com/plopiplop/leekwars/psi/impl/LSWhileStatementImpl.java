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

public class LSWhileStatementImpl extends ASTWrapperPsiElement implements LSWhileStatement {

  public LSWhileStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LSVisitor) ((LSVisitor)visitor).visitWhileStatement(this);
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
  public LSReturnStatement getReturnStatement() {
    return findChildByClass(LSReturnStatement.class);
  }

  @Override
  @Nullable
  public LSVariableStatement getVariableStatement() {
    return findChildByClass(LSVariableStatement.class);
  }

  @Override
  @NotNull
  public LSWhileCondition getWhileCondition() {
    return findNotNullChildByClass(LSWhileCondition.class);
  }

  @Override
  @Nullable
  public LSWhileStatement getWhileStatement() {
    return findChildByClass(LSWhileStatement.class);
  }

}
