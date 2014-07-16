package com.plopiplop.leekwars.condeInsight.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.completion.util.ParenthesesInsertHandler;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.util.PsiUtilCore;
import com.intellij.util.ProcessingContext;
import com.plopiplop.leekwars.ApiNotFoundException;
import com.plopiplop.leekwars.LeekWarsApi;
import com.plopiplop.leekwars.psi.LSFunctionDeclaration;
import com.plopiplop.leekwars.psi.PsiUtils;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class LSCompletionContributor extends CompletionContributor {

    public LSCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(), new CompletionProvider<CompletionParameters>() {
            @Override
            protected void addCompletions(@NotNull CompletionParameters parameters, ProcessingContext context, @NotNull CompletionResultSet result) {
                PsiElement element = PsiUtilCore.getElementAtOffset(parameters.getOriginalFile(), parameters.getOffset());
                findCompletions(element, result);
                try {
                    findCompletions(LeekWarsApi.getApiPsiFile(parameters.getOriginalFile().getProject()), result);
                } catch (ApiNotFoundException e) {
                    // Not available is leekwars API is not found
                }
            }
        });
    }

    private void findCompletions(PsiElement psiElement, CompletionResultSet result) {
        PsiElement parentBlock = psiElement;

        do {
            if (!(parentBlock instanceof PsiFile)) {
                parentBlock = PsiUtils.findParentBlock(parentBlock);
            }

            FindCompletionVisitor visitor = new FindCompletionVisitor();
            parentBlock.accept(visitor);

            for (PsiNamedElement candidate : visitor.namedElements) {
                String text = candidate.getName();
                String tailText = null;
                Icon icon = candidate.getIcon(0);
                InsertHandler<LookupElement> insertHandler = null;

                if (candidate instanceof LSFunctionDeclaration) {
                    tailText = ((LSFunctionDeclaration) candidate).getSignature().substring(text.length());
                    insertHandler = ParenthesesInsertHandler.getInstance(!tailText.equals("()"));
                }

                result.addElement(LookupElementBuilder.create(text).withIcon(icon).withTailText(tailText).withInsertHandler(insertHandler));
            }
        } while (parentBlock != psiElement.getContainingFile());
    }
}
