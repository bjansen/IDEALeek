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

public class LSPostfixOperatorImpl extends ASTWrapperPsiElement implements LSPostfixOperator {

  public LSPostfixOperatorImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LSVisitor) ((LSVisitor)visitor).visitPostfixOperator(this);
    else super.accept(visitor);
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