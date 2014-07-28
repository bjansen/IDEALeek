// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LSVariableReference extends LSNamedElement {

  @NotNull
  List<LSExpressionSequence> getExpressionSequenceList();

  @NotNull
  PsiElement getIdentifier();

}
