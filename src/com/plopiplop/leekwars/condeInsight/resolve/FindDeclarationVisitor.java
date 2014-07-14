package com.plopiplop.leekwars.condeInsight.resolve;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.plopiplop.leekwars.psi.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FindDeclarationVisitor extends LSVisitor {
    private PsiElement declaration;
    private PsiElement element;

    public FindDeclarationVisitor(PsiElement element) {
        this.element = element;
    }

    @Override
    public void visitFile(PsiFile file) {
        for (PsiElement psiElement : file.getChildren()) {
            if (psiElement instanceof LSVariableStatement) {
                visitVariableStatement((LSVariableStatement) psiElement);
            } else if (psiElement instanceof LSFunctionDeclaration) {
                visitFunctionDeclaration((LSFunctionDeclaration) psiElement);
            }
        }
    }

    @Override
    public void visitBlock(@NotNull LSBlock block) {
        LSStatementList statementList = block.getStatementList();

        if (statementList != null) {
            for (LSVariableStatement variableStatement : statementList.getVariableStatementList()) {
                visitVariableStatement(variableStatement);
            }
        }
    }

    @Override
    public void visitFunctionDeclaration(@NotNull LSFunctionDeclaration decl) {
        List<LSVariableStatement> variableStatements = decl.getFunctionBody().getVariableStatementList();

        if (decl.getIdentifier().getText().equals(element.getText())) {
            if (decl.getIdentifier() == element) {
                this.declaration = decl;
            } else if (element.getParent() instanceof LSMethodCall) {
                LSMethodCall methodCall = (LSMethodCall) element.getParent();
                int expectedNbArgs = 0;

                if (methodCall.getArguments().getArgumentList() != null) {
                    expectedNbArgs = methodCall.getArguments().getArgumentList().getSingleExpressionList().size();
                }

                int declNbArgs = 0;

                if (decl.getFormalParameterList() != null) {
                    declNbArgs = decl.getFormalParameterList().getParameterList().size();
                }

                if (expectedNbArgs == declNbArgs) {
                    this.declaration = decl;
                }
            }
        }

        for (LSVariableStatement variableStatement : variableStatements) {
            visitVariableStatement(variableStatement);
        }

        if (decl.getFormalParameterList() != null) {
            for (LSParameter parameter : decl.getFormalParameterList().getParameterList()) {
                visitParameter(parameter);
            }
        }
    }

    @Override
    public void visitParameter(@NotNull LSParameter param) {
        if (param.getIdentifier().getText().equals(element.getText())) {
            this.declaration = param;
        }
    }

    @Override
    public void visitThenBlock(@NotNull LSThenBlock block) {
        LSBlock innerBlock = block.getBlock();

        if (innerBlock != null) {
            visitBlock(innerBlock);
        }
    }

    @Override
    public void visitElseBlock(@NotNull LSElseBlock block) {
        LSBlock innerBlock = block.getBlock();

        if (innerBlock != null) {
            visitBlock(innerBlock);
        }
    }

    @Override
    public void visitWhileStatement(@NotNull LSWhileStatement statement) {
        LSBlock innerBlock = statement.getBlock();

        if (innerBlock != null) {
            visitBlock(innerBlock);
        }
    }

    @Override
    public void visitForStatement(@NotNull LSForStatement statement) {
        if (statement.getForInitializerDeclaration() != null) {
            visitForInitializerDeclaration(statement.getForInitializerDeclaration());
        }
        if (statement.getBlock() != null) {
            visitBlock(statement.getBlock());
        }
    }

    @Override
    public void visitForInitializerDeclaration(@NotNull LSForInitializerDeclaration initializer) {
        for (LSVariableDeclaration declaration : initializer.getVariableDeclarationList()) {
            visitVariableDeclaration(declaration);
        }
    }

    @Override
    public void visitVariableDeclaration(@NotNull LSVariableDeclaration declaration) {
        if (declaration.getIdentifier().getText().equals(element.getText())) {
            this.declaration = declaration;
        }
    }

    @Override
    public void visitVariableStatement(@NotNull LSVariableStatement variableStatement) {
        for (LSVariableDeclaration declaration : variableStatement.getVariableDeclarationList()) {
            visitVariableDeclaration(declaration);
        }
    }

    public PsiElement getDeclaration() {
        return declaration;
    }
}
