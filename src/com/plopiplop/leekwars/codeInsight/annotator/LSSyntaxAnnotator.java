package com.plopiplop.leekwars.codeInsight.annotator;

import com.intellij.lang.annotation.Annotation;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.CodeInsightColors;
import com.intellij.psi.PsiElement;
import com.plopiplop.leekwars.LeekWarsApi;
import com.plopiplop.leekwars.psi.LSFunctionName;
import com.plopiplop.leekwars.psi.LSParameter;
import com.plopiplop.leekwars.psi.LSReference;
import org.jetbrains.annotations.NotNull;

public class LSSyntaxAnnotator {

    public void annotate(@NotNull PsiElement element, LSReference reference, @NotNull AnnotationHolder holder) {
        if (element.getParent() instanceof LSParameter && ((LSParameter) element.getParent()).getOpReference() != null) {
            Annotation annotation = holder.createInfoAnnotation(element.getParent(), null);
            annotation.setTextAttributes(CodeInsightColors.ANNOTATION_NAME_ATTRIBUTES);
        }

        if (element.getText().toUpperCase().equals(element.getText())) {
            Annotation annotation = holder.createInfoAnnotation(element, null);
            annotation.setTextAttributes(DefaultLanguageHighlighterColors.CONSTANT);
        }

        if (reference != null) {
            PsiElement resolve = reference.resolve();
            if (resolve != null && resolve instanceof LSFunctionName && resolve.getContainingFile().getName().equals(LeekWarsApi.LEEKWARS_API_FILE)) {
                Annotation annotation = holder.createInfoAnnotation(element, null);
                annotation.setTextAttributes(DefaultLanguageHighlighterColors.PREDEFINED_SYMBOL);
            }
        }
    }
}
