// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import com.plopiplop.leekwars.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.plopiplop.leekwars.psi.LSTypes.IDENTIFIER;

public class LSVariableReferenceImpl extends LSNamedElementImpl implements LSVariableReference {

  public LSVariableReferenceImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LSVisitor) ((LSVisitor)visitor).visitVariableReference(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<LSExpressionSequence> getExpressionSequenceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LSExpressionSequence.class);
  }

  @Override
  @Nullable
  public LSMethodCall getMethodCall() {
      return findChildByClass(LSMethodCall.class);
  }

    @Override
    @Nullable
  public PsiElement getIdentifier() {
        return findChildByType(IDENTIFIER);
  }

}
