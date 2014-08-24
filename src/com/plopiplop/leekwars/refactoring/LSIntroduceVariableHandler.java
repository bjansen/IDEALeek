package com.plopiplop.leekwars.refactoring;

import com.intellij.lang.LanguageRefactoringSupport;
import com.intellij.lang.refactoring.RefactoringSupportProvider;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.actionSystem.impl.SimpleDataContext;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.CommandProcessor;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Pass;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.psi.util.PsiUtilBase;
import com.intellij.refactoring.IntroduceTargetChooser;
import com.intellij.refactoring.RefactoringActionHandler;
import com.intellij.refactoring.RefactoringBundle;
import com.intellij.refactoring.rename.inplace.VariableInplaceRenameHandler;
import com.intellij.refactoring.util.CommonRefactoringUtil;
import com.intellij.util.Function;
import com.plopiplop.leekwars.psi.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LSIntroduceVariableHandler implements RefactoringActionHandler {

    @Override
    public void invoke(@NotNull final Project project, final Editor editor, final PsiFile file, final DataContext dataContext) {
        final PsiElement statementOrExpression = findParentExpressionOrStatement(project, editor, file);

        if (statementOrExpression != null) {
            createVarAndIntroduce(project, editor, file, statementOrExpression);
        }
    }

    private void createVarAndIntroduce(final Project project, final Editor editor, final PsiFile file, final PsiElement statementOrExpression) {
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

    private void introduceVariable(PsiElement statementOrExpression, LSVariableStatement newVar, Editor editor, PsiFile file, Project project) {
        LSVariableStatement inserted;

        if (statementOrExpression.getParent() instanceof LSExpressionStatement) {
            inserted = (LSVariableStatement) statementOrExpression.getParent().replace(newVar);
        } else {
            @SuppressWarnings("unchecked")
            PsiElement parentStatement = PsiTreeUtil.getParentOfType(statementOrExpression, LSExpressionStatement.class, LSIfStatement.class, LSWhileStatement.class, LSVariableStatement.class);

            if (parentStatement == null) {
                CommonRefactoringUtil.showErrorHint(project, editor, "I don't know how to extract a variable from this :'(", RefactoringBundle.message("introduce.variable.title"), null);
                return;
            }
            inserted = (LSVariableStatement) parentStatement.getParent().addBefore(newVar, parentStatement);
            statementOrExpression.replace(newVar.getVariableDeclarationList().get(0).getIdentifier());
        }

        PsiElement identifier = inserted.getVariableDeclarationList().get(0).getIdentifier();

        editor.getCaretModel().moveToOffset(inserted.getTextOffset() + 4);

        Map<String, Object> myDataContext = new HashMap<String, Object>();
        myDataContext.put(CommonDataKeys.EDITOR.getName(), editor);
        myDataContext.put(CommonDataKeys.PSI_FILE.getName(), file);
        myDataContext.put(LangDataKeys.PSI_ELEMENT_ARRAY.getName(), new PsiElement[]{inserted.getVariableDeclarationList().get(0)});

        PsiDocumentManager.getInstance(project).doPostponedOperationsAndUnblockDocument(editor.getDocument());

        RefactoringSupportProvider supportProvider = LanguageRefactoringSupport.INSTANCE.forLanguage(newVar.getLanguage());

        if (supportProvider.isInplaceRenameAvailable(inserted.getVariableDeclarationList().get(0), identifier)) {
            new VariableInplaceRenameHandler().invoke(project, editor, file, SimpleDataContext.getSimpleContext(myDataContext, null));
        }
    }

    private PsiElement findParentExpressionOrStatement(final Project project, final Editor editor, final PsiFile file) {
        final PsiElement elementAtCaret = PsiUtilBase.getElementAtCaret(editor);

        List<PsiElement> allParentExpressions = new ArrayList<PsiElement>();
        PsiElement parentExpression = elementAtCaret;
        int lastOffset = elementAtCaret == null ? -1 : elementAtCaret.getTextOffset() + 1;

        while (parentExpression != null) {
            if (parentExpression != elementAtCaret && parentExpression.getTextOffset() < lastOffset) {
                // TODO don't add if this is a method call returning nothing (see LeekDoc)
                allParentExpressions.add(parentExpression);
                lastOffset = parentExpression.getTextOffset();
            }

            //noinspection unchecked
            parentExpression = PsiTreeUtil.getParentOfType(parentExpression, LSFunctionExpression.class, LSSingleExpression.class);
        }

        if (allParentExpressions.isEmpty()) {
            return null;
        } else if (allParentExpressions.size() == 1) {
            return allParentExpressions.get(0);
        } else {
            IntroduceTargetChooser.showChooser(editor, allParentExpressions,
                    new Pass<PsiElement>() {
                        public void pass(final PsiElement selectedValue) {
                            createVarAndIntroduce(project, editor, file, selectedValue);
                        }
                    },
                    new Function<PsiElement, String>() {
                        @Override
                        public String fun(PsiElement element) {
                            return element.getText();
                        }
                    }, "Expressions"
            );
        }
        return null;
    }

    private String suggestVarName(PsiElement expression) {
        LSSingleExpression singleExpression = null;

        if (expression instanceof LSSingleExpression) {
            singleExpression = (LSSingleExpression) expression;
        }

        if (singleExpression != null) {
            if (singleExpression.getPrefixExpression() != null && singleExpression.getPrefixExpression().getMethodCall() != null) {
                String functionName = singleExpression.getPrefixExpression().getMethodCall().getReferenceExpression().getIdentifier().getText();

                if (functionName.startsWith("get")) {
                    return firstLetterToLowerCase(functionName.substring("get".length()));
                }

                // TODO use function's return name (in LeekDoc)
                String lowerCasedName = firstLetterToLowerCase(functionName);

                return lowerCasedName.equals(functionName) ? "my" + functionName : lowerCasedName;
            }
        }

        // TODO suggest "condition" in if/while
        // TODO suggest name based on function parameter in function calls (LeekDoc)

        return expression instanceof LSFunctionExpression ? "myFunc" : "myVar";
    }

    private String firstLetterToLowerCase(String data) {
        String firstLetter = data.substring(0, 1).toLowerCase();
        String restLetters = data.substring(1);
        return firstLetter + restLetters;
    }

    @Override
    public void invoke(@NotNull Project project, @NotNull PsiElement[] elements, DataContext dataContext) {

    }
}
