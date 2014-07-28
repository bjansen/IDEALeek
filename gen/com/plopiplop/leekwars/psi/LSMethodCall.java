// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LSMethodCall extends LSNamedElement {

  @NotNull
  LSArguments getArguments();

  @NotNull
  PsiElement getIdentifier();

  int getNbArguments();

}
