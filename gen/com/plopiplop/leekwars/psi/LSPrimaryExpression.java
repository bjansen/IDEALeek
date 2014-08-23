// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LSPrimaryExpression extends PsiElement {

  @Nullable
  LSArrayLiteral getArrayLiteral();

  @Nullable
  LSLiteral getLiteral();

  @Nullable
  LSReferenceExpression getReferenceExpression();

  @Nullable
  LSSingleExpression getSingleExpression();

  @Nullable
  PsiElement getOpLparen();

  @Nullable
  PsiElement getOpRparen();

}
