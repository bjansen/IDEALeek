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

public class LSSuffixExpressionImpl extends ASTWrapperPsiElement implements LSSuffixExpression {

  public LSSuffixExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LSVisitor visitor) {
    visitor.visitSuffixExpression(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LSVisitor) accept((LSVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public LSFunctionExpression getFunctionExpression() {
    return findChildByClass(LSFunctionExpression.class);
  }

  @Override
  @Nullable
  public LSMethodCall getMethodCall() {
    return findChildByClass(LSMethodCall.class);
  }

  @Override
  @Nullable
  public LSPrimaryExpression getPrimaryExpression() {
    return findChildByClass(LSPrimaryExpression.class);
  }

  @Override
  @Nullable
  public LSSuffixExpression getSuffixExpression() {
    return findChildByClass(LSSuffixExpression.class);
  }

  @Override
  @Nullable
  public PsiElement getOpDec() {
    return findChildByType(OP_DEC);
  }

  @Override
  @Nullable
  public PsiElement getOpInc() {
    return findChildByType(OP_INC);
  }

}
