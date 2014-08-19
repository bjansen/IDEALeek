package com.plopiplop.leekwars.refactoring;

import com.intellij.lang.LanguageRefactoringSupport;
import com.intellij.lang.refactoring.RefactoringSupportProvider;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.CommandProcessor;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.psi.util.PsiUtilBase;
import com.intellij.refactoring.HelpID;
import com.intellij.refactoring.RefactoringActionHandler;
import com.intellij.refactoring.RefactoringBundle;
import com.intellij.refactoring.rename.inplace.VariableInplaceRenameHandler;
import com.intellij.refactoring.util.CommonRefactoringUtil;
import com.intellij.testFramework.MapDataContext;
import com.plopiplop.leekwars.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.generate.tostring.util.StringUtil;

public class LSIntroduceVariableHandler implements RefactoringActionHandler {

    @Override
    public void invoke(@NotNull final Project project, final Editor editor, final PsiFile file, final DataContext dataContext) {
        final PsiElement statementOrExpression = findParentExpressionOrStatement(editor);

        if (statementOrExpression != null) {
            final LSVariableStatement myVar = PsiUtils.createVariableFromText(project, suggestVarName(statementOrExpression), statementOrExpression.getText());

            CommandProcessor.getInstance().executeCommand(project, new Runnable() {
                @Override
                public void run() {
                    ApplicationManager.getApplication().runWriteAction(new Runnable() {
                        @Override
                        public void run() {
                            introduceVariable(statementOrExpression, myVar, editor, file, project);
                        }
                    });
                }
            }, RefactoringBundle.message("introduce.variable.title"), "LeekScript");
        }
    }

    private void introduceVariable(PsiElement statementOrExpression, LSVariableStatement newVar, Editor editor, PsiFile file, Project project) {
        LSVariableStatement inserted;

        if (statementOrExpression instanceof LSExpressionStatement) {
            inserted = (LSVariableStatement) statementOrExpression.replace(newVar);
        } else {
            PsiElement parentStatement = PsiTreeUtil.getParentOfType(statementOrExpression, LSExpressionStatement.class, LSIfStatement.class, LSWhileStatement.class, LSVariableStatement.class);

            if (parentStatement == null) {
                CommonRefactoringUtil.showErrorHint(project, editor, "I don't know how to extract a variable from this :'(", RefactoringBundle.message("introduce.variable.title"), HelpID.INTRODUCE_VARIABLE);
                return;
            }
            inserted = (LSVariableStatement) parentStatement.getParent().addBefore(newVar, parentStatement);
            statementOrExpression.replace(newVar.getVariableDeclarationList().get(0).getIdentifier());
        }

        PsiElement identifier = inserted.getVariableDeclarationList().get(0).getIdentifier();

        editor.getCaretModel().moveToOffset(inserted.getTextOffset() + 4);

        MapDataContext myDataContext = new MapDataContext();
        myDataContext.put(CommonDataKeys.EDITOR, editor);
        myDataContext.put(CommonDataKeys.PSI_FILE, file);
        myDataContext.put(LangDataKeys.PSI_ELEMENT_ARRAY, new PsiElement[]{inserted.getVariableDeclarationList().get(0)});

        PsiDocumentManager.getInstance(project).doPostponedOperationsAndUnblockDocument(editor.getDocument());

        RefactoringSupportProvider supportProvider = LanguageRefactoringSupport.INSTANCE.forLanguage(newVar.getLanguage());

        if (supportProvider.isInplaceRenameAvailable(inserted.getVariableDeclarationList().get(0), identifier)) {
            new VariableInplaceRenameHandler().invoke(project, editor, file, myDataContext);
        }
    }

    private PsiElement findParentExpressionOrStatement(Editor editor) {
        PsiElement elementAtCaret = PsiUtilBase.getElementAtCaret(editor);

        // TODO suggest parent expressions as well ("1", "1 == 2", "1 == 2 or 3 == 4" etc)
        // TODO find the correct expression when the caret is just before the semicolon
        LSSingleExpression singleExpression = PsiTreeUtil.getParentOfType(elementAtCaret, LSSingleExpression.class);

        if (singleExpression != null) {
            PsiElement parent = singleExpression.getParent();

            if (parent instanceof LSExpressionSequence && parent.getParent() instanceof LSExpressionStatement) {
                return parent.getParent();
            }

            return singleExpression;
        }

        return null;

    }

    private String suggestVarName(PsiElement expression) {
        LSSingleExpression singleExpression = null;

        if (expression instanceof LSExpressionStatement) {
            LSExpressionStatement statement = (LSExpressionStatement) expression;

            singleExpression = statement.getExpressionSequence().getSingleExpressionList().get(0);
        } else if (expression instanceof LSSingleExpression) {
            singleExpression = (LSSingleExpression) expression;
        }

        if (singleExpression != null) {
            if (singleExpression.getSimpleExpression() != null && singleExpression.getSimpleExpression().getVariableReference() != null && singleExpression.getSimpleExpression().getVariableReference().getMethodCall() != null) {
                String functionName = singleExpression.getSimpleExpression().getVariableReference().getMethodCall().getIdentifier().getText();

                if (functionName.startsWith("get")) {
                    return StringUtil.firstLetterToLowerCase(functionName.substring("get".length()));
                }

                // TODO use function's return name (in LeekDoc)
                return StringUtil.firstLetterToLowerCase(functionName);
            }
        }

        // TODO suggest "condition" in if/while
        // TODO suggest name based on function parameter in function calls (LeekDoc)

        return "myVar";
    }

    @Override
    public void invoke(@NotNull Project project, @NotNull PsiElement[] elements, DataContext dataContext) {

    }
}
