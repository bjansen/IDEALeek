// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.plopiplop.leekwars.psi.impl.*;

public interface LSTypes {

  IElementType ADDITIVE_EXPRESSION = new LSElementType("ADDITIVE_EXPRESSION");
  IElementType ARGUMENTS = new LSElementType("ARGUMENTS");
  IElementType ARGUMENT_LIST = new LSElementType("ARGUMENT_LIST");
  IElementType ARRAY_LITERAL = new LSElementType("ARRAY_LITERAL");
  IElementType ASSIGN_EXPRESSION = new LSElementType("ASSIGN_EXPRESSION");
  IElementType BITWISE_EXPRESSION = new LSElementType("BITWISE_EXPRESSION");
  IElementType BLOCK = new LSElementType("BLOCK");
  IElementType BREAK_STATEMENT = new LSElementType("BREAK_STATEMENT");
  IElementType COMPARE_EXPRESSION = new LSElementType("COMPARE_EXPRESSION");
  IElementType CONTINUE_STATEMENT = new LSElementType("CONTINUE_STATEMENT");
  IElementType DO_WHILE_STATEMENT = new LSElementType("DO_WHILE_STATEMENT");
  IElementType ELEMENT_LIST = new LSElementType("ELEMENT_LIST");
  IElementType ELSE_BLOCK = new LSElementType("ELSE_BLOCK");
  IElementType EMPTY_STATEMENT = new LSElementType("EMPTY_STATEMENT");
  IElementType EOS = new LSElementType("EOS");
  IElementType EXPRESSION_STATEMENT = new LSElementType("EXPRESSION_STATEMENT");
  IElementType FORMAL_PARAMETER_LIST = new LSElementType("FORMAL_PARAMETER_LIST");
  IElementType FOR_INITIALIZER = new LSElementType("FOR_INITIALIZER");
  IElementType FOR_STATEMENT = new LSElementType("FOR_STATEMENT");
  IElementType FUNCTION_DECLARATION = new LSElementType("FUNCTION_DECLARATION");
  IElementType FUNCTION_EXPRESSION = new LSElementType("FUNCTION_EXPRESSION");
  IElementType FUNCTION_NAME = new LSElementType("FUNCTION_NAME");
  IElementType IF_STATEMENT = new LSElementType("IF_STATEMENT");
  IElementType INITIALISER = new LSElementType("INITIALISER");
  IElementType KEYVAL = new LSElementType("KEYVAL");
  IElementType KEYVAL_LIST = new LSElementType("KEYVAL_LIST");
  IElementType LITERAL = new LSElementType("LITERAL");
  IElementType LOGIC_AND_EXPRESSION = new LSElementType("LOGIC_AND_EXPRESSION");
  IElementType LOGIC_OR_EXPRESSION = new LSElementType("LOGIC_OR_EXPRESSION");
  IElementType METHOD_CALL = new LSElementType("METHOD_CALL");
  IElementType MODIFIER = new LSElementType("MODIFIER");
  IElementType MULTIPLICATIVE_EXPRESSION = new LSElementType("MULTIPLICATIVE_EXPRESSION");
  IElementType PARAMETER = new LSElementType("PARAMETER");
  IElementType PREFIX_EXPRESSION = new LSElementType("PREFIX_EXPRESSION");
  IElementType PREFIX_OPERATOR = new LSElementType("PREFIX_OPERATOR");
  IElementType PRIMARY_EXPRESSION = new LSElementType("PRIMARY_EXPRESSION");
  IElementType REFERENCE_EXPRESSION = new LSElementType("REFERENCE_EXPRESSION");
  IElementType RETURN_STATEMENT = new LSElementType("RETURN_STATEMENT");
  IElementType SHIFT_EXPRESSION = new LSElementType("SHIFT_EXPRESSION");
  IElementType SINGLE_EXPRESSION = new LSElementType("SINGLE_EXPRESSION");
  IElementType STATEMENT_LIST = new LSElementType("STATEMENT_LIST");
  IElementType SUFFIX_EXPRESSION = new LSElementType("SUFFIX_EXPRESSION");
  IElementType TERNARY_EXPRESSION = new LSElementType("TERNARY_EXPRESSION");
  IElementType THEN_BLOCK = new LSElementType("THEN_BLOCK");
  IElementType VARIABLE_DECLARATION = new LSElementType("VARIABLE_DECLARATION");
  IElementType VARIABLE_STATEMENT = new LSElementType("VARIABLE_STATEMENT");
  IElementType WHILE_CONDITION = new LSElementType("WHILE_CONDITION");
  IElementType WHILE_STATEMENT = new LSElementType("WHILE_STATEMENT");

  IElementType COMMENT = new LSTokenType("comment");
  IElementType COMMENT_TAIL = new LSTokenType("comment_tail");
  IElementType C_STYLE_COMMENT = new LSTokenType("c_style_comment");
  IElementType DOC_COMMENT = new LSTokenType("doc_comment");
  IElementType IDENTIFIER = new LSTokenType("identifier");
  IElementType KW_BREAK = new LSTokenType("break");
  IElementType KW_CONTINUE = new LSTokenType("continue");
  IElementType KW_DO = new LSTokenType("do");
  IElementType KW_ELSE = new LSTokenType("else");
  IElementType KW_FALSE = new LSTokenType("false");
  IElementType KW_FOR = new LSTokenType("for");
  IElementType KW_FUNCTION = new LSTokenType("function");
  IElementType KW_GLOBAL = new LSTokenType("global");
  IElementType KW_IF = new LSTokenType("if");
  IElementType KW_IN = new LSTokenType("in");
  IElementType KW_NULL = new LSTokenType("null");
  IElementType KW_RETURN = new LSTokenType("return");
  IElementType KW_TRUE = new LSTokenType("true");
  IElementType KW_VAR = new LSTokenType("var");
  IElementType KW_WHILE = new LSTokenType("while");
  IElementType NUMBER = new LSTokenType("number");
  IElementType OP_AND = new LSTokenType("and");
  IElementType OP_AND_EQ = new LSTokenType("&=");
  IElementType OP_ASSIGN = new LSTokenType("=");
  IElementType OP_BINARY_AND = new LSTokenType("&");
  IElementType OP_BINARY_OR = new LSTokenType("|");
  IElementType OP_COLON = new LSTokenType(":");
  IElementType OP_COMMA = new LSTokenType(",");
  IElementType OP_DEC = new LSTokenType("--");
  IElementType OP_DIVIDE = new LSTokenType("/");
  IElementType OP_DIVIDE_EQ = new LSTokenType("/=");
  IElementType OP_EQUALS = new LSTokenType("==");
  IElementType OP_EXCLAMATION_MARK = new LSTokenType("!");
  IElementType OP_GE = new LSTokenType(">=");
  IElementType OP_GT = new LSTokenType(">");
  IElementType OP_IDENTITY_EQUALS = new LSTokenType("===");
  IElementType OP_IDENTITY_NOT_EQUALS = new LSTokenType("!==");
  IElementType OP_INC = new LSTokenType("++");
  IElementType OP_LBRACE = new LSTokenType("{");
  IElementType OP_LBRACKET = new LSTokenType("[");
  IElementType OP_LE = new LSTokenType("<=");
  IElementType OP_LOGICAL_AND = new LSTokenType("&&");
  IElementType OP_LOGICAL_OR = new LSTokenType("||");
  IElementType OP_LPAREN = new LSTokenType("(");
  IElementType OP_LSHIFT = new LSTokenType("<<");
  IElementType OP_LT = new LSTokenType("<");
  IElementType OP_MINUS = new LSTokenType("-");
  IElementType OP_MINUS_EQ = new LSTokenType("-=");
  IElementType OP_MODULO = new LSTokenType("%");
  IElementType OP_NOT = new LSTokenType("not");
  IElementType OP_NOT_EQUALS = new LSTokenType("!=");
  IElementType OP_OR = new LSTokenType("or");
  IElementType OP_OR_EQ = new LSTokenType("|=");
  IElementType OP_PLUS = new LSTokenType("+");
  IElementType OP_PLUS_EQ = new LSTokenType("+=");
  IElementType OP_POW = new LSTokenType("**");
  IElementType OP_RBRACE = new LSTokenType("}");
  IElementType OP_RBRACKET = new LSTokenType("]");
  IElementType OP_REFERENCE = new LSTokenType("@");
  IElementType OP_RPAREN = new LSTokenType(")");
  IElementType OP_RSHIFT = new LSTokenType(">>");
  IElementType OP_SEMICOLON = new LSTokenType(";");
  IElementType OP_TERNARY = new LSTokenType("?");
  IElementType OP_TIMES = new LSTokenType("*");
  IElementType OP_TIMES_EQ = new LSTokenType("*=");
  IElementType OP_UNSIGNED_RSHIFT = new LSTokenType(">>>");
  IElementType OP_XOR = new LSTokenType("^");
  IElementType OP_XOR_EQ = new LSTokenType("^=");
  IElementType STRING = new LSTokenType("string");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ADDITIVE_EXPRESSION) {
        return new LSAdditiveExpressionImpl(node);
      }
      else if (type == ARGUMENTS) {
        return new LSArgumentsImpl(node);
      }
      else if (type == ARGUMENT_LIST) {
        return new LSArgumentListImpl(node);
      }
      else if (type == ARRAY_LITERAL) {
        return new LSArrayLiteralImpl(node);
      }
      else if (type == ASSIGN_EXPRESSION) {
        return new LSAssignExpressionImpl(node);
      }
      else if (type == BITWISE_EXPRESSION) {
        return new LSBitwiseExpressionImpl(node);
      }
      else if (type == BLOCK) {
        return new LSBlockImpl(node);
      }
      else if (type == BREAK_STATEMENT) {
        return new LSBreakStatementImpl(node);
      }
      else if (type == COMPARE_EXPRESSION) {
        return new LSCompareExpressionImpl(node);
      }
      else if (type == CONTINUE_STATEMENT) {
        return new LSContinueStatementImpl(node);
      }
      else if (type == DO_WHILE_STATEMENT) {
        return new LSDoWhileStatementImpl(node);
      }
      else if (type == ELEMENT_LIST) {
        return new LSElementListImpl(node);
      }
      else if (type == ELSE_BLOCK) {
        return new LSElseBlockImpl(node);
      }
      else if (type == EMPTY_STATEMENT) {
        return new LSEmptyStatementImpl(node);
      }
      else if (type == EOS) {
        return new LSEosImpl(node);
      }
      else if (type == EXPRESSION_STATEMENT) {
        return new LSExpressionStatementImpl(node);
      }
      else if (type == FORMAL_PARAMETER_LIST) {
        return new LSFormalParameterListImpl(node);
      }
      else if (type == FOR_INITIALIZER) {
        return new LSForInitializerImpl(node);
      }
      else if (type == FOR_STATEMENT) {
        return new LSForStatementImpl(node);
      }
      else if (type == FUNCTION_DECLARATION) {
        return new LSFunctionDeclarationImpl(node);
      }
      else if (type == FUNCTION_EXPRESSION) {
        return new LSFunctionExpressionImpl(node);
      }
      else if (type == FUNCTION_NAME) {
        return new LSFunctionNameImpl(node);
      }
      else if (type == IF_STATEMENT) {
        return new LSIfStatementImpl(node);
      }
      else if (type == INITIALISER) {
        return new LSInitialiserImpl(node);
      }
      else if (type == KEYVAL) {
        return new LSKeyvalImpl(node);
      }
      else if (type == KEYVAL_LIST) {
        return new LSKeyvalListImpl(node);
      }
      else if (type == LITERAL) {
        return new LSLiteralImpl(node);
      }
      else if (type == LOGIC_AND_EXPRESSION) {
        return new LSLogicAndExpressionImpl(node);
      }
      else if (type == LOGIC_OR_EXPRESSION) {
        return new LSLogicOrExpressionImpl(node);
      }
      else if (type == METHOD_CALL) {
        return new LSMethodCallImpl(node);
      }
      else if (type == MODIFIER) {
        return new LSModifierImpl(node);
      }
      else if (type == MULTIPLICATIVE_EXPRESSION) {
        return new LSMultiplicativeExpressionImpl(node);
      }
      else if (type == PARAMETER) {
        return new LSParameterImpl(node);
      }
      else if (type == PREFIX_EXPRESSION) {
        return new LSPrefixExpressionImpl(node);
      }
      else if (type == PREFIX_OPERATOR) {
        return new LSPrefixOperatorImpl(node);
      }
      else if (type == PRIMARY_EXPRESSION) {
        return new LSPrimaryExpressionImpl(node);
      }
      else if (type == REFERENCE_EXPRESSION) {
        return new LSReferenceExpressionImpl(node);
      }
      else if (type == RETURN_STATEMENT) {
        return new LSReturnStatementImpl(node);
      }
      else if (type == SHIFT_EXPRESSION) {
        return new LSShiftExpressionImpl(node);
      }
      else if (type == SINGLE_EXPRESSION) {
        return new LSSingleExpressionImpl(node);
      }
      else if (type == STATEMENT_LIST) {
        return new LSStatementListImpl(node);
      }
      else if (type == SUFFIX_EXPRESSION) {
        return new LSSuffixExpressionImpl(node);
      }
      else if (type == TERNARY_EXPRESSION) {
        return new LSTernaryExpressionImpl(node);
      }
      else if (type == THEN_BLOCK) {
        return new LSThenBlockImpl(node);
      }
      else if (type == VARIABLE_DECLARATION) {
        return new LSVariableDeclarationImpl(node);
      }
      else if (type == VARIABLE_STATEMENT) {
        return new LSVariableStatementImpl(node);
      }
      else if (type == WHILE_CONDITION) {
        return new LSWhileConditionImpl(node);
      }
      else if (type == WHILE_STATEMENT) {
        return new LSWhileStatementImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
