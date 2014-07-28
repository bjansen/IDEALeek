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

public class LSReturnStatementImpl extends ASTWrapperPsiElement implements LSReturnStatement {

  public LSReturnStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LSVisitor) ((LSVisitor)visitor).visitReturnStatement(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public LSEos getEos() {
    return findChildByClass(LSEos.class);
  }

  @Override
  @Nullable
  public LSExpressionSequence getExpressionSequence() {
    return findChildByClass(LSExpressionSequence.class);
  }

  @Override
  @NotNull
  public PsiElement getKwReturn() {
    return findNotNullChildByType(KW_RETURN);
  }

}
