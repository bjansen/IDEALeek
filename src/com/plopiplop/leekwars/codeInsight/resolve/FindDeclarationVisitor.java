package com.plopiplop.leekwars.codeInsight.resolve;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiTreeUtil;
import com.plopiplop.leekwars.psi.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class FindDeclarationVisitor extends LSVisitor {
    private List<PsiElement> declarations = new ArrayList<PsiElement>();
    private PsiElement element;

    public FindDeclarationVisitor(PsiElement element) {
        this.element = element;
    }

    @Override
    public void visitFile(PsiFile file) {
        for (PsiElement psiElement : file.getChildren()) {
            if (psiElement instanceof LSVariableStatement) {
                if (!((LSVariableStatement) psiElement).isGlobal() && PsiUtils.isInFunction(element)) {
                    continue; // can't resolve to var declared outside of functions
                }
                visitVariableStatement((LSVariableStatement) psiElement);
            } else if (psiElement instanceof LSFunctionDeclaration) {
                LSFunctionName functionName = ((LSFunctionDeclaration) psiElement).getFunctionName();
                if (functionName != null && functionName.getIdentifier().getText().equals(element.getText())) {
                    declarations.add(functionName);
                }
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
        if (decl.getBlock() != null) {
            visitBlock(decl.getBlock());
        }

        LSFunctionName functionName = decl.getFunctionName();
        if (functionName != null && functionName.getIdentifier().getText().equals(element.getText())) {
            declarations.add(functionName);
        }

        if (decl.getFormalParameterList() != null) {
            for (LSParameter parameter : decl.getFormalParameterList().getParameterList()) {
                visitParameter(parameter);
            }
        }
    }

    @Override
    public void visitFunctionExpression(@NotNull LSFunctionExpression expr) {
        if (expr.getBlock() != null) {
            visitBlock(expr.getBlock());
        }

        if (expr.getFormalParameterList() != null) {
            for (LSParameter parameter : expr.getFormalParameterList().getParameterList()) {
                visitParameter(parameter);
            }
        }
    }

    @Override
    public void visitParameter(@NotNull LSParameter param) {
        if (param.getIdentifier().getText().equals(element.getText())) {
            declarations.add(param);
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

        if (innerBlock != null && PsiTreeUtil.getParentOfType(element, LSWhileCondition.class) == null) {
            visitBlock(innerBlock);
        }
    }

    @Override
    public void visitDoWhileStatement(@NotNull LSDoWhileStatement statement) {
        LSBlock innerBlock = statement.getBlock();

        if (innerBlock != null && PsiTreeUtil.getParentOfType(element, LSWhileCondition.class) == null) {
            visitBlock(innerBlock);
        }
    }

    @Override
    public void visitForStatement(@NotNull LSForStatement statement) {
        for (LSForInitializer initializer : statement.getForInitializerList()) {
            visitForInitializer(initializer);
        }
        if (statement.getBlock() != null) {
            visitBlock(statement.getBlock());
        }
    }

    @Override
    public void visitForInitializer(@NotNull LSForInitializer initializer) {
        boolean isDeclaration = initializer.getKwVar() != null;
        if (isDeclaration && initializer.getReferenceExpression().getText().equals(element.getText()) && PsiUtils.isDeclaredBefore(initializer, element)) {
            declarations.add(initializer);
        }
    }

    @Override
    public void visitVariableDeclaration(@NotNull LSVariableDeclaration declaration) {
        if (declaration.getIdentifier().getText().equals(element.getText()) && PsiUtils.isDeclaredBefore(declaration, element)) {
            declarations.add(declaration);
        }
    }

    @Override
    public void visitVariableStatement(@NotNull LSVariableStatement variableStatement) {
        for (LSVariableDeclaration declaration : variableStatement.getVariableDeclarationList()) {
            visitVariableDeclaration(declaration);
        }
    }

    public List<PsiElement> getDeclarations() {
        return declarations;
    }
}
