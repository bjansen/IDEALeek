// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface LSFunctionDeclaration extends LSNamedElement {

    @Nullable
  LSBlock getBlock();

  @Nullable
  LSFormalParameterList getFormalParameterList();

    @Nullable
  PsiElement getIdentifier();

  @NotNull
  PsiElement getKwFunction();

    @Nullable
  PsiElement getOpLparen();

    @Nullable
  PsiElement getOpRparen();

  String getSignature();

  int getNbArguments();

  ItemPresentation getPresentation();

}
