package com.plopiplop.leekwars.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.util.PsiTreeUtil;
import com.plopiplop.leekwars.language.LSFileType;
import com.plopiplop.leekwars.psi.impl.LSVariableStatementImpl;

public class PsiUtils {

    public static PsiElement findParentBlock(PsiElement element) {
        return PsiTreeUtil.getParentOfType(element, LSFunctionDeclaration.class, LSThenBlock.class,
                LSElseBlock.class, LSWhileStatement.class, LSForStatement.class, LSFile.class, LSDoWhileStatement.class);
    }

    public static PsiElement createIdentifierFromText(Project project, String identifier) {
        PsiFile dummyFile = createDummyFile(project, "dummy.lks", "var " + identifier + ";");
        return ((LSVariableStatementImpl) dummyFile.getFirstChild()).getVariableDeclarationList().get(0).getIdentifier();
    }

    public static PsiFile createDummyFile(Project project, String name, String text) {
        return PsiFileFactory.getInstance(project).createFileFromText(name, LSFileType.INSTANCE, text);
    }

    public static boolean isInFunction(PsiElement element) {
        return PsiTreeUtil.getParentOfType(element, LSFunctionDeclaration.class) != null;
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
}
