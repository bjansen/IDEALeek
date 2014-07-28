// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;

public interface LSFunctionDeclaration extends LSNamedElement {

  @NotNull
  LSBlock getBlock();

  @Nullable
  LSFormalParameterList getFormalParameterList();

  @NotNull
  PsiElement getIdentifier();

  @NotNull
  PsiElement getKwFunction();

  @NotNull
  PsiElement getOpLparen();

  @NotNull
  PsiElement getOpRparen();

  String getSignature();

  int getNbArguments();

  ItemPresentation getPresentation();

}
