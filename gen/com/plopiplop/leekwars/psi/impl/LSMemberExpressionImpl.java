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

public class LSMemberExpressionImpl extends ASTWrapperPsiElement implements LSMemberExpression {

  public LSMemberExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LSVisitor) ((LSVisitor)visitor).visitMemberExpression(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public LSFunctionExpression getFunctionExpression() {
    return findChildByClass(LSFunctionExpression.class);
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

}
