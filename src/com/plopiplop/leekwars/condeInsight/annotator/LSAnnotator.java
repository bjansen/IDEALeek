package com.plopiplop.leekwars.condeInsight.annotator;

import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.lang.annotation.Annotation;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.plopiplop.leekwars.psi.LSMethodCall;
import com.plopiplop.leekwars.psi.LSTypes;
import org.jetbrains.annotations.NotNull;

public class LSAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (element.getNode().getElementType() == LSTypes.IDENTIFIER && isNotLama(element)) {
            PsiReference reference = element.getParent().getReference();
            if (reference != null && reference.resolve() == null) {
                Annotation annotation = holder.createErrorAnnotation(element, "Cannot revolve symbol '" + element.getText() + "'");
                annotation.setHighlightType(ProblemHighlightType.LIKE_UNKNOWN_SYMBOL);
            }

            // TODO find unused variables/functions?
        }
    }

    private boolean isNotLama(PsiElement element) {
        return !(element.getText().equals("lama") && element.getParent() instanceof LSMethodCall);
    }
}
