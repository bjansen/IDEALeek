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

public class LSAssignExpressionImpl extends ASTWrapperPsiElement implements LSAssignExpression {

  public LSAssignExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LSVisitor visitor) {
    visitor.visitAssignExpression(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LSVisitor) accept((LSVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<LSAdditiveExpression> getAdditiveExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LSAdditiveExpression.class);
  }

  @Override
  @Nullable
  public LSAssignExpression getAssignExpression() {
    return findChildByClass(LSAssignExpression.class);
  }

  @Override
  @NotNull
  public List<LSBitwiseExpression> getBitwiseExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LSBitwiseExpression.class);
  }

  @Override
  @NotNull
  public List<LSCompareExpression> getCompareExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LSCompareExpression.class);
  }

  @Override
  @NotNull
  public List<LSLogicAndExpression> getLogicAndExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LSLogicAndExpression.class);
  }

  @Override
  @NotNull
  public List<LSLogicOrExpression> getLogicOrExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LSLogicOrExpression.class);
  }

  @Override
  @NotNull
  public List<LSMultiplicativeExpression> getMultiplicativeExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LSMultiplicativeExpression.class);
  }

  @Override
  @NotNull
  public List<LSPrefixExpression> getPrefixExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LSPrefixExpression.class);
  }

  @Override
  @NotNull
  public List<LSShiftExpression> getShiftExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LSShiftExpression.class);
  }

  @Override
  @NotNull
  public List<LSTernaryExpression> getTernaryExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LSTernaryExpression.class);
  }

  @Override
  @Nullable
  public PsiElement getOpAndEq() {
    return findChildByType(OP_AND_EQ);
  }

  @Override
  @Nullable
  public PsiElement getOpAssign() {
    return findChildByType(OP_ASSIGN);
  }

  @Override
  @Nullable
  public PsiElement getOpDivideEq() {
    return findChildByType(OP_DIVIDE_EQ);
  }

  @Override
  @Nullable
  public PsiElement getOpMinusEq() {
    return findChildByType(OP_MINUS_EQ);
  }

  @Override
  @Nullable
  public PsiElement getOpOrEq() {
    return findChildByType(OP_OR_EQ);
  }

  @Override
  @Nullable
  public PsiElement getOpPlusEq() {
    return findChildByType(OP_PLUS_EQ);
  }

  @Override
  @Nullable
  public PsiElement getOpTimesEq() {
    return findChildByType(OP_TIMES_EQ);
  }

  @Override
  @Nullable
  public PsiElement getOpXorEq() {
    return findChildByType(OP_XOR_EQ);
  }

}
