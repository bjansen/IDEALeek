// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface LSVariableDeclaration extends LSNamedElement {

  @Nullable
  LSInitialiser getInitialiser();

  @NotNull
  PsiElement getIdentifier();

  ItemPresentation getPresentation();

}
