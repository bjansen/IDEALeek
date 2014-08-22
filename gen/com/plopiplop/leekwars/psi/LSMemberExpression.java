// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface LSMemberExpression extends PsiElement {

    @Nullable
    LSFunctionExpression getFunctionExpression();

    @Nullable
    LSPrimaryExpression getPrimaryExpression();

    @NotNull
    List<LSSingleExpression> getSingleExpressionList();

}
