// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public interface LSMethodCall extends PsiElement {

  @NotNull
  LSArguments getArguments();

  @NotNull
  LSReferenceExpression getReferenceExpression();

  int getNbArguments();

}
