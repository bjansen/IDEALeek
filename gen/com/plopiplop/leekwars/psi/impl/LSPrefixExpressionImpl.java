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

public class LSPrefixExpressionImpl extends ASTWrapperPsiElement implements LSPrefixExpression {

  public LSPrefixExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LSVisitor visitor) {
    visitor.visitPrefixExpression(this);
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
  public LSPrefixExpression getPrefixExpression() {
    return findChildByClass(LSPrefixExpression.class);
  }

  @Override
  @Nullable
  public LSPrefixOperator getPrefixOperator() {
    return findChildByClass(LSPrefixOperator.class);
  }

  @Override
  @Nullable
  public LSPrimaryExpression getPrimaryExpression() {
    return findChildByClass(LSPrimaryExpression.class);
  }

  @Override
  @NotNull
  public List<LSSingleExpression> getSingleExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LSSingleExpression.class);
  }

  @Override
  @Nullable
  public LSSuffixExpression getSuffixExpression() {
    return findChildByClass(LSSuffixExpression.class);
  }

}
