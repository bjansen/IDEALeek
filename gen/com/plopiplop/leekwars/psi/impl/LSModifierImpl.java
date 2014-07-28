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

public class LSModifierImpl extends ASTWrapperPsiElement implements LSModifier {

  public LSModifierImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LSVisitor) ((LSVisitor)visitor).visitModifier(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getKwGlobal() {
    return findChildByType(KW_GLOBAL);
  }

  @Override
  @Nullable
  public PsiElement getKwVar() {
    return findChildByType(KW_VAR);
  }

}
