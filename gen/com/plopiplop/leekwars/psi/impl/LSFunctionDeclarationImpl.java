// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.plopiplop.leekwars.psi.LSTypes.*;
import com.plopiplop.leekwars.psi.LSNamedElementImpl;
import com.plopiplop.leekwars.psi.*;
import com.intellij.navigation.ItemPresentation;

public class LSFunctionDeclarationImpl extends LSNamedElementImpl implements LSFunctionDeclaration {

  public LSFunctionDeclarationImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LSVisitor) ((LSVisitor)visitor).visitFunctionDeclaration(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public LSBlock getBlock() {
    return findChildByClass(LSBlock.class);
  }

  @Override
  @Nullable
  public LSFormalParameterList getFormalParameterList() {
    return findChildByClass(LSFormalParameterList.class);
  }

  @Override
  @Nullable
  public LSFunctionName getFunctionName() {
    return findChildByClass(LSFunctionName.class);
  }

  @Override
  @NotNull
  public PsiElement getKwFunction() {
    return findNotNullChildByType(KW_FUNCTION);
  }

  @Override
  @Nullable
  public PsiElement getOpLparen() {
    return findChildByType(OP_LPAREN);
  }

  @Override
  @Nullable
  public PsiElement getOpRparen() {
    return findChildByType(OP_RPAREN);
  }

  public String getSignature() {
    return LSPsiImplUtil.getSignature(this);
  }

  public int getNbArguments() {
    return LSPsiImplUtil.getNbArguments(this);
  }

  public ItemPresentation getPresentation() {
    return LSPsiImplUtil.getPresentation(this);
  }

}
