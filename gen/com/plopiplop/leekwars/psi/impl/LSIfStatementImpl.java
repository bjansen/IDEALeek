// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.plopiplop.leekwars.psi.LSTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.plopiplop.leekwars.psi.*;

public class LSIfStatementImpl extends ASTWrapperPsiElement implements LSIfStatement {

  public LSIfStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LSVisitor visitor) {
    visitor.visitIfStatement(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LSVisitor) accept((LSVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public LSElseBlock getElseBlock() {
    return findChildByClass(LSElseBlock.class);
  }

  @Override
  @Nullable
  public LSSingleExpression getSingleExpression() {
    return findChildByClass(LSSingleExpression.class);
  }

  @Override
  @Nullable
  public LSThenBlock getThenBlock() {
    return findChildByClass(LSThenBlock.class);
  }

  @Override
  @NotNull
  public PsiElement getKwIf() {
    return findNotNullChildByType(KW_IF);
  }

  @Override
  @Nullable
  public PsiElement getOpLparen() {
    return findChildByType(OP_LPAREN);
  }

  @Override
  @Nullable
  public PsiElement getOpRparen() {
    return findChildByType(OP_RPAREN);
  }

}
