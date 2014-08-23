package com.plopiplop.leekwars.editor;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.plopiplop.leekwars.parser.LeekScriptLexer;
import com.plopiplop.leekwars.psi.LSTypes;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class LSSyntaxHighlighter extends SyntaxHighlighterBase {

    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{HighlighterColors.BAD_CHARACTER};
    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{DefaultLanguageHighlighterColors.KEYWORD};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{DefaultLanguageHighlighterColors.LINE_COMMENT};
    private static final TextAttributesKey[] MULTI_COMMENT_KEYS = new TextAttributesKey[]{DefaultLanguageHighlighterColors.DOC_COMMENT};
    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{DefaultLanguageHighlighterColors.NUMBER};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{DefaultLanguageHighlighterColors.STRING};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    private static final List<IElementType> KEYWORDS = Arrays.asList(
            LSTypes.KW_FUNCTION, LSTypes.KW_VAR, LSTypes.KW_GLOBAL, LSTypes.KW_IF, LSTypes.KW_ELSE,
            LSTypes.KW_WHILE, LSTypes.KW_FOR, LSTypes.KW_NULL, LSTypes.KW_DO, LSTypes.KW_IN, LSTypes.KW_INCLUDE,
            LSTypes.KW_TRUE, LSTypes.KW_FALSE, LSTypes.KW_RETURN, LSTypes.KW_BREAK, LSTypes.KW_CONTINUE,
            LSTypes.OP_NOT, LSTypes.OP_AND, LSTypes.OP_OR
    );

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new LeekScriptLexer();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (KEYWORDS.contains(tokenType)) {
            return KEYWORD_KEYS;
        } else if (tokenType.equals(LSTypes.COMMENT)) {
            return COMMENT_KEYS;
        } else if (tokenType.equals(LSTypes.DOC_COMMENT) || tokenType.equals(LSTypes.C_STYLE_COMMENT)) {
            return MULTI_COMMENT_KEYS;
        } else if (tokenType.equals(LSTypes.NUMBER)) {
            return NUMBER_KEYS;
        } else if (tokenType.equals(LSTypes.STRING)) {
            return STRING_KEYS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }
}