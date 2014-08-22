// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface LSShiftExpression extends PsiElement {

    @NotNull
    List<LSAdditiveExpression> getAdditiveExpressionList();

    @NotNull
    List<LSMultiplicativeExpression> getMultiplicativeExpressionList();

    @NotNull
    List<LSPrefixExpression> getPrefixExpressionList();

    @Nullable
    LSShiftExpression getShiftExpression();

    @Nullable
    PsiElement getOpLshift();

    @Nullable
    PsiElement getOpRshift();

    @Nullable
    PsiElement getOpUnsignedRshift();

}
