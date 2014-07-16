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
                LSElseBlock.class, LSWhileStatement.class, LSForStatement.class, LSFile.class);
    }

    public static PsiElement createIdentifierFromText(Project project, String identifier) {
        PsiFile dummyFile = createDummyFile(project, "var " + identifier + ";");
        return ((LSVariableStatementImpl) dummyFile.getFirstChild()).getVariableDeclarationList().get(0).getIdentifier();
    }

    private static PsiFile createDummyFile(Project project, String text) {
        return PsiFileFactory.getInstance(project).createFileFromText("dummy.lks", LSFileType.INSTANCE, text);
    }
}
