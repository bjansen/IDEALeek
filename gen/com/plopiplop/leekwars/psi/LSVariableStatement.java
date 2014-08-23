// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface LSVariableStatement extends PsiElement {

  @Nullable
  LSEos getEos();

  @NotNull
  LSModifier getModifier();

  @NotNull
  List<LSVariableDeclaration> getVariableDeclarationList();

  boolean isGlobal();

}
