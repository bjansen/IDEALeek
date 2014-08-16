// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.lang.PsiParser;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.psi.tree.IElementType;

import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import static com.plopiplop.leekwars.psi.LSTypes.*;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class LeekScriptParser implements PsiParser {

  public static final Logger LOG_ = Logger.getInstance("com.plopiplop.leekwars.parser.LeekScriptParser");

  public ASTNode parse(IElementType root_, PsiBuilder builder_) {
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this, null);
    Marker marker_ = enter_section_(builder_, 0, _COLLAPSE_, null);
    if (root_ == ARGUMENT_LIST) {
      result_ = argumentList(builder_, 0);
    }
    else if (root_ == ARGUMENTS) {
      result_ = arguments(builder_, 0);
    }
    else if (root_ == ARRAY_LITERAL) {
      result_ = arrayLiteral(builder_, 0);
    }
    else if (root_ == BLOCK) {
      result_ = block(builder_, 0);
    }
    else if (root_ == BREAK_STATEMENT) {
      result_ = breakStatement(builder_, 0);
    }
    else if (root_ == CONTINUE_STATEMENT) {
      result_ = continueStatement(builder_, 0);
    }
    else if (root_ == DO_WHILE_STATEMENT) {
      result_ = doWhileStatement(builder_, 0);
    }
    else if (root_ == ELEMENT_LIST) {
      result_ = elementList(builder_, 0);
    }
    else if (root_ == ELSE_BLOCK) {
      result_ = elseBlock(builder_, 0);
    }
    else if (root_ == EMPTY_STATEMENT) {
      result_ = emptyStatement(builder_, 0);
    }
    else if (root_ == EOS) {
      result_ = eos(builder_, 0);
    }
    else if (root_ == EXPRESSION_SEQUENCE) {
      result_ = expressionSequence(builder_, 0);
    }
    else if (root_ == EXPRESSION_STATEMENT) {
      result_ = expressionStatement(builder_, 0);
    }
    else if (root_ == FOR_INITIALIZER) {
      result_ = forInitializer(builder_, 0);
    }
    else if (root_ == FOR_STATEMENT) {
      result_ = forStatement(builder_, 0);
    }
    else if (root_ == FORMAL_PARAMETER_LIST) {
      result_ = formalParameterList(builder_, 0);
    }
    else if (root_ == FUNCTION_DECLARATION) {
      result_ = functionDeclaration(builder_, 0);
    }
    else if (root_ == IF_STATEMENT) {
      result_ = ifStatement(builder_, 0);
    }
    else if (root_ == INCLUDE) {
      result_ = include(builder_, 0);
    }
    else if (root_ == INITIALISER) {
      result_ = initialiser(builder_, 0);
    } else if (root_ == KEYVAL) {
        result_ = keyval(builder_, 0);
    } else if (root_ == KEYVAL_LIST) {
        result_ = keyvalList(builder_, 0);
    }
    else if (root_ == LITERAL) {
      result_ = literal(builder_, 0);
    }
    else if (root_ == METHOD_CALL) {
      result_ = methodCall(builder_, 0);
    }
    else if (root_ == MODIFIER) {
      result_ = modifier(builder_, 0);
    }
    else if (root_ == PARAMETER) {
      result_ = parameter(builder_, 0);
    }
    else if (root_ == POSTFIX_OPERATOR) {
      result_ = postfixOperator(builder_, 0);
    }
    else if (root_ == PREFIX_OPERATOR) {
      result_ = prefixOperator(builder_, 0);
    }
    else if (root_ == REFERENCE_STRING) {
      result_ = referenceString(builder_, 0);
    }
    else if (root_ == RETURN_STATEMENT) {
      result_ = returnStatement(builder_, 0);
    }
    else if (root_ == SIMPLE_EXPRESSION) {
      result_ = simpleExpression(builder_, 0);
    }
    else if (root_ == SINGLE_EXPRESSION) {
      result_ = singleExpression(builder_, 0);
    }
    else if (root_ == STATEMENT_LIST) {
      result_ = statementList(builder_, 0);
    }
    else if (root_ == THEN_BLOCK) {
      result_ = thenBlock(builder_, 0);
    }
    else if (root_ == VARIABLE_DECLARATION) {
      result_ = variableDeclaration(builder_, 0);
    }
    else if (root_ == VARIABLE_REFERENCE) {
      result_ = variableReference(builder_, 0);
    }
    else if (root_ == VARIABLE_STATEMENT) {
      result_ = variableStatement(builder_, 0);
    }
    else if (root_ == WHILE_CONDITION) {
      result_ = whileCondition(builder_, 0);
    }
    else if (root_ == WHILE_STATEMENT) {
      result_ = whileStatement(builder_, 0);
    }
    else {
      result_ = parse_root_(root_, builder_, 0);
    }
    exit_section_(builder_, 0, marker_, root_, result_, true, TRUE_CONDITION);
    return builder_.getTreeBuilt();
  }

  protected boolean parse_root_(final IElementType root_, final PsiBuilder builder_, final int level_) {
    return program(builder_, level_ + 1);
  }

  /* ********************************************************** */
  // singleExpressionPart (',' singleExpressionPart)*
  public static boolean argumentList(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "argumentList")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<argument list>");
    result_ = singleExpressionPart(builder_, level_ + 1);
    result_ = result_ && argumentList_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, ARGUMENT_LIST, result_, false, singleExpressionRecover_parser_);
    return result_;
  }

  // (',' singleExpressionPart)*
  private static boolean argumentList_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "argumentList_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!argumentList_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "argumentList_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // ',' singleExpressionPart
  private static boolean argumentList_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "argumentList_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OP_COMMA);
    result_ = result_ && singleExpressionPart(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // '(' argumentList? ')'
  public static boolean arguments(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arguments")) return false;
    if (!nextTokenIs(builder_, OP_LPAREN)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OP_LPAREN);
    result_ = result_ && arguments_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, OP_RPAREN);
    exit_section_(builder_, marker_, ARGUMENTS, result_);
    return result_;
  }

  // argumentList?
  private static boolean arguments_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arguments_1")) return false;
    argumentList(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // '[' (keyvalList | elementList)? ']'
  public static boolean arrayLiteral(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arrayLiteral")) return false;
    if (!nextTokenIs(builder_, OP_LBRACKET)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OP_LBRACKET);
    result_ = result_ && arrayLiteral_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, OP_RBRACKET);
    exit_section_(builder_, marker_, ARRAY_LITERAL, result_);
    return result_;
  }

    // (keyvalList | elementList)?
  private static boolean arrayLiteral_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arrayLiteral_1")) return false;
      arrayLiteral_1_0(builder_, level_ + 1);
    return true;
  }

    // keyvalList | elementList
    private static boolean arrayLiteral_1_0(PsiBuilder builder_, int level_) {
        if (!recursion_guard_(builder_, level_, "arrayLiteral_1_0")) return false;
        boolean result_;
        Marker marker_ = enter_section_(builder_);
        result_ = keyvalList(builder_, level_ + 1);
        if (!result_) result_ = elementList(builder_, level_ + 1);
        exit_section_(builder_, marker_, null, result_);
        return result_;
    }

  /* ********************************************************** */
  // '=' | '+=' | '-=' | '*=' | '/=' | '&=' | '|='
  static boolean assignmentOperator(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "assignmentOperator")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OP_ASSIGN);
    if (!result_) result_ = consumeToken(builder_, OP_PLUS_EQ);
    if (!result_) result_ = consumeToken(builder_, OP_MINUS_EQ);
    if (!result_) result_ = consumeToken(builder_, OP_TIMES_EQ);
    if (!result_) result_ = consumeToken(builder_, OP_DIVIDE_EQ);
    if (!result_) result_ = consumeToken(builder_, OP_AND_EQ);
    if (!result_) result_ = consumeToken(builder_, OP_OR_EQ);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // '{' statementList? '}'
  public static boolean block(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "block")) return false;
    if (!nextTokenIs(builder_, OP_LBRACE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OP_LBRACE);
    result_ = result_ && block_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, OP_RBRACE);
    exit_section_(builder_, marker_, BLOCK, result_);
    return result_;
  }

  // statementList?
  private static boolean block_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "block_1")) return false;
    statementList(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // '&&' | '||' | '&' | '|' | 'and' | 'or'
  static boolean booleanOperator(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "booleanOperator")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OP_LOGICAL_AND);
    if (!result_) result_ = consumeToken(builder_, OP_LOGICAL_OR);
    if (!result_) result_ = consumeToken(builder_, OP_BINARY_AND);
    if (!result_) result_ = consumeToken(builder_, OP_BINARY_OR);
      if (!result_) result_ = consumeToken(builder_, OP_AND);
      if (!result_) result_ = consumeToken(builder_, OP_OR);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // 'break' eos
  public static boolean breakStatement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "breakStatement")) return false;
    if (!nextTokenIs(builder_, KW_BREAK)) return false;
    boolean result_;
    boolean pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, KW_BREAK);
    pinned_ = result_; // pin = 1
    result_ = result_ && eos(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, BREAK_STATEMENT, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // '<=' | '>=' | '<' | '>' | '===' | '==' | '!==' | '!='
  static boolean comparator(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "comparator")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OP_LE);
    if (!result_) result_ = consumeToken(builder_, OP_GE);
    if (!result_) result_ = consumeToken(builder_, OP_LT);
    if (!result_) result_ = consumeToken(builder_, OP_GT);
    if (!result_) result_ = consumeToken(builder_, OP_IDENTITY_EQUALS);
    if (!result_) result_ = consumeToken(builder_, OP_EQUALS);
    if (!result_) result_ = consumeToken(builder_, OP_IDENTITY_NOT_EQUALS);
    if (!result_) result_ = consumeToken(builder_, OP_NOT_EQUALS);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // 'continue' eos
  public static boolean continueStatement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "continueStatement")) return false;
    if (!nextTokenIs(builder_, KW_CONTINUE)) return false;
    boolean result_;
    boolean pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, KW_CONTINUE);
    pinned_ = result_; // pin = 1
    result_ = result_ && eos(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, CONTINUE_STATEMENT, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // 'do' statement whileCondition eos
  public static boolean doWhileStatement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "doWhileStatement")) return false;
    if (!nextTokenIs(builder_, KW_DO)) return false;
    boolean result_;
    boolean pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, KW_DO);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, statement(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, whileCondition(builder_, level_ + 1)) && result_;
    result_ = pinned_ && eos(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, DO_WHILE_STATEMENT, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // singleExpression (',' singleExpression)*
  public static boolean elementList(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "elementList")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<element list>");
    result_ = singleExpression(builder_, level_ + 1);
    result_ = result_ && elementList_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, ELEMENT_LIST, result_, false, null);
    return result_;
  }

  // (',' singleExpression)*
  private static boolean elementList_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "elementList_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!elementList_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "elementList_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // ',' singleExpression
  private static boolean elementList_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "elementList_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OP_COMMA);
    result_ = result_ && singleExpression(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // 'else' statement
  public static boolean elseBlock(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "elseBlock")) return false;
    if (!nextTokenIs(builder_, KW_ELSE)) return false;
    boolean result_;
      boolean pinned_;
      Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, KW_ELSE);
      pinned_ = result_; // pin = 1
    result_ = result_ && statement(builder_, level_ + 1);
      exit_section_(builder_, level_, marker_, ELSE_BLOCK, result_, pinned_, null);
      return result_ || pinned_;
  }

  /* ********************************************************** */
  // ';'
  public static boolean emptyStatement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "emptyStatement")) return false;
    if (!nextTokenIs(builder_, OP_SEMICOLON)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OP_SEMICOLON);
    exit_section_(builder_, marker_, EMPTY_STATEMENT, result_);
    return result_;
  }

  /* ********************************************************** */
  // ';'
  public static boolean eos(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "eos")) return false;
    if (!nextTokenIs(builder_, OP_SEMICOLON)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OP_SEMICOLON);
    exit_section_(builder_, marker_, EOS, result_);
    return result_;
  }

  /* ********************************************************** */
  // singleExpression (',' singleExpression)*
  public static boolean expressionSequence(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expressionSequence")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<expression sequence>");
    result_ = singleExpression(builder_, level_ + 1);
    result_ = result_ && expressionSequence_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, EXPRESSION_SEQUENCE, result_, false, null);
    return result_;
  }

  // (',' singleExpression)*
  private static boolean expressionSequence_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expressionSequence_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!expressionSequence_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "expressionSequence_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // ',' singleExpression
  private static boolean expressionSequence_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expressionSequence_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OP_COMMA);
    result_ = result_ && singleExpression(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // expressionSequence eos
  public static boolean expressionStatement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expressionStatement")) return false;
    boolean result_;
    boolean pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<expression statement>");
    result_ = expressionSequence(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && eos(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, EXPRESSION_STATEMENT, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // 'var'? identifier
  public static boolean forInitializer(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "forInitializer")) return false;
    if (!nextTokenIs(builder_, "<for initializer>", KW_VAR, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<for initializer>");
    result_ = forInitializer_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, IDENTIFIER);
    exit_section_(builder_, level_, marker_, FOR_INITIALIZER, result_, false, null);
    return result_;
  }

  // 'var'?
  private static boolean forInitializer_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "forInitializer_0")) return false;
    consumeToken(builder_, KW_VAR);
    return true;
  }

  /* ********************************************************** */
  // 'for' '(' forInitializer ((':' forInitializer)? 'in' simpleExpression | initialiser ';' singleExpression ';' singleExpression) ')' statement
  public static boolean forStatement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "forStatement")) return false;
    if (!nextTokenIs(builder_, KW_FOR)) return false;
    boolean result_;
    boolean pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, KW_FOR);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, consumeToken(builder_, OP_LPAREN));
    result_ = pinned_ && report_error_(builder_, forInitializer(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, forStatement_3(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, OP_RPAREN)) && result_;
    result_ = pinned_ && statement(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, FOR_STATEMENT, result_, pinned_, null);
    return result_ || pinned_;
  }

  // (':' forInitializer)? 'in' simpleExpression | initialiser ';' singleExpression ';' singleExpression
  private static boolean forStatement_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "forStatement_3")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = forStatement_3_0(builder_, level_ + 1);
    if (!result_) result_ = forStatement_3_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (':' forInitializer)? 'in' simpleExpression
  private static boolean forStatement_3_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "forStatement_3_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = forStatement_3_0_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, KW_IN);
    result_ = result_ && simpleExpression(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (':' forInitializer)?
  private static boolean forStatement_3_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "forStatement_3_0_0")) return false;
    forStatement_3_0_0_0(builder_, level_ + 1);
    return true;
  }

  // ':' forInitializer
  private static boolean forStatement_3_0_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "forStatement_3_0_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OP_COLON);
    result_ = result_ && forInitializer(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // initialiser ';' singleExpression ';' singleExpression
  private static boolean forStatement_3_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "forStatement_3_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = initialiser(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, OP_SEMICOLON);
    result_ = result_ && singleExpression(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, OP_SEMICOLON);
    result_ = result_ && singleExpression(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // parameter (',' parameter)*
  public static boolean formalParameterList(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "formalParameterList")) return false;
    if (!nextTokenIs(builder_, "<formal parameter list>", OP_REFERENCE, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<formal parameter list>");
    result_ = parameter(builder_, level_ + 1);
    result_ = result_ && formalParameterList_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, FORMAL_PARAMETER_LIST, result_, false, null);
    return result_;
  }

  // (',' parameter)*
  private static boolean formalParameterList_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "formalParameterList_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!formalParameterList_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "formalParameterList_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // ',' parameter
  private static boolean formalParameterList_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "formalParameterList_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OP_COMMA);
    result_ = result_ && parameter(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // 'function' identifier '(' formalParameterList? ')' block
  public static boolean functionDeclaration(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "functionDeclaration")) return false;
    if (!nextTokenIs(builder_, KW_FUNCTION)) return false;
    boolean result_;
      boolean pinned_;
      Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, KW_FUNCTION);
      pinned_ = result_; // pin = 1
      result_ = result_ && report_error_(builder_, consumeToken(builder_, IDENTIFIER));
      result_ = pinned_ && report_error_(builder_, consumeToken(builder_, OP_LPAREN)) && result_;
      result_ = pinned_ && report_error_(builder_, functionDeclaration_3(builder_, level_ + 1)) && result_;
      result_ = pinned_ && report_error_(builder_, consumeToken(builder_, OP_RPAREN)) && result_;
      result_ = pinned_ && block(builder_, level_ + 1) && result_;
      exit_section_(builder_, level_, marker_, FUNCTION_DECLARATION, result_, pinned_, null);
      return result_ || pinned_;
  }

  // formalParameterList?
  private static boolean functionDeclaration_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "functionDeclaration_3")) return false;
    formalParameterList(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // 'if' '(' expressionSequence ')' thenBlock elseBlock?
  public static boolean ifStatement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ifStatement")) return false;
    if (!nextTokenIs(builder_, KW_IF)) return false;
    boolean result_;
    boolean pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, KW_IF);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, consumeToken(builder_, OP_LPAREN));
    result_ = pinned_ && report_error_(builder_, expressionSequence(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, OP_RPAREN)) && result_;
    result_ = pinned_ && report_error_(builder_, thenBlock(builder_, level_ + 1)) && result_;
    result_ = pinned_ && ifStatement_5(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, IF_STATEMENT, result_, pinned_, null);
    return result_ || pinned_;
  }

  // elseBlock?
  private static boolean ifStatement_5(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ifStatement_5")) return false;
    elseBlock(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // 'include' '(' referenceString ')' eos
  public static boolean include(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "include")) return false;
    if (!nextTokenIs(builder_, KW_INCLUDE)) return false;
    boolean result_;
    boolean pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, KW_INCLUDE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, consumeToken(builder_, OP_LPAREN));
    result_ = pinned_ && report_error_(builder_, referenceString(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, OP_RPAREN)) && result_;
    result_ = pinned_ && eos(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, INCLUDE, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // '=' singleExpression
  public static boolean initialiser(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "initialiser")) return false;
    if (!nextTokenIs(builder_, OP_ASSIGN)) return false;
    boolean result_;
    boolean pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, OP_ASSIGN);
    pinned_ = result_; // pin = 1
    result_ = result_ && singleExpression(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, INITIALISER, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // singleExpression ':' singleExpression
  public static boolean keyval(PsiBuilder builder_, int level_) {
      if (!recursion_guard_(builder_, level_, "keyval")) return false;
      boolean result_;
      Marker marker_ = enter_section_(builder_, level_, _NONE_, "<keyval>");
      result_ = singleExpression(builder_, level_ + 1);
      result_ = result_ && consumeToken(builder_, OP_COLON);
      result_ = result_ && singleExpression(builder_, level_ + 1);
      exit_section_(builder_, level_, marker_, KEYVAL, result_, false, null);
      return result_;
  }

    /* ********************************************************** */
    // keyval (',' keyval)*
    public static boolean keyvalList(PsiBuilder builder_, int level_) {
        if (!recursion_guard_(builder_, level_, "keyvalList")) return false;
        boolean result_;
        Marker marker_ = enter_section_(builder_, level_, _NONE_, "<keyval list>");
        result_ = keyval(builder_, level_ + 1);
        result_ = result_ && keyvalList_1(builder_, level_ + 1);
        exit_section_(builder_, level_, marker_, KEYVAL_LIST, result_, false, null);
        return result_;
    }

    // (',' keyval)*
    private static boolean keyvalList_1(PsiBuilder builder_, int level_) {
        if (!recursion_guard_(builder_, level_, "keyvalList_1")) return false;
        int pos_ = current_position_(builder_);
        while (true) {
            if (!keyvalList_1_0(builder_, level_ + 1)) break;
            if (!empty_element_parsed_guard_(builder_, "keyvalList_1", pos_)) break;
            pos_ = current_position_(builder_);
    }
        return true;
    }

    // ',' keyval
    private static boolean keyvalList_1_0(PsiBuilder builder_, int level_) {
        if (!recursion_guard_(builder_, level_, "keyvalList_1_0")) return false;
        boolean result_;
        Marker marker_ = enter_section_(builder_);
        result_ = consumeToken(builder_, OP_COMMA);
        result_ = result_ && keyval(builder_, level_ + 1);
        exit_section_(builder_, marker_, null, result_);
        return result_;
    }

    /* ********************************************************** */
  // 'null' | 'true' | 'false' | string | number
  public static boolean literal(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "literal")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<literal>");
    result_ = consumeToken(builder_, KW_NULL);
    if (!result_) result_ = consumeToken(builder_, KW_TRUE);
    if (!result_) result_ = consumeToken(builder_, KW_FALSE);
    if (!result_) result_ = consumeToken(builder_, STRING);
    if (!result_) result_ = consumeToken(builder_, NUMBER);
    exit_section_(builder_, level_, marker_, LITERAL, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // '+' | '-' | '*' | '/' | '%'
  static boolean mathOperator(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "mathOperator")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OP_PLUS);
    if (!result_) result_ = consumeToken(builder_, OP_MINUS);
    if (!result_) result_ = consumeToken(builder_, OP_TIMES);
    if (!result_) result_ = consumeToken(builder_, OP_DIVIDE);
    if (!result_) result_ = consumeToken(builder_, OP_MODULO);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // identifier arguments
  public static boolean methodCall(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "methodCall")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IDENTIFIER);
    result_ = result_ && arguments(builder_, level_ + 1);
    exit_section_(builder_, marker_, METHOD_CALL, result_);
    return result_;
  }

  /* ********************************************************** */
  // 'var' | 'global'
  public static boolean modifier(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "modifier")) return false;
    if (!nextTokenIs(builder_, "<modifier>", KW_GLOBAL, KW_VAR)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<modifier>");
    result_ = consumeToken(builder_, KW_VAR);
    if (!result_) result_ = consumeToken(builder_, KW_GLOBAL);
    exit_section_(builder_, level_, marker_, MODIFIER, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // '@'? identifier
  public static boolean parameter(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameter")) return false;
    if (!nextTokenIs(builder_, "<parameter>", OP_REFERENCE, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<parameter>");
    result_ = parameter_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, IDENTIFIER);
    exit_section_(builder_, level_, marker_, PARAMETER, result_, false, null);
    return result_;
  }

  // '@'?
  private static boolean parameter_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "parameter_0")) return false;
    consumeToken(builder_, OP_REFERENCE);
    return true;
  }

  /* ********************************************************** */
  // '++' | '--'
  public static boolean postfixOperator(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "postfixOperator")) return false;
    if (!nextTokenIs(builder_, "<postfix operator>", OP_INC, OP_DEC)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<postfix operator>");
    result_ = consumeToken(builder_, OP_INC);
    if (!result_) result_ = consumeToken(builder_, OP_DEC);
    exit_section_(builder_, level_, marker_, POSTFIX_OPERATOR, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // postfixOperator | '+' | '-' |  '!' | 'not'
  public static boolean prefixOperator(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "prefixOperator")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<prefix operator>");
    result_ = postfixOperator(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, OP_PLUS);
    if (!result_) result_ = consumeToken(builder_, OP_MINUS);
      if (!result_) result_ = consumeToken(builder_, OP_EXCLAMATION_MARK);
    if (!result_) result_ = consumeToken(builder_, OP_NOT);
    exit_section_(builder_, level_, marker_, PREFIX_OPERATOR, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // sourceElements? <<eof>>
  static boolean program(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "program")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = program_0(builder_, level_ + 1);
    result_ = result_ && eof(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // sourceElements?
  private static boolean program_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "program_0")) return false;
    sourceElements(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // string
  public static boolean referenceString(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "referenceString")) return false;
    if (!nextTokenIs(builder_, STRING)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, STRING);
    exit_section_(builder_, marker_, REFERENCE_STRING, result_);
    return result_;
  }

  /* ********************************************************** */
  // 'return' expressionSequence? eos
  public static boolean returnStatement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "returnStatement")) return false;
    if (!nextTokenIs(builder_, KW_RETURN)) return false;
    boolean result_;
    boolean pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, KW_RETURN);
    result_ = result_ && returnStatement_1(builder_, level_ + 1);
    pinned_ = result_; // pin = 2
    result_ = result_ && eos(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, RETURN_STATEMENT, result_, pinned_, null);
    return result_ || pinned_;
  }

  // expressionSequence?
  private static boolean returnStatement_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "returnStatement_1")) return false;
    expressionSequence(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // variableReference postfixOperator
  // //    |   methodCall
  //     |   prefixOperator singleExpression
  //     |   variableReference
  //     |   '(' expressionSequence ')'
  //     |   literal
  //     |   arrayLiteral
  public static boolean simpleExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "simpleExpression")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<simple expression>");
    result_ = simpleExpression_0(builder_, level_ + 1);
      if (!result_) result_ = simpleExpression_1(builder_, level_ + 1);
    if (!result_) result_ = variableReference(builder_, level_ + 1);
      if (!result_) result_ = simpleExpression_3(builder_, level_ + 1);
    if (!result_) result_ = literal(builder_, level_ + 1);
    if (!result_) result_ = arrayLiteral(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, SIMPLE_EXPRESSION, result_, false, null);
    return result_;
  }

  // variableReference postfixOperator
  private static boolean simpleExpression_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "simpleExpression_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = variableReference(builder_, level_ + 1);
    result_ = result_ && postfixOperator(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // prefixOperator singleExpression
  private static boolean simpleExpression_1(PsiBuilder builder_, int level_) {
      if (!recursion_guard_(builder_, level_, "simpleExpression_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = prefixOperator(builder_, level_ + 1);
    result_ = result_ && singleExpression(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // '(' expressionSequence ')'
  private static boolean simpleExpression_3(PsiBuilder builder_, int level_) {
      if (!recursion_guard_(builder_, level_, "simpleExpression_3")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OP_LPAREN);
    result_ = result_ && expressionSequence(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, OP_RPAREN);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // simpleExpression comparator singleExpression
  //     |   simpleExpression booleanOperator singleExpression
  //     |   simpleExpression mathOperator singleExpression
  //     |   simpleExpression '?' simpleExpression ':' simpleExpression
  //     |   variableReference assignmentOperator singleExpression
  //     |   simpleExpression
  public static boolean singleExpression(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "singleExpression")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<single expression>");
    result_ = singleExpression_0(builder_, level_ + 1);
    if (!result_) result_ = singleExpression_1(builder_, level_ + 1);
    if (!result_) result_ = singleExpression_2(builder_, level_ + 1);
    if (!result_) result_ = singleExpression_3(builder_, level_ + 1);
    if (!result_) result_ = singleExpression_4(builder_, level_ + 1);
    if (!result_) result_ = simpleExpression(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, SINGLE_EXPRESSION, result_, false, null);
    return result_;
  }

  // simpleExpression comparator singleExpression
  private static boolean singleExpression_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "singleExpression_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = simpleExpression(builder_, level_ + 1);
    result_ = result_ && comparator(builder_, level_ + 1);
    result_ = result_ && singleExpression(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // simpleExpression booleanOperator singleExpression
  private static boolean singleExpression_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "singleExpression_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = simpleExpression(builder_, level_ + 1);
    result_ = result_ && booleanOperator(builder_, level_ + 1);
    result_ = result_ && singleExpression(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // simpleExpression mathOperator singleExpression
  private static boolean singleExpression_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "singleExpression_2")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = simpleExpression(builder_, level_ + 1);
    result_ = result_ && mathOperator(builder_, level_ + 1);
    result_ = result_ && singleExpression(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // simpleExpression '?' simpleExpression ':' simpleExpression
  private static boolean singleExpression_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "singleExpression_3")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = simpleExpression(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, OP_TERNARY);
    result_ = result_ && simpleExpression(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, OP_COLON);
    result_ = result_ && simpleExpression(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // variableReference assignmentOperator singleExpression
  private static boolean singleExpression_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "singleExpression_4")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = variableReference(builder_, level_ + 1);
    result_ = result_ && assignmentOperator(builder_, level_ + 1);
    result_ = result_ && singleExpression(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // singleExpression
  static boolean singleExpressionPart(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "singleExpressionPart")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = singleExpression(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, null, result_, false, singleExpressionPartRecover_parser_);
    return result_;
  }

  /* ********************************************************** */
  // !(')' | ',')
  static boolean singleExpressionPartRecover(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "singleExpressionPartRecover")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NOT_, null);
    result_ = !singleExpressionPartRecover_0(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, null, result_, false, null);
    return result_;
  }

  // ')' | ','
  private static boolean singleExpressionPartRecover_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "singleExpressionPartRecover_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OP_RPAREN);
    if (!result_) result_ = consumeToken(builder_, OP_COMMA);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // !(')')
  static boolean singleExpressionRecover(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "singleExpressionRecover")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NOT_, null);
    result_ = !singleExpressionRecover_0(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, null, result_, false, null);
    return result_;
  }

  // (')')
  private static boolean singleExpressionRecover_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "singleExpressionRecover_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OP_RPAREN);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // functionDeclaration | statement | include | multiline_comment
  static boolean sourceElement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "sourceElement")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = functionDeclaration(builder_, level_ + 1);
    if (!result_) result_ = statement(builder_, level_ + 1);
    if (!result_) result_ = include(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, MULTILINE_COMMENT);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // sourceElement+
  static boolean sourceElements(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "sourceElements")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = sourceElement(builder_, level_ + 1);
    int pos_ = current_position_(builder_);
    while (result_) {
      if (!sourceElement(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "sourceElements", pos_)) break;
      pos_ = current_position_(builder_);
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // block
  //     |   variableStatement
  //     |   emptyStatement
  //     |   expressionStatement
  //     |   ifStatement
  //     |   whileStatement
  //     |   doWhileStatement
  //     |   forStatement
  //     |   returnStatement
  //     |   breakStatement
  //     |   continueStatement
  static boolean statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = block(builder_, level_ + 1);
    if (!result_) result_ = variableStatement(builder_, level_ + 1);
    if (!result_) result_ = emptyStatement(builder_, level_ + 1);
    if (!result_) result_ = expressionStatement(builder_, level_ + 1);
    if (!result_) result_ = ifStatement(builder_, level_ + 1);
    if (!result_) result_ = whileStatement(builder_, level_ + 1);
    if (!result_) result_ = doWhileStatement(builder_, level_ + 1);
    if (!result_) result_ = forStatement(builder_, level_ + 1);
    if (!result_) result_ = returnStatement(builder_, level_ + 1);
    if (!result_) result_ = breakStatement(builder_, level_ + 1);
    if (!result_) result_ = continueStatement(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // statement+
  public static boolean statementList(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statementList")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<statement list>");
    result_ = statement(builder_, level_ + 1);
    int pos_ = current_position_(builder_);
    while (result_) {
      if (!statement(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "statementList", pos_)) break;
      pos_ = current_position_(builder_);
    }
    exit_section_(builder_, level_, marker_, STATEMENT_LIST, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // statement
  public static boolean thenBlock(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "thenBlock")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<then block>");
    result_ = statement(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, THEN_BLOCK, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // identifier initialiser?
  public static boolean variableDeclaration(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "variableDeclaration")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    boolean pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, IDENTIFIER);
    pinned_ = result_; // pin = 1
    result_ = result_ && variableDeclaration_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, VARIABLE_DECLARATION, result_, pinned_, null);
    return result_ || pinned_;
  }

  // initialiser?
  private static boolean variableDeclaration_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "variableDeclaration_1")) return false;
    initialiser(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // variableDeclaration (',' variableDeclaration)*
  static boolean variableDeclarationList(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "variableDeclarationList")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = variableDeclaration(builder_, level_ + 1);
    result_ = result_ && variableDeclarationList_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (',' variableDeclaration)*
  private static boolean variableDeclarationList_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "variableDeclarationList_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!variableDeclarationList_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "variableDeclarationList_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // ',' variableDeclaration
  private static boolean variableDeclarationList_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "variableDeclarationList_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OP_COMMA);
    result_ = result_ && variableDeclaration(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // (methodCall | identifier) ('[' expressionSequence ']')*
  public static boolean variableReference(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "variableReference")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
      result_ = variableReference_0(builder_, level_ + 1);
    result_ = result_ && variableReference_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, VARIABLE_REFERENCE, result_);
    return result_;
  }

    // methodCall | identifier
    private static boolean variableReference_0(PsiBuilder builder_, int level_) {
        if (!recursion_guard_(builder_, level_, "variableReference_0")) return false;
        boolean result_;
        Marker marker_ = enter_section_(builder_);
        result_ = methodCall(builder_, level_ + 1);
        if (!result_) result_ = consumeToken(builder_, IDENTIFIER);
        exit_section_(builder_, marker_, null, result_);
        return result_;
    }

  // ('[' expressionSequence ']')*
  private static boolean variableReference_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "variableReference_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!variableReference_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "variableReference_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // '[' expressionSequence ']'
  private static boolean variableReference_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "variableReference_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, OP_LBRACKET);
    result_ = result_ && expressionSequence(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, OP_RBRACKET);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // modifier variableDeclarationList eos
  public static boolean variableStatement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "variableStatement")) return false;
    if (!nextTokenIs(builder_, "<variable statement>", KW_GLOBAL, KW_VAR)) return false;
    boolean result_;
    boolean pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<variable statement>");
    result_ = modifier(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, variableDeclarationList(builder_, level_ + 1));
    result_ = pinned_ && eos(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, VARIABLE_STATEMENT, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // 'while' '(' expressionSequence ')'
  public static boolean whileCondition(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "whileCondition")) return false;
    if (!nextTokenIs(builder_, KW_WHILE)) return false;
    boolean result_;
    boolean pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = consumeToken(builder_, KW_WHILE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, consumeToken(builder_, OP_LPAREN));
    result_ = pinned_ && report_error_(builder_, expressionSequence(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, OP_RPAREN) && result_;
    exit_section_(builder_, level_, marker_, WHILE_CONDITION, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // whileCondition statement
  public static boolean whileStatement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "whileStatement")) return false;
    if (!nextTokenIs(builder_, KW_WHILE)) return false;
    boolean result_;
      boolean pinned_;
      Marker marker_ = enter_section_(builder_, level_, _NONE_, null);
    result_ = whileCondition(builder_, level_ + 1);
      pinned_ = result_; // pin = 1
    result_ = result_ && statement(builder_, level_ + 1);
      exit_section_(builder_, level_, marker_, WHILE_STATEMENT, result_, pinned_, null);
      return result_ || pinned_;
  }

  final static Parser singleExpressionPartRecover_parser_ = new Parser() {
    public boolean parse(PsiBuilder builder_, int level_) {
      return singleExpressionPartRecover(builder_, level_ + 1);
    }
  };
  final static Parser singleExpressionRecover_parser_ = new Parser() {
    public boolean parse(PsiBuilder builder_, int level_) {
      return singleExpressionRecover(builder_, level_ + 1);
    }
  };
}
