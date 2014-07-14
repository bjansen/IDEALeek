package com.plopiplop.leekwars.lang;

import com.intellij.icons.AllIcons;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.structureView.TextEditorBasedStructureViewModel;
import com.intellij.ide.util.treeView.smartTree.ActionPresentation;
import com.intellij.ide.util.treeView.smartTree.ActionPresentationData;
import com.intellij.ide.util.treeView.smartTree.Filter;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.editor.Editor;
import com.intellij.pom.Navigatable;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiNamedElement;
import com.intellij.util.PlatformIcons;
import com.plopiplop.leekwars.psi.LSFunctionDeclaration;
import com.plopiplop.leekwars.psi.LSVariableDeclaration;
import com.plopiplop.leekwars.psi.LSVariableStatement;
import com.plopiplop.leekwars.psi.LSVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class LSStructureViewModel extends TextEditorBasedStructureViewModel {

    protected LSStructureViewModel(Editor editor, PsiFile psiFile) {
        super(editor, psiFile);
    }

    @NotNull
    @Override
    public StructureViewTreeElement getRoot() {
        return new LSStructureViewTreeElement(getPsiFile());
    }

    @NotNull
    @Override
    public Filter[] getFilters() {
        return new Filter[]{
                new LSFilter<>(LSFunctionDeclaration.class, "function declarations"),
                new LSFilter<>(LSVariableDeclaration.class, "variable declarations")
        };
    }

    private static class LSStructureViewTreeElement implements StructureViewTreeElement, ItemPresentation {
        private PsiElement element;

        public LSStructureViewTreeElement(PsiElement element) {
            this.element = element;
        }

        @Override
        public Object getValue() {
            return element;
        }

        @Override
        public void navigate(boolean requestFocus) {
            ((Navigatable) element).navigate(requestFocus);
        }

        @Override
        public boolean canNavigate() {
            return ((Navigatable) element).canNavigate();
        }

        @Override
        public boolean canNavigateToSource() {
            return ((Navigatable) element).canNavigateToSource();
        }

        @NotNull
        @Override
        public ItemPresentation getPresentation() {
            return this;
        }

        @NotNull
        @Override
        public TreeElement[] getChildren() {
            final List<PsiElement> childrenElements = new ArrayList<>();

            element.acceptChildren(new LSVisitor() {
                @Override
                public void visitPsiElement(@NotNull PsiElement psi) {
                    if (psi instanceof LSFunctionDeclaration) {
                        childrenElements.add(psi);
                    } else if (psi instanceof LSVariableStatement) {
                        LSVariableStatement statement = (LSVariableStatement) psi;

                        if (statement.isGlobal()) {
                            for (LSVariableDeclaration variable : statement.getVariableDeclarationList()) {
                                childrenElements.add(variable);
                            }
                        }
                    }
                }
            });

            StructureViewTreeElement[] children = new StructureViewTreeElement[childrenElements.size()];
            for (int i = 0; i < children.length; i++) {
                children[i] = new LSStructureViewTreeElement(childrenElements.get(i));
            }

            return children;
        }

        @Nullable
        @Override
        public String getPresentableText() {
            if (element instanceof LSFunctionDeclaration) {
                return ((LSFunctionDeclaration) element).getSignature();
            } else if (element instanceof PsiNamedElement) {
                return ((PsiNamedElement) element).getName();
            }

            return "plopiplop";
        }

        @Nullable
        @Override
        public String getLocationString() {
            return null;
        }

        @Nullable
        @Override
        public Icon getIcon(boolean unused) {
            if (element instanceof LSFunctionDeclaration) {
                return PlatformIcons.FUNCTION_ICON;
            }

            return PlatformIcons.VARIABLE_ICON;
        }
    }

    private static class LSFilter<T> implements Filter {
        private Class<T> aClass;
        private String label;

        public LSFilter(Class<T> aClass, String label) {
            this.aClass = aClass;
            this.label = label;
        }

        @Override
        public boolean isVisible(TreeElement treeElement) {
            if (treeElement instanceof LSStructureViewTreeElement) {
                return !aClass.isAssignableFrom(((LSStructureViewTreeElement) treeElement).element.getClass());
            }
            return true;
        }

        @Override
        public boolean isReverted() {
            return true;
        }

        @NotNull
        @Override
        public ActionPresentation getPresentation() {
            return new ActionPresentationData("Show " + label, null, AllIcons.General.HideDown);
        }

        @NotNull
        @Override
        public String getName() {
            return "SHOW_INSTANCE_OF_" + aClass.getSimpleName();
        }
    }
}
