// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import com.plopiplop.leekwars.psi.impl.LSArgumentListImpl;
import com.plopiplop.leekwars.psi.impl.LSArgumentsImpl;
import com.plopiplop.leekwars.psi.impl.LSArrayLiteralImpl;
import com.plopiplop.leekwars.psi.impl.LSBlockImpl;
import com.plopiplop.leekwars.psi.impl.LSBreakStatementImpl;
import com.plopiplop.leekwars.psi.impl.LSContinueStatementImpl;
import com.plopiplop.leekwars.psi.impl.LSDoWhileStatementImpl;
import com.plopiplop.leekwars.psi.impl.LSElementListImpl;
import com.plopiplop.leekwars.psi.impl.LSElseBlockImpl;
import com.plopiplop.leekwars.psi.impl.LSEmptyStatementImpl;
import com.plopiplop.leekwars.psi.impl.LSEosImpl;
import com.plopiplop.leekwars.psi.impl.LSExpressionSequenceImpl;
import com.plopiplop.leekwars.psi.impl.LSExpressionStatementImpl;
import com.plopiplop.leekwars.psi.impl.LSForInitializerImpl;
import com.plopiplop.leekwars.psi.impl.LSForStatementImpl;
import com.plopiplop.leekwars.psi.impl.LSFormalParameterListImpl;
import com.plopiplop.leekwars.psi.impl.LSFunctionDeclarationImpl;
import com.plopiplop.leekwars.psi.impl.LSFunctionExpressionImpl;
import com.plopiplop.leekwars.psi.impl.LSIfStatementImpl;
import com.plopiplop.leekwars.psi.impl.LSIncludeImpl;
import com.plopiplop.leekwars.psi.impl.LSInitialiserImpl;
import com.plopiplop.leekwars.psi.impl.LSKeyvalImpl;
import com.plopiplop.leekwars.psi.impl.LSKeyvalListImpl;
import com.plopiplop.leekwars.psi.impl.LSLiteralImpl;
import com.plopiplop.leekwars.psi.impl.LSMethodCallImpl;
import com.plopiplop.leekwars.psi.impl.LSModifierImpl;
import com.plopiplop.leekwars.psi.impl.LSParameterImpl;
import com.plopiplop.leekwars.psi.impl.LSPostfixOperatorImpl;
import com.plopiplop.leekwars.psi.impl.LSPrefixOperatorImpl;
import com.plopiplop.leekwars.psi.impl.LSReferenceStringImpl;
import com.plopiplop.leekwars.psi.impl.LSReturnStatementImpl;
import com.plopiplop.leekwars.psi.impl.LSSimpleExpressionImpl;
import com.plopiplop.leekwars.psi.impl.LSSingleExpressionImpl;
import com.plopiplop.leekwars.psi.impl.LSStatementListImpl;
import com.plopiplop.leekwars.psi.impl.LSThenBlockImpl;
import com.plopiplop.leekwars.psi.impl.LSVariableDeclarationImpl;
import com.plopiplop.leekwars.psi.impl.LSVariableReferenceImpl;
import com.plopiplop.leekwars.psi.impl.LSVariableStatementImpl;
import com.plopiplop.leekwars.psi.impl.LSWhileConditionImpl;
import com.plopiplop.leekwars.psi.impl.LSWhileStatementImpl;

public interface LSTypes {

  IElementType ARGUMENTS = new LSElementType("ARGUMENTS");
  IElementType ARGUMENT_LIST = new LSElementType("ARGUMENT_LIST");
  IElementType ARRAY_LITERAL = new LSElementType("ARRAY_LITERAL");
  IElementType BLOCK = new LSElementType("BLOCK");
  IElementType BREAK_STATEMENT = new LSElementType("BREAK_STATEMENT");
  IElementType CONTINUE_STATEMENT = new LSElementType("CONTINUE_STATEMENT");
  IElementType DO_WHILE_STATEMENT = new LSElementType("DO_WHILE_STATEMENT");
  IElementType ELEMENT_LIST = new LSElementType("ELEMENT_LIST");
  IElementType ELSE_BLOCK = new LSElementType("ELSE_BLOCK");
  IElementType EMPTY_STATEMENT = new LSElementType("EMPTY_STATEMENT");
  IElementType EOS = new LSElementType("EOS");
  IElementType EXPRESSION_SEQUENCE = new LSElementType("EXPRESSION_SEQUENCE");
  IElementType EXPRESSION_STATEMENT = new LSElementType("EXPRESSION_STATEMENT");
  IElementType FORMAL_PARAMETER_LIST = new LSElementType("FORMAL_PARAMETER_LIST");
  IElementType FOR_INITIALIZER = new LSElementType("FOR_INITIALIZER");
  IElementType FOR_STATEMENT = new LSElementType("FOR_STATEMENT");
  IElementType FUNCTION_DECLARATION = new LSElementType("FUNCTION_DECLARATION");
    IElementType FUNCTION_EXPRESSION = new LSElementType("FUNCTION_EXPRESSION");
  IElementType IF_STATEMENT = new LSElementType("IF_STATEMENT");
  IElementType INCLUDE = new LSElementType("INCLUDE");
  IElementType INITIALISER = new LSElementType("INITIALISER");
    IElementType KEYVAL = new LSElementType("KEYVAL");
    IElementType KEYVAL_LIST = new LSElementType("KEYVAL_LIST");
  IElementType LITERAL = new LSElementType("LITERAL");
  IElementType METHOD_CALL = new LSElementType("METHOD_CALL");
  IElementType MODIFIER = new LSElementType("MODIFIER");
  IElementType PARAMETER = new LSElementType("PARAMETER");
  IElementType POSTFIX_OPERATOR = new LSElementType("POSTFIX_OPERATOR");
  IElementType PREFIX_OPERATOR = new LSElementType("PREFIX_OPERATOR");
  IElementType REFERENCE_STRING = new LSElementType("REFERENCE_STRING");
  IElementType RETURN_STATEMENT = new LSElementType("RETURN_STATEMENT");
  IElementType SIMPLE_EXPRESSION = new LSElementType("SIMPLE_EXPRESSION");
  IElementType SINGLE_EXPRESSION = new LSElementType("SINGLE_EXPRESSION");
  IElementType STATEMENT_LIST = new LSElementType("STATEMENT_LIST");
  IElementType THEN_BLOCK = new LSElementType("THEN_BLOCK");
  IElementType VARIABLE_DECLARATION = new LSElementType("VARIABLE_DECLARATION");
  IElementType VARIABLE_REFERENCE = new LSElementType("VARIABLE_REFERENCE");
  IElementType VARIABLE_STATEMENT = new LSElementType("VARIABLE_STATEMENT");
  IElementType WHILE_CONDITION = new LSElementType("WHILE_CONDITION");
  IElementType WHILE_STATEMENT = new LSElementType("WHILE_STATEMENT");

  IElementType COMMENT = new LSTokenType("comment");
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
  IElementType KW_INCLUDE = new LSTokenType("include");
  IElementType KW_NULL = new LSTokenType("null");
  IElementType KW_RETURN = new LSTokenType("return");
  IElementType KW_TRUE = new LSTokenType("true");
  IElementType KW_VAR = new LSTokenType("var");
  IElementType KW_WHILE = new LSTokenType("while");
  IElementType MULTILINE_COMMENT = new LSTokenType("multiline_comment");
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
  IElementType OP_RBRACE = new LSTokenType("}");
  IElementType OP_RBRACKET = new LSTokenType("]");
  IElementType OP_REFERENCE = new LSTokenType("@");
  IElementType OP_RPAREN = new LSTokenType(")");
  IElementType OP_SEMICOLON = new LSTokenType(";");
  IElementType OP_TERNARY = new LSTokenType("?");
  IElementType OP_TIMES = new LSTokenType("*");
  IElementType OP_TIMES_EQ = new LSTokenType("*=");
  IElementType STRING = new LSTokenType("string");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ARGUMENTS) {
        return new LSArgumentsImpl(node);
      }
      else if (type == ARGUMENT_LIST) {
        return new LSArgumentListImpl(node);
      }
      else if (type == ARRAY_LITERAL) {
        return new LSArrayLiteralImpl(node);
      }
      else if (type == BLOCK) {
        return new LSBlockImpl(node);
      }
      else if (type == BREAK_STATEMENT) {
        return new LSBreakStatementImpl(node);
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
      else if (type == EXPRESSION_SEQUENCE) {
        return new LSExpressionSequenceImpl(node);
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
      } else if (type == FUNCTION_EXPRESSION) {
           return new LSFunctionExpressionImpl(node);
       }
      else if (type == IF_STATEMENT) {
        return new LSIfStatementImpl(node);
      }
      else if (type == INCLUDE) {
        return new LSIncludeImpl(node);
      }
      else if (type == INITIALISER) {
        return new LSInitialiserImpl(node);
       } else if (type == KEYVAL) {
           return new LSKeyvalImpl(node);
       } else if (type == KEYVAL_LIST) {
           return new LSKeyvalListImpl(node);
      }
      else if (type == LITERAL) {
        return new LSLiteralImpl(node);
      }
      else if (type == METHOD_CALL) {
        return new LSMethodCallImpl(node);
      }
      else if (type == MODIFIER) {
        return new LSModifierImpl(node);
      }
      else if (type == PARAMETER) {
        return new LSParameterImpl(node);
      }
      else if (type == POSTFIX_OPERATOR) {
        return new LSPostfixOperatorImpl(node);
      }
      else if (type == PREFIX_OPERATOR) {
        return new LSPrefixOperatorImpl(node);
      }
      else if (type == REFERENCE_STRING) {
        return new LSReferenceStringImpl(node);
      }
      else if (type == RETURN_STATEMENT) {
        return new LSReturnStatementImpl(node);
      }
      else if (type == SIMPLE_EXPRESSION) {
        return new LSSimpleExpressionImpl(node);
      }
      else if (type == SINGLE_EXPRESSION) {
        return new LSSingleExpressionImpl(node);
      }
      else if (type == STATEMENT_LIST) {
        return new LSStatementListImpl(node);
      }
      else if (type == THEN_BLOCK) {
        return new LSThenBlockImpl(node);
      }
      else if (type == VARIABLE_DECLARATION) {
        return new LSVariableDeclarationImpl(node);
      }
      else if (type == VARIABLE_REFERENCE) {
        return new LSVariableReferenceImpl(node);
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
