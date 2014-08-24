package com.plopiplop.leekwars.editor;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilderEx;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.plopiplop.leekwars.psi.LSFunctionDeclaration;
import com.plopiplop.leekwars.psi.LSFunctionExpression;
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

        for (final LSFunctionDeclaration functionDeclaration : declarations) {
            descriptors.add(new FoldingDescriptor(functionDeclaration.getNode(),
                    new TextRange(functionDeclaration.getTextRange().getStartOffset(),
                            functionDeclaration.getTextRange().getEndOffset())) {
                @Nullable
                @Override
                public String getPlaceholderText() {
                    String formalParams = functionDeclaration.getFormalParameterList() == null ? "" : functionDeclaration.getFormalParameterList().getText();
                    String name = functionDeclaration.getFunctionName() == null ? "?" : functionDeclaration.getFunctionName().getText();
                    return "function " + name + "(" + formalParams + ")";
                }
            });
        }

        Collection<LSFunctionExpression> anonymousFunctions = PsiTreeUtil.findChildrenOfType(root, LSFunctionExpression.class);

        for (final LSFunctionExpression anonymousFunction : anonymousFunctions) {
            descriptors.add(new FoldingDescriptor(anonymousFunction.getNode(),
                    new TextRange(anonymousFunction.getTextRange().getStartOffset(),
                            anonymousFunction.getTextRange().getEndOffset())) {
                @Nullable
                @Override
                public String getPlaceholderText() {
                    String formalParams = anonymousFunction.getFormalParameterList() == null ? "" : anonymousFunction.getFormalParameterList().getText();
                    return "function (" + formalParams + ")";
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