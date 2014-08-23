// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.plopiplop.leekwars.psi.LSBlock;
import com.plopiplop.leekwars.psi.LSStatementList;
import com.plopiplop.leekwars.psi.LSVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.plopiplop.leekwars.psi.LSTypes.OP_LBRACE;
import static com.plopiplop.leekwars.psi.LSTypes.OP_RBRACE;

public class LSBlockImpl extends ASTWrapperPsiElement implements LSBlock {

  public LSBlockImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LSVisitor) ((LSVisitor)visitor).visitBlock(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public LSStatementList getStatementList() {
    return findChildByClass(LSStatementList.class);
  }

  @Override
  @NotNull
  public PsiElement getOpLbrace() {
    return findNotNullChildByType(OP_LBRACE);
  }

  @Override
  @NotNull
  public PsiElement getOpRbrace() {
    return findNotNullChildByType(OP_RBRACE);
  }

}
