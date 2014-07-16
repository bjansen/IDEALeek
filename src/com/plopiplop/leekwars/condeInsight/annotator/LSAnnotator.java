package com.plopiplop.leekwars.condeInsight.annotator;

import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.lang.annotation.Annotation;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.ResolveResult;
import com.plopiplop.leekwars.psi.LSFunctionDeclaration;
import com.plopiplop.leekwars.psi.LSMethodCall;
import com.plopiplop.leekwars.psi.LSReference;
import com.plopiplop.leekwars.psi.LSTypes;
import org.jetbrains.annotations.NotNull;

public class LSAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (element.getNode().getElementType() == LSTypes.IDENTIFIER && isNotLama(element)) {
            PsiReference reference = element.getParent().getReference();

            if (reference != null) {
                ResolveResult[] resolveResults = ((LSReference) reference).multiResolve(false);

                if (resolveResults.length == 0) {
                    Annotation annotation = holder.createErrorAnnotation(element, "Cannot revolve symbol '" + element.getText() + "'");
                    annotation.setHighlightType(ProblemHighlightType.LIKE_UNKNOWN_SYMBOL);
                } else if (element.getParent() instanceof LSMethodCall) {
                    LSMethodCall methodCall = (LSMethodCall) element.getParent();

                    if (!hasExactSignature(methodCall, resolveResults)) {
                        holder.createErrorAnnotation(methodCall.getArguments(), "Cannot find function '" + element.getText() + "()' with given parameters");
                    }
                }
            }

            // TODO find unused variables/functions?
        }
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
