// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LSPrefixOperator extends PsiElement {

  @Nullable
  LSPostfixOperator getPostfixOperator();

  @Nullable
  PsiElement getOpMinus();

  @Nullable
  PsiElement getOpNot();

  @Nullable
  PsiElement getOpPlus();

}
