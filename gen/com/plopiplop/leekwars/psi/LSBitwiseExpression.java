// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface LSBitwiseExpression extends PsiElement {

    @NotNull
    List<LSAdditiveExpression> getAdditiveExpressionList();

    @Nullable
    LSBitwiseExpression getBitwiseExpression();

    @NotNull
    List<LSMultiplicativeExpression> getMultiplicativeExpressionList();

    @NotNull
    List<LSPrefixExpression> getPrefixExpressionList();

    @NotNull
    List<LSShiftExpression> getShiftExpressionList();

    @Nullable
    PsiElement getOpBinaryAnd();

    @Nullable
    PsiElement getOpBinaryOr();

    @Nullable
    PsiElement getOpXor();

}
