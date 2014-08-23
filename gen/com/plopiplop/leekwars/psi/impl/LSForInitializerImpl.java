// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.plopiplop.leekwars.psi.LSForInitializer;
import com.plopiplop.leekwars.psi.LSNamedElementImpl;
import com.plopiplop.leekwars.psi.LSReferenceExpression;
import com.plopiplop.leekwars.psi.LSVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.plopiplop.leekwars.psi.LSTypes.KW_VAR;

public class LSForInitializerImpl extends LSNamedElementImpl implements LSForInitializer {

  public LSForInitializerImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LSVisitor) ((LSVisitor)visitor).visitForInitializer(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public LSReferenceExpression getReferenceExpression() {
      return findNotNullChildByClass(LSReferenceExpression.class);
  }

  @Override
  @Nullable
  public PsiElement getKwVar() {
    return findChildByType(KW_VAR);
  }

}
