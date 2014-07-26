package com.plopiplop.leekwars.codeInsight.annotator;

import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.lang.annotation.Annotation;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.ResolveResult;
import com.intellij.psi.util.PsiTreeUtil;
import com.plopiplop.leekwars.LeekWarsApi;
import com.plopiplop.leekwars.psi.*;
import org.jetbrains.annotations.NotNull;

public class LSAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (element.getNode().getElementType() == LSTypes.IDENTIFIER && isNotLama(element)) {
            LSReference reference = (LSReference) element.getParent().getReference();

            if (reference != null) {
                ResolveResult[] resolveResults = reference.multiResolve(false);

                if (resolveResults.length == 0) {
                    Annotation annotation = holder.createErrorAnnotation(element, "Cannot revolve symbol '" + element.getText() + "'");
                    annotation.setHighlightType(ProblemHighlightType.LIKE_UNKNOWN_SYMBOL);
                } else if (element.getParent() instanceof LSMethodCall) {
                    LSMethodCall methodCall = (LSMethodCall) element.getParent();

                    if (!hasExactSignature(methodCall, resolveResults)) {
                        holder.createErrorAnnotation(methodCall.getArguments(), "Cannot find function '" + element.getText() + "()' with given parameters");
                    }
                } else {
                    ResolveResult[] allRefs = reference.resolve(true);

                    if (allRefs.length > 1 && !isOverloadedFunctionInApi(allRefs)) {
                        // TODO global var and local var (in function) should not be marked as duplicates
                        holder.createErrorAnnotation(element, "Duplicate function or variable declaration '" + element.getText() + "'");
                    } else if (PsiTreeUtil.getParentOfType(element, LSFunctionDeclaration.class) != null) {
                        LSVariableStatement statement = PsiTreeUtil.getParentOfType(allRefs[0].getElement(), LSVariableStatement.class);

                        if (statement != null && statement.getParent() instanceof PsiFile && !statement.isGlobal()) {
                            holder.createErrorAnnotation(element, "Local variable '" + element.getText() + "' is not reachable inside function");
                        }
                    }
                }
            }

            if (PsiUtils.isGlobalInFunction(element)) {
                holder.createErrorAnnotation(element, "Global variables are not allowed inside function");
            }
            // TODO find unused variables/functions?
        }
    }

    private boolean isOverloadedFunctionInApi(ResolveResult[] results) {
        for (ResolveResult result : results) {
            if (!result.getElement().getContainingFile().getName().equals(LeekWarsApi.LEEKWARS_API_FILE)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasExactSignature(LSMethodCall methodCall, ResolveResult[] results) {
        int nbArguments = methodCall.getNbArguments();

        for (ResolveResult result : results) {
            if (result.getElement() instanceof LSFunctionDeclaration) {
                if (((LSFunctionDeclaration) result.getElement()).getNbArguments() == nbArguments) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isNotLama(PsiElement element) {
        return !(element.getText().equals("lama") && element.getParent() instanceof LSMethodCall);
    }
}
