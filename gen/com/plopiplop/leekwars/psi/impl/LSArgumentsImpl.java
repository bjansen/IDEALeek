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

public class LSArgumentsImpl extends ASTWrapperPsiElement implements LSArguments {

  public LSArgumentsImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LSVisitor visitor) {
    visitor.visitArguments(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LSVisitor) accept((LSVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public LSArgumentList getArgumentList() {
    return findChildByClass(LSArgumentList.class);
  }

  @Override
  @NotNull
  public PsiElement getOpLparen() {
    return findNotNullChildByType(OP_LPAREN);
  }

  @Override
  @NotNull
  public PsiElement getOpRparen() {
    return findNotNullChildByType(OP_RPAREN);
  }

}
