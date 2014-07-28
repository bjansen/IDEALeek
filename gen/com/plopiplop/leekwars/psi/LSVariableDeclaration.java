// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;

public interface LSVariableDeclaration extends LSNamedElement {

  @Nullable
  LSInitialiser getInitialiser();

  @NotNull
  PsiElement getIdentifier();

  ItemPresentation getPresentation();

}
