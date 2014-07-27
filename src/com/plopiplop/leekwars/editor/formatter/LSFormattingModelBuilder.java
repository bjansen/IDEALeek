package com.plopiplop.leekwars.editor.formatter;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.plopiplop.leekwars.language.LeekScriptLanguage;
import com.plopiplop.leekwars.psi.LSTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LSFormattingModelBuilder implements FormattingModelBuilder {
    @NotNull
    @Override
    public FormattingModel createModel(PsiElement element, CodeStyleSettings settings) {
        LSBlock rootBlock = new LSBlock(element.getNode(), Wrap.createWrap(WrapType.NONE, false), Alignment.createAlignment(), createSpaceBuilder(settings));
        return FormattingModelProvider.createFormattingModelForPsiFile(element.getContainingFile(), rootBlock, settings);
    }

    private static SpacingBuilder createSpaceBuilder(CodeStyleSettings settings) {
        return new SpacingBuilder(settings, LeekScriptLanguage.INSTANCE)
                .around(LSTypes.OP_ASSIGN).spaceIf(settings.SPACE_AROUND_ASSIGNMENT_OPERATORS)
                .before(LSTypes.INITIALISER).spaceIf(settings.SPACE_AROUND_ASSIGNMENT_OPERATORS)
                .after(LSTypes.OP_COMMA).spaceIf(settings.SPACE_AFTER_COMMA)
                .before(LSTypes.EOS).spaceIf(settings.SPACE_BEFORE_SEMICOLON)
                .after(LSTypes.VARIABLE_STATEMENT).lineBreakInCode()
                .between(LSTypes.MODIFIER, LSTypes.VARIABLE_DECLARATION).spaces(1)

                .around(LSTypes.OP_PLUS).spaceIf(settings.SPACE_AROUND_ADDITIVE_OPERATORS)
                .around(LSTypes.OP_MINUS).spaceIf(settings.SPACE_AROUND_ADDITIVE_OPERATORS)
                .around(LSTypes.OP_TIMES).spaceIf(settings.SPACE_AROUND_MULTIPLICATIVE_OPERATORS)
                .around(LSTypes.OP_DIVIDE).spaceIf(settings.SPACE_AROUND_MULTIPLICATIVE_OPERATORS)
                .around(LSTypes.OP_MODULO).spaceIf(settings.SPACE_AROUND_MULTIPLICATIVE_OPERATORS)
                .around(LSTypes.OP_BINARY_AND).spaceIf(settings.SPACE_AROUND_BITWISE_OPERATORS)
                .around(LSTypes.OP_BINARY_OR).spaceIf(settings.SPACE_AROUND_BITWISE_OPERATORS)
                .around(LSTypes.OP_LOGICAL_AND).spaceIf(settings.SPACE_AROUND_LOGICAL_OPERATORS)
                .around(LSTypes.OP_LOGICAL_OR).spaceIf(settings.SPACE_AROUND_LOGICAL_OPERATORS)
                .around(LSTypes.OP_EQUALS).spaceIf(settings.SPACE_AROUND_EQUALITY_OPERATORS)
                .around(LSTypes.OP_NOT_EQUALS).spaceIf(settings.SPACE_AROUND_EQUALITY_OPERATORS)
                .around(LSTypes.OP_IDENTITY_EQUALS).spaceIf(settings.SPACE_AROUND_EQUALITY_OPERATORS)
                .around(LSTypes.OP_IDENTITY_NOT_EQUALS).spaceIf(settings.SPACE_AROUND_EQUALITY_OPERATORS)
                .around(LSTypes.OP_LT).spaceIf(settings.SPACE_AROUND_EQUALITY_OPERATORS)
                .around(LSTypes.OP_LE).spaceIf(settings.SPACE_AROUND_EQUALITY_OPERATORS)
                .around(LSTypes.OP_GT).spaceIf(settings.SPACE_AROUND_EQUALITY_OPERATORS)
                .around(LSTypes.OP_GE).spaceIf(settings.SPACE_AROUND_EQUALITY_OPERATORS)

                .after(LSTypes.KW_FOR).spaces(1)
                .around(LSTypes.OP_COLON).spaces(1)
                .between(LSTypes.OP_SEMICOLON, LSTypes.SINGLE_EXPRESSION).spaces(1)
                .between(LSTypes.OP_RPAREN, LSTypes.BLOCK).spaces(1)
                .after(LSTypes.OP_LBRACE).lineBreakInCode()
                .before(LSTypes.OP_RBRACE).lineBreakInCode()
                .after(LSTypes.FOR_STATEMENT).lineBreakInCode()

                .after(LSTypes.KW_IF).spaces(1)
                .before(LSTypes.ELSE_BLOCK).spaces(1)
                .between(LSTypes.OP_RPAREN, LSTypes.THEN_BLOCK).spaces(1)
                .between(LSTypes.KW_ELSE, LSTypes.BLOCK).spaces(1)
                .after(LSTypes.IF_STATEMENT).lineBreakInCode()

                .between(LSTypes.IDENTIFIER, LSTypes.OP_LPAREN).none()
                .after(LSTypes.FUNCTION_DECLARATION).lineBreakInCode()
                .around(LSTypes.FORMAL_PARAMETER_LIST).none()

                .after(LSTypes.KW_WHILE).spaces(1)
                .after(LSTypes.KW_DO).spaces(1)
                .after(LSTypes.WHILE_STATEMENT).lineBreakInCode()
                .after(LSTypes.DO_WHILE_STATEMENT).lineBreakInCode()
                .between(LSTypes.BLOCK, LSTypes.WHILE_CONDITION).spaces(1)
                .after(LSTypes.WHILE_CONDITION).spaces(1)

                .after(LSTypes.EXPRESSION_STATEMENT).lineBreakInCode()
                .after(LSTypes.BREAK_STATEMENT).lineBreakInCode()
                .after(LSTypes.RETURN_STATEMENT).lineBreakInCode()
                ;
    }

    @Nullable
    @Override
    public TextRange getRangeAffectingIndent(PsiFile file, int offset, ASTNode elementAtOffset) {
        return null;
    }
}