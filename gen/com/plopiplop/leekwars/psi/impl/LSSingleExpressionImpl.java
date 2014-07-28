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

public class LSSingleExpressionImpl extends ASTWrapperPsiElement implements LSSingleExpression {

  public LSSingleExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LSVisitor) ((LSVisitor)visitor).visitSingleExpression(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public LSSimpleExpression getSimpleExpression() {
    return findChildByClass(LSSimpleExpression.class);
  }

  @Override
  @Nullable
  public LSSingleExpression getSingleExpression() {
    return findChildByClass(LSSingleExpression.class);
  }

  @Override
  @Nullable
  public LSVariableReference getVariableReference() {
    return findChildByClass(LSVariableReference.class);
  }

  @Override
  @Nullable
  public PsiElement getOpAssign() {
    return findChildByType(OP_ASSIGN);
  }

  @Override
  @Nullable
  public PsiElement getOpBinaryAnd() {
    return findChildByType(OP_BINARY_AND);
  }

  @Override
  @Nullable
  public PsiElement getOpBinaryOr() {
    return findChildByType(OP_BINARY_OR);
  }

  @Override
  @Nullable
  public PsiElement getOpColon() {
    return findChildByType(OP_COLON);
  }

  @Override
  @Nullable
  public PsiElement getOpDivide() {
    return findChildByType(OP_DIVIDE);
  }

  @Override
  @Nullable
  public PsiElement getOpEquals() {
    return findChildByType(OP_EQUALS);
  }

  @Override
  @Nullable
  public PsiElement getOpGe() {
    return findChildByType(OP_GE);
  }

  @Override
  @Nullable
  public PsiElement getOpGt() {
    return findChildByType(OP_GT);
  }

  @Override
  @Nullable
  public PsiElement getOpIdentityEquals() {
    return findChildByType(OP_IDENTITY_EQUALS);
  }

  @Override
  @Nullable
  public PsiElement getOpIdentityNotEquals() {
    return findChildByType(OP_IDENTITY_NOT_EQUALS);
  }

  @Override
  @Nullable
  public PsiElement getOpLe() {
    return findChildByType(OP_LE);
  }

  @Override
  @Nullable
  public PsiElement getOpLogicalAnd() {
    return findChildByType(OP_LOGICAL_AND);
  }

  @Override
  @Nullable
  public PsiElement getOpLogicalOr() {
    return findChildByType(OP_LOGICAL_OR);
  }

  @Override
  @Nullable
  public PsiElement getOpLt() {
    return findChildByType(OP_LT);
  }

  @Override
  @Nullable
  public PsiElement getOpMinus() {
    return findChildByType(OP_MINUS);
  }

  @Override
  @Nullable
  public PsiElement getOpModulo() {
    return findChildByType(OP_MODULO);
  }

  @Override
  @Nullable
  public PsiElement getOpNotEquals() {
    return findChildByType(OP_NOT_EQUALS);
  }

  @Override
  @Nullable
  public PsiElement getOpPlus() {
    return findChildByType(OP_PLUS);
  }

  @Override
  @Nullable
  public PsiElement getOpTernary() {
    return findChildByType(OP_TERNARY);
  }

  @Override
  @Nullable
  public PsiElement getOpTimes() {
    return findChildByType(OP_TIMES);
  }

}