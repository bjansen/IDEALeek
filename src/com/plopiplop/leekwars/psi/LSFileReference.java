package com.plopiplop.leekwars.psi;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReferenceBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.regex.Pattern;

public class LSFileReference extends PsiReferenceBase<LSLiteral> {

    public LSFileReference(@NotNull LSLiteral element) {
        super(element, new TextRange(1, element.getTextLength() - 1));
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        PsiFile containingFile = myElement.getContainingFile();
        Pattern pattern = Pattern.compile(String.format("%s__\\d+.lks", myElement.getText().substring(1, myElement.getTextLength() - 1)));

        for (PsiFile file : containingFile.getParent().getFiles()) {
            if (pattern.matcher(file.getName()).matches() && file instanceof LSFile) {
                return file;
            }
        }

        return null;
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        return new Object[0];
    }
}
