package com.plopiplop.leekwars.psi;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceBase;
import com.plopiplop.leekwars.condeInsight.resolve.FindDeclarationVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LSReference extends PsiReferenceBase<PsiElement> {

    public LSReference(PsiElement element, TextRange range) {
        super(element, range);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        PsiElement parentBlock = myElement;

        do {
            parentBlock = PsiUtils.findParentBlock(parentBlock);

            FindDeclarationVisitor visitor = new FindDeclarationVisitor(myElement);
            parentBlock.accept(visitor);

            if (visitor.getDeclaration() != null) {
                return visitor.getDeclaration();
            }
        } while (parentBlock != myElement.getContainingFile());

        return null;
    }

    @Override
    public boolean isReferenceTo(PsiElement element) {
        return resolve() == element;
    }

    @Override
    public boolean isSoft() {
        return super.isSoft();
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        return PsiElement.EMPTY_ARRAY;
    }
}
