// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface LSVariableReference extends LSNamedElement {

    @Nullable
    LSMethodCall getMethodCall();

  @NotNull
  List<LSSingleExpression> getSingleExpressionList();

    @Nullable
    PsiElement getIdentifier();

}
