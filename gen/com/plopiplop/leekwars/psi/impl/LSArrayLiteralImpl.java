// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.plopiplop.leekwars.psi.LSArrayLiteral;
import com.plopiplop.leekwars.psi.LSElementList;
import com.plopiplop.leekwars.psi.LSKeyvalList;
import com.plopiplop.leekwars.psi.LSVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.plopiplop.leekwars.psi.LSTypes.OP_LBRACKET;
import static com.plopiplop.leekwars.psi.LSTypes.OP_RBRACKET;

public class LSArrayLiteralImpl extends ASTWrapperPsiElement implements LSArrayLiteral {

  public LSArrayLiteralImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LSVisitor) ((LSVisitor)visitor).visitArrayLiteral(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public LSElementList getElementList() {
    return findChildByClass(LSElementList.class);
  }

    @Override
    @Nullable
    public LSKeyvalList getKeyvalList() {
        return findChildByClass(LSKeyvalList.class);
  }

  @Override
  @NotNull
  public PsiElement getOpLbracket() {
    return findNotNullChildByType(OP_LBRACKET);
  }

  @Override
  @NotNull
  public PsiElement getOpRbracket() {
    return findNotNullChildByType(OP_RBRACKET);
  }

}
