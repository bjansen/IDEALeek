package com.plopiplop.leekwars.doc;

import com.intellij.lang.documentation.AbstractDocumentationProvider;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.plopiplop.leekwars.model.AbstractItem;
import com.plopiplop.leekwars.model.Chip;
import com.plopiplop.leekwars.model.ModelManager;
import com.plopiplop.leekwars.model.Weapon;
import com.plopiplop.leekwars.psi.LSFunctionDeclaration;
import com.plopiplop.leekwars.psi.LSTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LSDocumentationProvider extends AbstractDocumentationProvider {

    @Override
    public String getQuickNavigateInfo(PsiElement element, PsiElement originalElement) {
        if (element instanceof LSFunctionDeclaration) {
            return "Function " + ((LSFunctionDeclaration) element).getSignature();
        }

        return null; // The "type" returned by LSFindUsagesProvider will be used by default
    }

    @Override
    public String generateDoc(PsiElement element, @Nullable PsiElement originalElement) {
        if (element.getNode().getElementType() == LSTypes.IDENTIFIER) {
            if (element.getText().startsWith("WEAPON_")) {
                Weapon weapon = ModelManager.getInstance(element.getProject()).getWeapon(element.getText());

                if (weapon != null) {
                    return formatAbstractItem(weapon);
                }
            } else if (element.getText().startsWith("CHIP_")) {
                Chip chip = ModelManager.getInstance(element.getProject()).getChip(element.getText());

                if (chip != null) {
                    return formatAbstractItem(chip);
                }
            }
        }

        return null;
    }

    @Nullable
    @Override
    public PsiElement getCustomDocumentationElement(@NotNull Editor editor, @NotNull PsiFile file, @Nullable PsiElement contextElement) {
        return contextElement;
    }

    private String formatAbstractItem(AbstractItem item) {
        return String.format("<b>%s</b> (%s)<br/><p><i>%s</i></p>%s / %shabs", item.name, item.id, item.description, item.level, item.price);
    }
}
