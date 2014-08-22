// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface LSMultiplicativeExpression extends PsiElement {

    @Nullable
    LSMultiplicativeExpression getMultiplicativeExpression();

    @NotNull
    List<LSPrefixExpression> getPrefixExpressionList();

    @Nullable
    PsiElement getOpDivide();

    @Nullable
    PsiElement getOpModulo();

    @Nullable
    PsiElement getOpPow();

    @Nullable
    PsiElement getOpTimes();

}
