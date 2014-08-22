// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface LSTernaryExpression extends PsiElement {

    @NotNull
    List<LSAdditiveExpression> getAdditiveExpressionList();

    @NotNull
    List<LSBitwiseExpression> getBitwiseExpressionList();

    @NotNull
    List<LSCompareExpression> getCompareExpressionList();

    @NotNull
    List<LSLogicAndExpression> getLogicAndExpressionList();

    @NotNull
    List<LSLogicOrExpression> getLogicOrExpressionList();

    @NotNull
    List<LSMultiplicativeExpression> getMultiplicativeExpressionList();

    @NotNull
    List<LSPrefixExpression> getPrefixExpressionList();

    @NotNull
    List<LSShiftExpression> getShiftExpressionList();

    @Nullable
    LSTernaryExpression getTernaryExpression();

    @NotNull
    PsiElement getOpColon();

    @NotNull
    PsiElement getOpTernary();

}
