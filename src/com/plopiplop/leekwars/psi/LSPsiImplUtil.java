package com.plopiplop.leekwars.psi;

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

    public static boolean isGlobal(LSVariableStatement statement) {
        return statement.getModifier().getKwGlobal() != null;
    }
}
