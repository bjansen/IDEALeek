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

public class LSSimpleExpressionImpl extends ASTWrapperPsiElement implements LSSimpleExpression {

  public LSSimpleExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LSVisitor) ((LSVisitor)visitor).visitSimpleExpression(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public LSArrayLiteral getArrayLiteral() {
    return findChildByClass(LSArrayLiteral.class);
  }

  @Override
  @Nullable
  public LSExpressionSequence getExpressionSequence() {
    return findChildByClass(LSExpressionSequence.class);
  }

  @Override
  @Nullable
  public LSLiteral getLiteral() {
    return findChildByClass(LSLiteral.class);
  }

  @Override
  @Nullable
  public LSMethodCall getMethodCall() {
    return findChildByClass(LSMethodCall.class);
  }

  @Override
  @Nullable
  public LSPostfixOperator getPostfixOperator() {
    return findChildByClass(LSPostfixOperator.class);
  }

  @Override
  @Nullable
  public LSPrefixOperator getPrefixOperator() {
    return findChildByClass(LSPrefixOperator.class);
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
  public PsiElement getOpLparen() {
    return findChildByType(OP_LPAREN);
  }

  @Override
  @Nullable
  public PsiElement getOpRparen() {
    return findChildByType(OP_RPAREN);
  }

}
