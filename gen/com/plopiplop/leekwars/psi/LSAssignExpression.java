// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface LSAssignExpression extends PsiElement {

    @NotNull
    List<LSAdditiveExpression> getAdditiveExpressionList();

    @Nullable
    LSAssignExpression getAssignExpression();

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

    @NotNull
    List<LSTernaryExpression> getTernaryExpressionList();

    @Nullable
    PsiElement getOpAndEq();

    @Nullable
    PsiElement getOpAssign();

    @Nullable
    PsiElement getOpDivideEq();

    @Nullable
    PsiElement getOpMinusEq();

    @Nullable
    PsiElement getOpOrEq();

    @Nullable
    PsiElement getOpPlusEq();

    @Nullable
    PsiElement getOpTimesEq();

}
