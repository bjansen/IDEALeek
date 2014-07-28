package com.plopiplop.leekwars.codeInsight.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.completion.util.ParenthesesInsertHandler;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.ProcessingContext;
import com.plopiplop.leekwars.ApiNotFoundException;
import com.plopiplop.leekwars.LeekWarsApi;
import com.plopiplop.leekwars.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class LSCompletionContributor extends CompletionContributor {

    private static final InsertHandler<LookupElement> SEMICOLON_HANDLER = new InsertHandler<LookupElement>() {
        @Override
        public void handleInsert(InsertionContext context, LookupElement item) {
            final Editor editor = context.getEditor();
            final Document document = editor.getDocument();
            context.commitDocument();
            document.insertString(context.getTailOffset(), ";");
            editor.getCaretModel().moveToOffset(context.getTailOffset());
        }
    };

    public LSCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(), new CompletionProvider<CompletionParameters>() {
            @Override
            protected void addCompletions(@NotNull CompletionParameters parameters, ProcessingContext context, @NotNull CompletionResultSet result) {
                PsiElement element = parameters.getOriginalPosition();
                findCompletions(element, result);
                try {
                    findCompletions(LeekWarsApi.getApiPsiFile(parameters.getOriginalFile().getProject()), result);
                } catch (ApiNotFoundException e) {
                    // Not available is leekwars API is not found
                }

                addKeywords(element, result);
            }
        });
    }

    private void addKeywords(PsiElement element, CompletionResultSet result) {
        if (PsiTreeUtil.getParentOfType(element, LSSingleExpression.class) != null) {
            result.addElement(keyword("null", null));
            result.addElement(keyword("true", null));
            result.addElement(keyword("false", null));
        }
        if (element.getParent() instanceof LSForStatement) {
            result.addElement(keyword("in", null));
        }
        if (PsiUtils.isInLoop(element)) {
            result.addElement(keyword("continue", SEMICOLON_HANDLER));
            result.addElement(keyword("break", SEMICOLON_HANDLER));
        }

        if (PsiTreeUtil.getParentOfType(element, LSFunctionDeclaration.class) != null) {
            result.addElement(keyword("return", SEMICOLON_HANDLER));
        }

        result.addElement(keyword("var", AddSpaceInsertHandler.INSTANCE));
        result.addElement(keyword("global", AddSpaceInsertHandler.INSTANCE));

        if (PsiTreeUtil.getParentOfType(element, LSBlock.class) == null) {
            result.addElement(keyword("function", AddSpaceInsertHandler.INSTANCE));
        }

        result.addElement(keyword("while", ParenthesesInsertHandler.getInstance(true, true, false, true, true)));
        result.addElement(keyword("if", ParenthesesInsertHandler.getInstance(true, true, false, true, true)));
        result.addElement(keyword("for", ParenthesesInsertHandler.getInstance(true, true, false, true, true)));
        result.addElement(keyword("do", AddSpaceInsertHandler.INSTANCE));

        LSExpressionStatement statement = PsiTreeUtil.getParentOfType(element, LSExpressionStatement.class);
        if (statement != null && PsiUtils.getPrevNonWhiteSpaceSibling(statement) instanceof LSIfStatement) {
            result.addElement(keyword("else", AddSpaceInsertHandler.INSTANCE));
        }
    }

    @NotNull
    private LookupElementBuilder keyword(String keyword, @Nullable InsertHandler<LookupElement> handler) {
        return LookupElementBuilder.create(keyword).withInsertHandler(handler).withBoldness(true);
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
