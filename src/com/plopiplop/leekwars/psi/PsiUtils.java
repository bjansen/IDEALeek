package com.plopiplop.leekwars.psi;

import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;

public class PsiUtils {

    public static PsiElement findParentBlock(PsiElement element) {
        return PsiTreeUtil.getParentOfType(element, LSFunctionDeclaration.class, LSThenBlock.class,
                LSElseBlock.class, LSWhileStatement.class, LSForStatement.class, LSFile.class);
    }
}
