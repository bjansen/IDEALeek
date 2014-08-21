package com.plopiplop.leekwars.editor;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilderEx;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.plopiplop.leekwars.psi.LSFunctionDeclaration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LSFoldingBuilder extends FoldingBuilderEx {
    @NotNull
    @Override
    public FoldingDescriptor[] buildFoldRegions(@NotNull PsiElement root, @NotNull Document document, boolean quick) {
        List<FoldingDescriptor> descriptors = new ArrayList<FoldingDescriptor>();
        Collection<LSFunctionDeclaration> declarations = PsiTreeUtil.findChildrenOfType(root, LSFunctionDeclaration.class);

        for (final LSFunctionDeclaration literalExpression : declarations) {
            descriptors.add(new FoldingDescriptor(literalExpression.getNode(),
                    new TextRange(literalExpression.getTextRange().getStartOffset(),
                            literalExpression.getTextRange().getEndOffset())) {
                @Nullable
                @Override
                public String getPlaceholderText() {
                    String formalParams = literalExpression.getFormalParameterList() == null ? "" : literalExpression.getFormalParameterList().getText();
                    String name = literalExpression.getIdentifier() == null ? "?" : literalExpression.getIdentifier().getText();
                    return "function " + name + "(" + formalParams + ")";
                }
            });
        }
        return descriptors.toArray(new FoldingDescriptor[descriptors.size()]);
    }

    @Nullable
    @Override
    public String getPlaceholderText(@NotNull ASTNode node) {
        return "...";
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode node) {
        return false;
    }
}