// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LSSuffixExpression extends PsiElement {

  @Nullable
  LSFunctionExpression getFunctionExpression();

  @Nullable
  LSMethodCall getMethodCall();

  @Nullable
  LSPrimaryExpression getPrimaryExpression();

  @Nullable
  LSSuffixExpression getSuffixExpression();

  @Nullable
  PsiElement getOpDec();

  @Nullable
  PsiElement getOpInc();

}
