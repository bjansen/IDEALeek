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

public class LSMethodCallImpl extends ASTWrapperPsiElement implements LSMethodCall {

  public LSMethodCallImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LSVisitor visitor) {
    visitor.visitMethodCall(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LSVisitor) accept((LSVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<LSArguments> getArgumentsList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LSArguments.class);
  }

  @Override
  @NotNull
  public LSReferenceExpression getReferenceExpression() {
    return findNotNullChildByClass(LSReferenceExpression.class);
  }

  public int getNbArguments() {
    return LSPsiImplUtil.getNbArguments(this);
  }

}
