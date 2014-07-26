package com.plopiplop.leekwars.parser;
import com.intellij.lexer.*;
import com.intellij.psi.tree.IElementType;
import static com.plopiplop.leekwars.psi.LSTypes.*;

%%

%{
  public _LeekScriptLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _LeekScriptLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL="\r"|"\n"|"\r\n"
LINE_WS=[\ \t\f]
WHITE_SPACE=({LINE_WS}|{EOL})+

IDENTIFIER=([:letter:]|_)[a-zA-Z_0-9]*
NUMBER=[0-9]+(\.[0-9]*)?
STRING=('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")
COMMENT="//".*
MULTILINE_COMMENT="/"\*([^\*]|\*[^/])*\*"/"

%%
<YYINITIAL> {
  {WHITE_SPACE}            { return com.intellij.psi.TokenType.WHITE_SPACE; }

  "function"               { return KW_FUNCTION; }
  "var"                    { return KW_VAR; }
  "global"                 { return KW_GLOBAL; }
  "if"                     { return KW_IF; }
  "else"                   { return KW_ELSE; }
  "while"                  { return KW_WHILE; }
  "do"                     { return KW_DO; }
  "for"                    { return KW_FOR; }
  "in"                     { return KW_IN; }
  "null"                   { return KW_NULL; }
  "true"                   { return KW_TRUE; }
  "false"                  { return KW_FALSE; }
  "return"                 { return KW_RETURN; }
  "break"                  { return KW_BREAK; }
  "++"                     { return OP_INC; }
  "--"                     { return OP_DEC; }
  "+"                      { return OP_PLUS; }
  "-"                      { return OP_MINUS; }
  "*"                      { return OP_TIMES; }
  "/"                      { return OP_DIVIDE; }
  "%"                      { return OP_MODULO; }
  ";"                      { return OP_SEMICOLON; }
  ":"                      { return OP_COLON; }
  "("                      { return OP_LPAREN; }
  ")"                      { return OP_RPAREN; }
  "["                      { return OP_LBRACKET; }
  "]"                      { return OP_RBRACKET; }
  "{"                      { return OP_LBRACE; }
  "}"                      { return OP_RBRACE; }
  ","                      { return OP_COMMA; }
  "="                      { return OP_ASSIGN; }
  "!"                      { return OP_NOT; }
  "||"                     { return OP_LOGICAL_OR; }
  "&&"                     { return OP_LOGICAL_AND; }
  "<="                     { return OP_LE; }
  "<"                      { return OP_LT; }
  ">="                     { return OP_GE; }
  ">"                      { return OP_GT; }
  "==="                    { return OP_IDENTITY_EQUALS; }
  "=="                     { return OP_EQUALS; }
  "!=="                    { return OP_IDENTITY_NOT_EQUALS; }
  "!="                     { return OP_NOT_EQUALS; }
  "|"                      { return OP_BINARY_OR; }
  "&"                      { return OP_BINARY_AND; }
  "@"                      { return OP_REFERENCE; }

  {IDENTIFIER}             { return IDENTIFIER; }
  {NUMBER}                 { return NUMBER; }
  {STRING}                 { return STRING; }
  {COMMENT}                { return COMMENT; }
  {MULTILINE_COMMENT}      { return MULTILINE_COMMENT; }

  [^] { return com.intellij.psi.TokenType.BAD_CHARACTER; }
}
