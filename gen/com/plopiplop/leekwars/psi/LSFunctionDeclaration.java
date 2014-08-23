// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LSFunctionDeclaration extends LSNamedElement {

  @Nullable
  LSBlock getBlock();

  @Nullable
  LSFormalParameterList getFormalParameterList();

  @Nullable
  LSFunctionName getFunctionName();

  @NotNull
  PsiElement getKwFunction();

  @Nullable
  PsiElement getOpLparen();

  @Nullable
  PsiElement getOpRparen();

  String getSignature();

  int getNbArguments();

}
