package com.plopiplop.leekwars.codeInsight.editorActions;

import com.intellij.lang.SmartEnterProcessorWithFixers;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import com.plopiplop.leekwars.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LSSmartEnterProcessor extends SmartEnterProcessorWithFixers {

    private static final Fixer<LSSmartEnterProcessor> SEMICOLON_FIXER = new Fixer<LSSmartEnterProcessor>() {
        @Override
        public void apply(@NotNull Editor editor, @NotNull LSSmartEnterProcessor processor, @NotNull PsiElement element) throws IncorrectOperationException {
            boolean insertSemicolon = false;
            boolean insertBraces = false;
            PsiElement insertBracesAt = element;

            if (element instanceof LSVariableStatement && ((LSVariableStatement) element).getEos() == null) {
                insertSemicolon = true;
            } else if (element instanceof LSBreakStatement && ((LSBreakStatement) element).getEos() == null) {
                insertSemicolon = true;
            } else if (element instanceof LSReturnStatement && ((LSReturnStatement) element).getEos() == null) {
                insertSemicolon = true;
            } else if (element instanceof LSExpressionStatement && ((LSExpressionStatement) element).getEos() == null) {
                insertSemicolon = true;
            } else if (element instanceof LSElseBlock && ((LSElseBlock) element).getBlock() == null) {
                insertBraces = true;
            } else if (element instanceof LSIfStatement) {
                LSIfStatement ifStatement = (LSIfStatement) element;

                if (ifStatement.getThenBlock() == null || ifStatement.getThenBlock().getBlock() == null) {
                    insertBraces = true;
                    insertBracesAt = ifStatement.getOpRparen();
                }
            } else if (element instanceof LSFunctionDeclaration && ((LSFunctionDeclaration) element).getBlock() == null) {
                insertBraces = true;
            } else if (element instanceof LSForStatement && ((LSForStatement) element).getBlock() == null) {
                insertBraces = true;
            } else if (element instanceof LSWhileStatement && ((LSWhileStatement) element).getBlock() == null) {
                insertBraces = true;
            } else if (element instanceof LSDoWhileStatement && ((LSDoWhileStatement) element).getBlock() == null) {
                editor.getDocument().insertString(insertBracesAt.getTextRange().getEndOffset(), "{} while();");
                editor.getCaretModel().moveToOffset(insertBracesAt.getTextRange().getEndOffset() + 9);
                processor.commit(editor);
            }

            if (insertSemicolon) {
                editor.getDocument().insertString(element.getTextRange().getEndOffset(), ";");
                processor.commit(editor);
            }

            if (insertBraces && insertBracesAt != null) {
                editor.getDocument().insertString(insertBracesAt.getTextRange().getEndOffset(), "{}");
                editor.getCaretModel().moveToOffset(insertBracesAt.getTextRange().getEndOffset() + 1);
                processor.commit(editor);
            }
        }
    };

    public static final FixEnterProcessor AFTER_SEMICOLON_ENTER_PROCESSOR = new FixEnterProcessor() {
        @Override
        public boolean doEnter(PsiElement atCaret, PsiFile file, @NotNull Editor editor, boolean modified) {
            if (atCaret instanceof LSVariableStatement || atCaret instanceof LSExpressionStatement
                    || atCaret instanceof LSIfStatement || atCaret instanceof LSFunctionDeclaration || atCaret instanceof LSForStatement
                    || atCaret instanceof LSWhileStatement || atCaret instanceof LSElseBlock) {
                plainEnter(editor);
                return true;
            }

            if (atCaret instanceof LSReturnStatement || atCaret instanceof LSBreakStatement || atCaret instanceof LSDoWhileStatement) {
                return true;
            }

            return false;
        }
    };

    public LSSmartEnterProcessor() {
        addFixers(SEMICOLON_FIXER);
        addEnterProcessors(AFTER_SEMICOLON_ENTER_PROCESSOR);
    }

    @Nullable
    @Override
    protected PsiElement getStatementAtCaret(Editor editor, PsiFile psiFile) {
        PsiElement element = super.getStatementAtCaret(editor, psiFile);

        return PsiTreeUtil.getParentOfType(element, LSBreakStatement.class, LSReturnStatement.class, LSVariableStatement.class, LSElseBlock.class,
                LSIfStatement.class, LSFunctionDeclaration.class, LSExpressionStatement.class, LSForStatement.class, LSWhileStatement.class, LSDoWhileStatement.class);
    }
}
