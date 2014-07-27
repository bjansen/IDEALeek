package com.plopiplop.leekwars.codeInsight.completion;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiNamedElement;
import com.plopiplop.leekwars.psi.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class FindCompletionVisitor extends LSVisitor {

    List<PsiNamedElement> namedElements = new ArrayList<>();

    @Override
    public void visitFile(PsiFile file) {
        for (PsiElement child : file.getChildren()) {
            if (child instanceof LSFunctionDeclaration) {
                namedElements.add((LSFunctionDeclaration) child);
            } else if (child instanceof LSVariableStatement) {
                for (LSVariableDeclaration declaration : ((LSVariableStatement) child).getVariableDeclarationList()) {
                    namedElements.add(declaration);
                }
            }
        }
    }

    @Override
    public void visitVariableStatement(@NotNull LSVariableStatement statement) {
        for (LSVariableDeclaration declaration : statement.getVariableDeclarationList()) {
            namedElements.add(declaration);
        }
    }

    @Override
    public void visitFunctionDeclaration(@NotNull LSFunctionDeclaration function) {
        visitBlock(function.getBlock());

        if (function.getFormalParameterList() != null) {
            for (LSParameter parameter : function.getFormalParameterList().getParameterList()) {
                namedElements.add(parameter);
            }
        }
    }

    @Override
    public void visitWhileStatement(@NotNull LSWhileStatement statement) {
        if (statement.getBlock() != null && statement.getBlock().getStatementList() != null) {
            for (LSVariableStatement variableStatement : statement.getBlock().getStatementList().getVariableStatementList()) {
                visitVariableStatement(variableStatement);
            }
        }
    }

    @Override
    public void visitForStatement(@NotNull LSForStatement statement) {
        if (statement.getBlock() != null && statement.getBlock().getStatementList() != null) {
            for (LSVariableStatement variableStatement : statement.getBlock().getStatementList().getVariableStatementList()) {
                visitVariableStatement(variableStatement);
            }
        }

        for (LSForInitializer initializer : statement.getForInitializerList()) {
            namedElements.add(initializer);
        }
    }

    @Override
    public void visitElseBlock(@NotNull LSElseBlock block) {
        if (block.getBlock() != null && block.getBlock().getStatementList() != null) {
            for (LSVariableStatement variableStatement : block.getBlock().getStatementList().getVariableStatementList()) {
                visitVariableStatement(variableStatement);
            }
        }
    }

    @Override
    public void visitThenBlock(@NotNull LSThenBlock block) {
        if (block.getBlock() != null && block.getBlock().getStatementList() != null) {
            for (LSVariableStatement variableStatement : block.getBlock().getStatementList().getVariableStatementList()) {
                visitVariableStatement(variableStatement);
            }
        }
    }
}
