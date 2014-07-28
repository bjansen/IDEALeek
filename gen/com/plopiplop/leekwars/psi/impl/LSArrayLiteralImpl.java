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
