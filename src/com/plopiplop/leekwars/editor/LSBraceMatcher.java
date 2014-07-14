package com.plopiplop.leekwars.editor;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.plopiplop.leekwars.psi.LSFunctionDeclaration;
import com.plopiplop.leekwars.psi.LSTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LSBraceMatcher implements PairedBraceMatcher {
    private static final BracePair[] BRACE_PAIRS = new BracePair[]{
            new BracePair(LSTypes.OP_LPAREN, LSTypes.OP_RPAREN, false),
            new BracePair(LSTypes.OP_LBRACE, LSTypes.OP_RBRACE, true),
            new BracePair(LSTypes.OP_LBRACKET, LSTypes.OP_RBRACKET, false),
    };

    @Override
    public BracePair[] getPairs() {
        return BRACE_PAIRS;
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType) {
        return true;
    }

    @Override
    public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
        PsiElement element = file.findElementAt(openingBraceOffset);
        if (element == null || element instanceof PsiFile) return openingBraceOffset;
        PsiElement parent = element.getParent();

        if (parent instanceof LSFunctionDeclaration) {
            LSFunctionDeclaration parentDeclaration = (LSFunctionDeclaration) parent;
            PsiElement nameIdentifier = parentDeclaration.getIdentifier();
            return nameIdentifier.getTextOffset();
        }
        return openingBraceOffset;
    }
}
