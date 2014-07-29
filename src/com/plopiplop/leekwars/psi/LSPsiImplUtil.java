package com.plopiplop.leekwars.psi;

import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiReference;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class LSPsiImplUtil {

    public static String getSignature(LSFunctionDeclaration declaration) {
        StringBuilder builder = new StringBuilder(declaration.getName());

        builder.append('(');

        if (declaration.getFormalParameterList() != null) {
            for (LSParameter parameter : declaration.getFormalParameterList().getParameterList()) {
                builder.append(parameter.getName()).append(", ");
            }

            builder.delete(builder.length() - 2, builder.length());
        }

        builder.append(')');

        return builder.toString();
    }

    public static int getNbArguments(LSFunctionDeclaration declaration) {
        int nbArgs = 0;

        if (declaration.getFormalParameterList() != null) {
            nbArgs = declaration.getFormalParameterList().getParameterList().size();
        }

        return nbArgs;
    }

    public static int getNbArguments(LSMethodCall methodCall) {
        int nbArgs = 0;

        if (methodCall.getArguments().getArgumentList() != null) {
            nbArgs = methodCall.getArguments().getArgumentList().getSingleExpressionList().size();
        }

        return nbArgs;
    }

    public static ItemPresentation getPresentation(final LSFunctionDeclaration declaration) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return declaration.getSignature();
            }

            @Nullable
            @Override
            public String getLocationString() {
                return null;
            }

            @Nullable
            @Override
            public Icon getIcon(boolean unused) {
                return declaration.getIcon(0);
            }
        };
    }

    public static ItemPresentation getPresentation(final LSVariableDeclaration declaration) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return declaration.getName();
            }

            @Nullable
            @Override
            public String getLocationString() {
                return null;
            }

            @Nullable
            @Override
            public Icon getIcon(boolean unused) {
                return declaration.getIcon(0);
            }
        };
    }

    public static boolean isGlobal(LSVariableStatement statement) {
        return statement.getModifier().getKwGlobal() != null;
    }

    public static PsiReference getReference(final LSReferenceString string) {
        if (string.getParent() instanceof LSInclude) {
            return new LSFileReference(string);
        }
        return null;
    }
}
