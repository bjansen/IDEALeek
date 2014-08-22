// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface LSAdditiveExpression extends PsiElement {

    @Nullable
    LSAdditiveExpression getAdditiveExpression();

    @NotNull
    List<LSMultiplicativeExpression> getMultiplicativeExpressionList();

    @NotNull
    List<LSPrefixExpression> getPrefixExpressionList();

    @Nullable
    PsiElement getOpMinus();

    @Nullable
    PsiElement getOpPlus();

}
