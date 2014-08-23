package com.plopiplop.leekwars.codeInsight.completion;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.parameterInfo.*;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.tree.TokenSet;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.psi.util.PsiUtilCore;
import com.intellij.util.containers.ContainerUtil;
import com.plopiplop.leekwars.ApiNotFoundException;
import com.plopiplop.leekwars.LeekWarsApi;
import com.plopiplop.leekwars.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class LSFunctionParameterInfoHandler implements ParameterInfoHandler<LSArguments, LSFunctionDeclaration> {
    @Override
    public boolean couldShowInLookup() {
        return true;
    }

    @Nullable
    @Override
    public Object[] getParametersForLookup(LookupElement item, ParameterInfoContext context) {
        return new Object[0];
    }

    @Nullable
    @Override
    public Object[] getParametersForDocumentation(LSFunctionDeclaration p, ParameterInfoContext context) {
        if (p.getFormalParameterList() != null) {
            List<LSParameter> parameters = p.getFormalParameterList().getParameterList();

            return parameters.toArray(new LSParameter[parameters.size()]);
        }

        return new Object[0];
    }

    @Nullable
    @Override
    public LSArguments findElementForParameterInfo(@NotNull CreateParameterInfoContext context) {
        PsiElement elementAtOffset = PsiUtilCore.getElementAtOffset(context.getFile(), context.getOffset());

        LSArguments arguments = PsiTreeUtil.getParentOfType(elementAtOffset, LSArguments.class);

        if (arguments != null) {
            List<LSFunctionDeclaration> declarations = new ArrayList<LSFunctionDeclaration>();

            List<PsiNamedElement> apiCandidates = visitApiFile(context.getProject());
            FindCompletionVisitor visitor = new FindCompletionVisitor();
            context.getFile().accept(visitor);
            List<PsiNamedElement> currentFileCandidates = visitor.namedElements;

            for (PsiNamedElement element : ContainerUtil.concat(currentFileCandidates, apiCandidates)) {
                if (element instanceof LSFunctionDeclaration && element.getName() != null
                        && element.getName().equals(((LSMethodCall) arguments.getParent()).getReferenceExpression().getText())) {
                    declarations.add((LSFunctionDeclaration) element);
                }
            }

            context.setItemsToShow(declarations.toArray());

            return arguments;
        }
        return null;
    }

    private List<PsiNamedElement> visitApiFile(Project project) {
        PsiFile apiFile;
        try {
            apiFile = LeekWarsApi.getApiPsiFile(project);
        } catch (ApiNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        FindCompletionVisitor visitor = new FindCompletionVisitor();
        apiFile.accept(visitor);

        return visitor.namedElements;
    }

    @Override
    public void showParameterInfo(@NotNull LSArguments element, @NotNull CreateParameterInfoContext context) {
        context.showHint(element, element.getTextRange().getStartOffset(), this);
    }

    @Nullable
    @Override
    public LSArguments findElementForUpdatingParameterInfo(@NotNull UpdateParameterInfoContext context) {
        PsiElement elementAtOffset = PsiUtilCore.getElementAtOffset(context.getFile(), context.getOffset());

        return PsiTreeUtil.getParentOfType(elementAtOffset, LSArguments.class);
    }

    @Override
    public void updateParameterInfo(@NotNull LSArguments args, @NotNull UpdateParameterInfoContext context) {
        LSArgumentList argumentList = args.getArgumentList();

        int nbArgs = 0;

        if (argumentList != null) {
            int index = ParameterInfoUtils.getCurrentParameterIndex(args.getArgumentList().getNode(), context.getOffset(), LSTypes.OP_COMMA);
            context.setCurrentParameter(index);

            ASTNode[] commas = argumentList.getNode().getChildren(TokenSet.create(LSTypes.OP_COMMA));
            nbArgs = commas.length + 1;
        }

        Object highlighted = null;

        for (Object object : context.getObjectsToView()) {
            if (object instanceof LSFunctionDeclaration) {
                if (((LSFunctionDeclaration) object).getNbArguments() == nbArgs) {
                    highlighted = object;
                }
            }
        }

        Object firstCandidate = context.getObjectsToView()[0];

        if (highlighted == null && nbArgs > 0 && nbArgs < ((LSFunctionDeclaration) firstCandidate).getNbArguments()) {
            highlighted = firstCandidate;
        }

        context.setHighlightedParameter(highlighted);
    }

    @Nullable
    @Override
    public String getParameterCloseChars() {
        return ParameterInfoUtils.DEFAULT_PARAMETER_CLOSE_CHARS;
    }

    @Override
    public boolean tracksParameterIndex() {
        return true;
    }

    @Override
    public void updateUI(LSFunctionDeclaration function, @NotNull ParameterInfoUIContext context) {
        String params = "<no parameters>";

        int highlightOffsetStart = -1;
        int highlightOffsetEnd = -1;
        boolean isDisabled = false;
        int nbArgs = 0;

        if (context.getParameterOwner() instanceof LSArguments) {
            LSArgumentList argumentList = ((LSArguments) context.getParameterOwner()).getArgumentList();

            if (argumentList != null) {
                ASTNode[] commas = argumentList.getNode().getChildren(TokenSet.create(LSTypes.OP_COMMA));
                nbArgs = commas.length + 1;
            }
        }

        if (function.getFormalParameterList() != null) {
            StringBuilder builder = new StringBuilder();

            int i = 0;
            for (LSParameter parameter : function.getFormalParameterList().getParameterList()) {
                if (i == context.getCurrentParameterIndex()) {
                    highlightOffsetStart = builder.length();
                    highlightOffsetEnd = builder.length() + parameter.getIdentifier().getTextLength();
                }

                builder.append(parameter.getIdentifier().getText()).append(", ");
                i++;
            }

            builder.delete(builder.length() - 2, builder.length());

            params = builder.toString();


            if (nbArgs > function.getFormalParameterList().getParameterList().size()) {
                isDisabled = true;
            }
        } else if (nbArgs > 0) {
            isDisabled = true;
        }

        context.setupUIComponentPresentation(params, highlightOffsetStart, highlightOffsetEnd, isDisabled, false, false, context.getDefaultParameterColor());
    }
}
