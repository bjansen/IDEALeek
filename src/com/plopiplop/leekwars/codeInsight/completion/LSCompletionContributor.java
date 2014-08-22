package com.plopiplop.leekwars.codeInsight.completion;

import com.google.common.base.Objects;
import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.codeInsight.completion.InsertHandler;
import com.intellij.codeInsight.completion.InsertionContext;
import com.intellij.codeInsight.completion.util.ParenthesesInsertHandler;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.ProcessingContext;
import com.plopiplop.leekwars.ApiNotFoundException;
import com.plopiplop.leekwars.LeekWarsApi;
import com.plopiplop.leekwars.language.LSIcons;
import com.plopiplop.leekwars.psi.LSBlock;
import com.plopiplop.leekwars.psi.LSExpressionStatement;
import com.plopiplop.leekwars.psi.LSFile;
import com.plopiplop.leekwars.psi.LSForStatement;
import com.plopiplop.leekwars.psi.LSFunctionDeclaration;
import com.plopiplop.leekwars.psi.LSIfStatement;
import com.plopiplop.leekwars.psi.LSReferenceString;
import com.plopiplop.leekwars.psi.LSSingleExpression;
import com.plopiplop.leekwars.psi.LSTypes;
import com.plopiplop.leekwars.psi.PsiUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.regex.Matcher;

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

    private static final InsertHandler<LookupElement> ADD_SPACE_HANDLER = new InsertHandler<LookupElement>() {
        @Override
        public void handleInsert(InsertionContext context, LookupElement item) {
            final Editor editor = context.getEditor();
            final Document document = editor.getDocument();
            context.commitDocument();
            document.insertString(context.getTailOffset(), " ");
            editor.getCaretModel().moveToOffset(context.getTailOffset());
        }
    };

    public LSCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(), new CompletionProvider<CompletionParameters>() {
            @Override
            protected void addCompletions(@NotNull CompletionParameters parameters, ProcessingContext context, @NotNull CompletionResultSet result) {
                PsiElement element = parameters.getOriginalPosition();

                if (element instanceof PsiComment || (element != null && element.getNode().getElementType() == LSTypes.MULTILINE_COMMENT)) {
                    if (parameters.getInvocationCount() < 2) {
                        return;
                    }
                }

                if (element != null && element.getParent() instanceof LSReferenceString) {
                    findFileCompletions(element, result);
                } else {
                    findCompletions(element, result);

                    for (PsiElement includedFile : PsiUtils.getIncludedFilesBefore(element)) {
                        findCompletions(includedFile, result);
                    }

                    try {
                        findCompletions(LeekWarsApi.getApiPsiFile(parameters.getOriginalFile().getProject()), result);
                    } catch (ApiNotFoundException e) {
                        // Not available is leekwars API is not found
                    }

                    addKeywords(element, result);
                }
            }
        });
    }

    private void findFileCompletions(PsiElement element, CompletionResultSet result) {
        for (PsiFile psiFile : element.getContainingFile().getParent().getFiles()) {
            if (!psiFile.equals(element.getContainingFile())) {
                Matcher matcher = LSFile.LKS_FILE_PATTERN.matcher(psiFile.getName());

                if (matcher.matches()) {
                    String name = matcher.group(1);
                    result.addElement(LookupElementBuilder.create(name).withIcon(LSIcons.FILE));
                }
            }
        }
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
            result.addElement(keyword("return", null));
        }

        result.addElement(keyword("var", ADD_SPACE_HANDLER));
        result.addElement(keyword("global", ADD_SPACE_HANDLER));

        if (PsiTreeUtil.getParentOfType(element, LSBlock.class) == null) {
            result.addElement(keyword("function", ADD_SPACE_HANDLER));
            result.addElement(keyword("include", ParenthesesInsertHandler.getInstance(true, false, false, true, true)));
        }

        result.addElement(keyword("while", ParenthesesInsertHandler.getInstance(true, true, false, true, true)));
        result.addElement(keyword("if", ParenthesesInsertHandler.getInstance(true, true, false, true, true)));
        result.addElement(keyword("for", ParenthesesInsertHandler.getInstance(true, true, false, true, true)));
        result.addElement(keyword("do", ADD_SPACE_HANDLER));

        LSExpressionStatement statement = PsiTreeUtil.getParentOfType(element, LSExpressionStatement.class);
        if (statement != null && PsiUtils.getPrevNonWhiteSpaceSibling(statement) instanceof LSIfStatement) {
            result.addElement(keyword("else", ADD_SPACE_HANDLER));
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
                String text = Objects.firstNonNull(candidate.getName(), "<anonymous function>");
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
