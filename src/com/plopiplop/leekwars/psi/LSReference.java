package com.plopiplop.leekwars.psi;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.util.IncorrectOperationException;
import com.plopiplop.leekwars.ApiNotFoundException;
import com.plopiplop.leekwars.LeekWarsApi;
import com.plopiplop.leekwars.codeInsight.resolve.FindDeclarationVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class LSReference extends PsiPolyVariantReferenceBase<PsiElement> {

    public LSReference(PsiElement element, TextRange range) {
        super(element, range);
    }

    @Override
    public PsiElement handleElementRename(String newElementName) throws IncorrectOperationException {
        PsiElement declaration = resolve();
        PsiFile apiPsiFile;
        try {
            apiPsiFile = LeekWarsApi.getApiPsiFile(myElement.getProject());
        } catch (ApiNotFoundException e) {
            apiPsiFile = null;
        }

        if (declaration != null && declaration.getContainingFile().equals(apiPsiFile)) {
            throw new IncorrectOperationException("API variables and functions cannot be renamed");
        }
        PsiElement newIdentifier = PsiUtils.createIdentifierFromText(myElement.getProject(), newElementName);

        myElement.replace(newIdentifier);

        return myElement;
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        return resolve(false);
    }

    public ResolveResult[] resolve(boolean resolveEverywhere) {
        PsiElement parentBlock = myElement;
        Set<PsiElement> elements = new LinkedHashSet<PsiElement>();

        do {
            parentBlock = PsiUtils.findParentBlock(parentBlock);

            FindDeclarationVisitor visitor = new FindDeclarationVisitor(myElement);
            parentBlock.accept(visitor);

            elements.addAll(visitor.getDeclarations());

            if (!resolveEverywhere && !elements.isEmpty()) {
                return toResolveResult(visitor.getDeclarations());
            }
        } while (parentBlock != myElement.getContainingFile());

        elements.addAll(visitIncludedFiles());
        elements.addAll(visitApiFile());

        return toResolveResult(elements);
    }

    @NotNull
    private ResolveResult[] toResolveResult(Collection<PsiElement> elements) {
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

        int i = 0;
        for (PsiElement element : elements) {
            results[i++] = new PsiElementResolveResult(element);
        }

        return results;
    }

    @Nullable
    private PsiElement findExactMethodSignature(Collection<PsiElement> elements) {
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

    private List<PsiElement> visitIncludedFiles() {
        List<PsiElement> resolvedElements = new ArrayList<PsiElement>();

        for (PsiElement includedFile : PsiUtils.getIncludedFilesBefore(myElement)) {
            FindDeclarationVisitor visitor = new FindDeclarationVisitor(myElement);
            includedFile.accept(visitor);
            resolvedElements.addAll(visitor.getDeclarations());
        }

        return resolvedElements;
    }

    private List<PsiElement> visitApiFile() {
        FindDeclarationVisitor visitor = new FindDeclarationVisitor(myElement);
        PsiFile apiFile;

        try {
            apiFile = LeekWarsApi.getApiPsiFile(myElement.getProject());
        } catch (ApiNotFoundException e) {
            return Collections.emptyList();
        }

        apiFile.accept(visitor);

        return visitor.getDeclarations();
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        return PsiElement.EMPTY_ARRAY;
    }
}
