// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface LSFunctionExpression extends PsiElement {

    @Nullable
    LSBlock getBlock();

    @Nullable
    LSFormalParameterList getFormalParameterList();

    @NotNull
    PsiElement getKwFunction();

    @Nullable
    PsiElement getOpLparen();

    @Nullable
    PsiElement getOpRparen();

}
