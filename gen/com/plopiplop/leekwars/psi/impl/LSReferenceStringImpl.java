// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiReference;
import com.plopiplop.leekwars.psi.LSPsiImplUtil;
import com.plopiplop.leekwars.psi.LSReferenceString;
import com.plopiplop.leekwars.psi.LSVisitor;
import org.jetbrains.annotations.NotNull;

import static com.plopiplop.leekwars.psi.LSTypes.STRING;

public class LSReferenceStringImpl extends ASTWrapperPsiElement implements LSReferenceString {

  public LSReferenceStringImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LSVisitor) ((LSVisitor)visitor).visitReferenceString(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getString() {
    return findNotNullChildByType(STRING);
  }

  public PsiReference getReference() {
    return LSPsiImplUtil.getReference(this);
  }

}
