// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.plopiplop.leekwars.psi.LSFunctionExpression;
import com.plopiplop.leekwars.psi.LSSimpleExpression;
import com.plopiplop.leekwars.psi.LSSingleExpression;
import com.plopiplop.leekwars.psi.LSVariableReference;
import com.plopiplop.leekwars.psi.LSVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.plopiplop.leekwars.psi.LSTypes.OP_AND;
import static com.plopiplop.leekwars.psi.LSTypes.OP_AND_EQ;
import static com.plopiplop.leekwars.psi.LSTypes.OP_ASSIGN;
import static com.plopiplop.leekwars.psi.LSTypes.OP_BINARY_AND;
import static com.plopiplop.leekwars.psi.LSTypes.OP_BINARY_OR;
import static com.plopiplop.leekwars.psi.LSTypes.OP_COLON;
import static com.plopiplop.leekwars.psi.LSTypes.OP_DIVIDE;
import static com.plopiplop.leekwars.psi.LSTypes.OP_DIVIDE_EQ;
import static com.plopiplop.leekwars.psi.LSTypes.OP_EQUALS;
import static com.plopiplop.leekwars.psi.LSTypes.OP_GE;
import static com.plopiplop.leekwars.psi.LSTypes.OP_GT;
import static com.plopiplop.leekwars.psi.LSTypes.OP_IDENTITY_EQUALS;
import static com.plopiplop.leekwars.psi.LSTypes.OP_IDENTITY_NOT_EQUALS;
import static com.plopiplop.leekwars.psi.LSTypes.OP_LE;
import static com.plopiplop.leekwars.psi.LSTypes.OP_LOGICAL_AND;
import static com.plopiplop.leekwars.psi.LSTypes.OP_LOGICAL_OR;
import static com.plopiplop.leekwars.psi.LSTypes.OP_LSHIFT;
import static com.plopiplop.leekwars.psi.LSTypes.OP_LT;
import static com.plopiplop.leekwars.psi.LSTypes.OP_MINUS;
import static com.plopiplop.leekwars.psi.LSTypes.OP_MINUS_EQ;
import static com.plopiplop.leekwars.psi.LSTypes.OP_MODULO;
import static com.plopiplop.leekwars.psi.LSTypes.OP_NOT_EQUALS;
import static com.plopiplop.leekwars.psi.LSTypes.OP_OR;
import static com.plopiplop.leekwars.psi.LSTypes.OP_OR_EQ;
import static com.plopiplop.leekwars.psi.LSTypes.OP_PLUS;
import static com.plopiplop.leekwars.psi.LSTypes.OP_PLUS_EQ;
import static com.plopiplop.leekwars.psi.LSTypes.OP_POW;
import static com.plopiplop.leekwars.psi.LSTypes.OP_RSHIFT;
import static com.plopiplop.leekwars.psi.LSTypes.OP_TERNARY;
import static com.plopiplop.leekwars.psi.LSTypes.OP_TIMES;
import static com.plopiplop.leekwars.psi.LSTypes.OP_TIMES_EQ;
import static com.plopiplop.leekwars.psi.LSTypes.OP_UNSIGNED_RSHIFT;
import static com.plopiplop.leekwars.psi.LSTypes.OP_XOR;

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
  public LSFunctionExpression getFunctionExpression() {
      return findChildByClass(LSFunctionExpression.class);
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
  public PsiElement getOpAnd() {
      return findChildByType(OP_AND);
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
  public PsiElement getOpDivideEq() {
    return findChildByType(OP_DIVIDE_EQ);
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
  public PsiElement getOpLshift() {
      return findChildByType(OP_LSHIFT);
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
  public PsiElement getOpMinusEq() {
    return findChildByType(OP_MINUS_EQ);
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
    public PsiElement getOpOr() {
        return findChildByType(OP_OR);
  }

  @Override
  @Nullable
  public PsiElement getOpOrEq() {
    return findChildByType(OP_OR_EQ);
  }

  @Override
  @Nullable
  public PsiElement getOpPlus() {
    return findChildByType(OP_PLUS);
  }

  @Override
  @Nullable
  public PsiElement getOpPlusEq() {
    return findChildByType(OP_PLUS_EQ);
  }

  @Override
  @Nullable
  public PsiElement getOpPow() {
      return findChildByType(OP_POW);
  }

    @Override
    @Nullable
    public PsiElement getOpRshift() {
        return findChildByType(OP_RSHIFT);
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

  @Override
  @Nullable
  public PsiElement getOpTimesEq() {
    return findChildByType(OP_TIMES_EQ);
  }

    @Override
    @Nullable
    public PsiElement getOpUnsignedRshift() {
        return findChildByType(OP_UNSIGNED_RSHIFT);
    }

    @Override
    @Nullable
    public PsiElement getOpXor() {
        return findChildByType(OP_XOR);
  }

}
