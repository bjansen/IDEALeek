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
    public void visitFunctionDeclaration(@NotNull LSFunctionDeclaration decl) {
        List<LSVariableStatement> variableStatements = decl.getFunctionBody().getVariableStatementList();

        for (LSVariableStatement variableStatement : variableStatements) {
            for (LSVariableDeclaration declaration : variableStatement.getVariableDeclarationList().getVariableDeclarationList()) {
                if (declaration.getIdentifier().getText().equals(element.getText())) {
                    this.declaration = declaration;
                }
            }
        }
    }

    @Override
    public void visitFile(PsiFile file) {
        for (PsiElement psiElement : file.getChildren()) {
            if (psiElement instanceof LSVariableStatement) {
                LSVariableStatement variableStatement = (LSVariableStatement) psiElement;

                for (LSVariableDeclaration declaration : variableStatement.getVariableDeclarationList().getVariableDeclarationList()) {
                    if (declaration.getIdentifier().getText().equals(element.getText())) {
                        this.declaration = declaration;
                    }
                }
            }
        }
    }

    public PsiElement getDeclaration() {
        return declaration;
    }
}
