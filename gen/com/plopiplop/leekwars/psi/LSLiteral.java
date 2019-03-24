// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;

public interface LSLiteral extends PsiElement {

  @Nullable
  PsiElement getKwFalse();

  @Nullable
  PsiElement getKwNull();

  @Nullable
  PsiElement getKwTrue();

  @Nullable
  PsiElement getNumber();

  @Nullable
  PsiElement getString();

  PsiReference getReference();

}
