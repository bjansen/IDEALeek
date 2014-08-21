package com.plopiplop.leekwars.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.util.PsiTreeUtil;
import com.plopiplop.leekwars.language.LSFileType;
import com.plopiplop.leekwars.psi.impl.LSVariableStatementImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PsiUtils {

    public static PsiElement findParentBlock(PsiElement element) {
        return PsiTreeUtil.getParentOfType(element, LSFunctionDeclaration.class, LSFunctionExpression.class, LSThenBlock.class,
                LSElseBlock.class, LSWhileStatement.class, LSForStatement.class, LSFile.class, LSDoWhileStatement.class);
    }

    public static PsiElement createIdentifierFromText(Project project, String identifier) {
        PsiFile dummyFile = createDummyFile(project, "dummy.lks", "var " + identifier + ";");
        return ((LSVariableStatementImpl) dummyFile.getFirstChild()).getVariableDeclarationList().get(0).getIdentifier();
    }

    public static LSVariableStatement createVariableFromText(Project project, @NotNull String identifier, @Nullable String initializer) {
        String text = "var " + identifier;

        if (initializer != null) {
            text += "=" + initializer;
        }
        text += ";";

        PsiFile dummyFile = createDummyFile(project, "dummy.lks", text);
        return (LSVariableStatement) dummyFile.getFirstChild();
    }

    public static PsiFile createDummyFile(Project project, String name, String text) {
        return PsiFileFactory.getInstance(project).createFileFromText(name, LSFileType.INSTANCE, text);
    }

    public static boolean isInFunction(PsiElement element) {
        return PsiTreeUtil.getParentOfType(element, LSFunctionDeclaration.class, LSFunctionExpression.class) != null;
    }

    public static boolean isGlobalInFunction(PsiElement element) {
        LSVariableStatement statement = PsiTreeUtil.getParentOfType(element, LSVariableStatement.class);

        return statement != null && statement.isGlobal() && isInFunction(element);
    }

    public static boolean isDeclaredBefore(PsiElement element1, PsiElement element2) {
        if (element1.getContainingFile().equals(element2.getContainingFile())) {
            return element1.getTextOffset() <= element2.getTextOffset();
        }
        return true;
    }

    public static boolean isInLoop(PsiElement element) {
        return PsiTreeUtil.getParentOfType(element, LSWhileStatement.class, LSDoWhileStatement.class, LSForStatement.class) != null;
    }

    public static PsiElement getPrevNonWhiteSpaceSibling(PsiElement element) {
        PsiElement prevSibling = element.getPrevSibling();

        while (prevSibling != null && prevSibling instanceof PsiWhiteSpace) {
            prevSibling = prevSibling.getPrevSibling();
        }

        return prevSibling;
    }

    public static List<PsiElement> getIncludedFilesBefore(PsiElement element) {
        List<PsiElement> files = new ArrayList<PsiElement>();
        int offset = element.getNode().getStartOffset();

        for (LSInclude include : ((LSFile) element.getContainingFile()).findChildrenByClass(LSInclude.class)) {
            if (include.getStartOffsetInParent() > offset) {
                continue;
            }

            LSReferenceString refString = include.getReferenceString();

            if (refString != null) {
                PsiReference reference = refString.getReference();
                if (reference != null) {
                    PsiElement resolve = reference.resolve();

                    if (resolve != null) {
                        files.add(resolve);
                    }
                }
            }
        }

        return files;
    }
}
