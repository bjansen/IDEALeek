package com.plopiplop.leekwars.psi;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementResolveResult;
import com.intellij.psi.PsiPolyVariantReferenceBase;
import com.intellij.psi.ResolveResult;
import com.intellij.util.IncorrectOperationException;
import com.plopiplop.leekwars.LeekWarsApi;
import com.plopiplop.leekwars.condeInsight.resolve.FindDeclarationVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LSReference extends PsiPolyVariantReferenceBase<PsiElement> {

    public LSReference(PsiElement element, TextRange range) {
        super(element, range);
    }

    @Override
    public PsiElement handleElementRename(String newElementName) throws IncorrectOperationException {
        PsiElement declaration = resolve();
        if (declaration != null && declaration.getContainingFile().equals(LeekWarsApi.getApiPsiFile(myElement))) {
            throw new IncorrectOperationException("API variables and functions cannot be renamed");
        }
        PsiElement newIdentifier = PsiUtils.createIdentifierFromText(myElement.getProject(), newElementName);

        myElement.replace(newIdentifier);

        return myElement;
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        PsiElement parentBlock = myElement;

        do {
            parentBlock = PsiUtils.findParentBlock(parentBlock);

            FindDeclarationVisitor visitor = new FindDeclarationVisitor(myElement);
            parentBlock.accept(visitor);

            if (!visitor.getDeclarations().isEmpty()) {
                return toResolveResult(visitor.getDeclarations());
            }
        } while (parentBlock != myElement.getContainingFile());

        return toResolveResult(visitApiFile());
    }

    @NotNull
    private ResolveResult[] toResolveResult(List<PsiElement> elements) {
        ResolveResult[] results;

        if (myElement.getParent() instanceof LSMethodCall) {
            PsiElement declaration = findExactMethodSignature(elements);

            if (declaration != null) {
                results = new ResolveResult[1];
                results[0] = new PsiElementResolveResult(declaration);
                return results;
            }
        }

        results = new ResolveResult[elements.size()];
        for (int i = 0, size = elements.size(); i < size; i++) {
            results[i] = new PsiElementResolveResult(elements.get(i));
        }

        return results;
    }

    @Nullable
    private PsiElement findExactMethodSignature(List<PsiElement> elements) {
        LSMethodCall methodCall = (LSMethodCall) myElement.getParent();

        for (PsiElement element : elements) {
            if (element instanceof LSFunctionDeclaration) {
                LSFunctionDeclaration decl = (LSFunctionDeclaration) element;

                if (methodCall.getNbArguments() == decl.getNbArguments()) {
                    return element;
                }
            }
        }

        return null;
    }

    private List<PsiElement> visitApiFile() {
        FindDeclarationVisitor visitor = new FindDeclarationVisitor(myElement);
        LeekWarsApi.getApiPsiFile(myElement).accept(visitor);

        return visitor.getDeclarations();
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        return PsiElement.EMPTY_ARRAY;
    }
}
