// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.plopiplop.leekwars.psi.LSEos;
import com.plopiplop.leekwars.psi.LSReturnStatement;
import com.plopiplop.leekwars.psi.LSSingleExpression;
import com.plopiplop.leekwars.psi.LSVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.plopiplop.leekwars.psi.LSTypes.KW_RETURN;

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
  public LSSingleExpression getSingleExpression() {
      return findChildByClass(LSSingleExpression.class);
  }

  @Override
  @NotNull
  public PsiElement getKwReturn() {
    return findNotNullChildByType(KW_RETURN);
  }

}
