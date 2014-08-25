package com.plopiplop.leekwars.lang;

import com.intellij.icons.AllIcons;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.structureView.TextEditorBasedStructureViewModel;
import com.intellij.ide.util.treeView.smartTree.ActionPresentation;
import com.intellij.ide.util.treeView.smartTree.ActionPresentationData;
import com.intellij.ide.util.treeView.smartTree.Filter;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.editor.Editor;
import com.intellij.pom.Navigatable;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.plopiplop.leekwars.psi.LSFunctionDeclaration;
import com.plopiplop.leekwars.psi.LSVariableDeclaration;
import com.plopiplop.leekwars.psi.LSVariableStatement;
import com.plopiplop.leekwars.psi.LSVisitor;
import org.jetbrains.annotations.NotNull;

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
                new LSFilter<LSFunctionDeclaration>(LSFunctionDeclaration.class, "function declarations"),
                new LSFilter<LSVariableDeclaration>(LSVariableDeclaration.class, "variable declarations")
        };
    }

    private static class LSStructureViewTreeElement implements StructureViewTreeElement {
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
            return ((NavigationItem) element).getPresentation();
        }

        @NotNull
        @Override
        public TreeElement[] getChildren() {
            final List<PsiElement> childrenElements = new ArrayList<PsiElement>();

            element.acceptChildren(new LSVisitor() {
                @Override
                public void visitPsiElement(@NotNull PsiElement psi) {
                    if (psi instanceof LSFunctionDeclaration) {
                        childrenElements.add(((LSFunctionDeclaration) psi).getFunctionName());
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
