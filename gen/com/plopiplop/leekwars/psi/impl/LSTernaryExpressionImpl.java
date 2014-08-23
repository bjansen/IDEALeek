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

public class LSTernaryExpressionImpl extends ASTWrapperPsiElement implements LSTernaryExpression {

  public LSTernaryExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LSVisitor) ((LSVisitor)visitor).visitTernaryExpression(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<LSAdditiveExpression> getAdditiveExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LSAdditiveExpression.class);
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
  public LSSingleExpression getSingleExpression() {
    return findNotNullChildByClass(LSSingleExpression.class);
  }

  @Override
  @Nullable
  public LSTernaryExpression getTernaryExpression() {
    return findChildByClass(LSTernaryExpression.class);
  }

  @Override
  @NotNull
  public PsiElement getOpColon() {
    return findNotNullChildByType(OP_COLON);
  }

  @Override
  @NotNull
  public PsiElement getOpTernary() {
    return findNotNullChildByType(OP_TERNARY);
  }

}
