// This is a generated file. Not intended for manual editing.
package com.plopiplop.leekwars.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.plopiplop.leekwars.psi.LSTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class LeekScriptParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == ADDITIVE_EXPRESSION) {
      r = additiveExpression(b, 0);
    }
    else if (t == ARGUMENT_LIST) {
      r = argumentList(b, 0);
    }
    else if (t == ARGUMENTS) {
      r = arguments(b, 0);
    }
    else if (t == ARRAY_LITERAL) {
      r = arrayLiteral(b, 0);
    }
    else if (t == ASSIGN_EXPRESSION) {
      r = assignExpression(b, 0);
    }
    else if (t == BITWISE_EXPRESSION) {
      r = bitwiseExpression(b, 0);
    }
    else if (t == BLOCK) {
      r = block(b, 0);
    }
    else if (t == BREAK_STATEMENT) {
      r = breakStatement(b, 0);
    }
    else if (t == COMPARE_EXPRESSION) {
      r = compareExpression(b, 0);
    }
    else if (t == CONTINUE_STATEMENT) {
      r = continueStatement(b, 0);
    }
    else if (t == DO_WHILE_STATEMENT) {
      r = doWhileStatement(b, 0);
    }
    else if (t == ELEMENT_LIST) {
      r = elementList(b, 0);
    }
    else if (t == ELSE_BLOCK) {
      r = elseBlock(b, 0);
    }
    else if (t == EMPTY_STATEMENT) {
      r = emptyStatement(b, 0);
    }
    else if (t == EOS) {
      r = eos(b, 0);
    }
    else if (t == EXPRESSION_STATEMENT) {
      r = expressionStatement(b, 0);
    }
    else if (t == FOR_INITIALIZER) {
      r = forInitializer(b, 0);
    }
    else if (t == FOR_STATEMENT) {
      r = forStatement(b, 0);
    }
    else if (t == FORMAL_PARAMETER_LIST) {
      r = formalParameterList(b, 0);
    }
    else if (t == FUNCTION_DECLARATION) {
      r = functionDeclaration(b, 0);
    }
    else if (t == FUNCTION_EXPRESSION) {
      r = functionExpression(b, 0);
    }
    else if (t == FUNCTION_NAME) {
      r = functionName(b, 0);
    }
    else if (t == IF_STATEMENT) {
      r = ifStatement(b, 0);
    }
    else if (t == INITIALISER) {
      r = initialiser(b, 0);
    }
    else if (t == KEYVAL) {
      r = keyval(b, 0);
    }
    else if (t == KEYVAL_LIST) {
      r = keyvalList(b, 0);
    }
    else if (t == LITERAL) {
      r = literal(b, 0);
    }
    else if (t == LOGIC_AND_EXPRESSION) {
      r = logicAndExpression(b, 0);
    }
    else if (t == LOGIC_OR_EXPRESSION) {
      r = logicOrExpression(b, 0);
    }
    else if (t == METHOD_CALL) {
      r = methodCall(b, 0);
    }
    else if (t == MODIFIER) {
      r = modifier(b, 0);
    }
    else if (t == MULTIPLICATIVE_EXPRESSION) {
      r = multiplicativeExpression(b, 0);
    }
    else if (t == PARAMETER) {
      r = parameter(b, 0);
    }
    else if (t == PREFIX_EXPRESSION) {
      r = prefixExpression(b, 0);
    }
    else if (t == PREFIX_OPERATOR) {
      r = prefixOperator(b, 0);
    }
    else if (t == PRIMARY_EXPRESSION) {
      r = primaryExpression(b, 0);
    }
    else if (t == REFERENCE_EXPRESSION) {
      r = referenceExpression(b, 0);
    }
    else if (t == RETURN_STATEMENT) {
      r = returnStatement(b, 0);
    }
    else if (t == SHIFT_EXPRESSION) {
      r = shiftExpression(b, 0);
    }
    else if (t == SINGLE_EXPRESSION) {
      r = singleExpression(b, 0);
    }
    else if (t == STATEMENT_LIST) {
      r = statementList(b, 0);
    }
    else if (t == SUFFIX_EXPRESSION) {
      r = suffixExpression(b, 0);
    }
    else if (t == TERNARY_EXPRESSION) {
      r = ternaryExpression(b, 0);
    }
    else if (t == THEN_BLOCK) {
      r = thenBlock(b, 0);
    }
    else if (t == VARIABLE_DECLARATION) {
      r = variableDeclaration(b, 0);
    }
    else if (t == VARIABLE_STATEMENT) {
      r = variableStatement(b, 0);
    }
    else if (t == WHILE_CONDITION) {
      r = whileCondition(b, 0);
    }
    else if (t == WHILE_STATEMENT) {
      r = whileStatement(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return program(b, l + 1);
  }

  /* ********************************************************** */
  // additiveOperator multiplicativeExpressionWrapper
  public static boolean additiveExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additiveExpression")) return false;
    if (!nextTokenIs(b, "<additive expression>", OP_MINUS, OP_PLUS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, ADDITIVE_EXPRESSION, "<additive expression>");
    r = additiveOperator(b, l + 1);
    r = r && multiplicativeExpressionWrapper(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // multiplicativeExpressionWrapper additiveExpression*
  static boolean additiveExpressionWrapper(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additiveExpressionWrapper")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = multiplicativeExpressionWrapper(b, l + 1);
    r = r && additiveExpressionWrapper_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // additiveExpression*
  private static boolean additiveExpressionWrapper_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additiveExpressionWrapper_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!additiveExpression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "additiveExpressionWrapper_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // '+' | '-'
  static boolean additiveOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additiveOperator")) return false;
    if (!nextTokenIs(b, "", OP_MINUS, OP_PLUS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_PLUS);
    if (!r) r = consumeToken(b, OP_MINUS);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // singleExpressionPart (',' singleExpressionPart)*
  public static boolean argumentList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argumentList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENT_LIST, "<argument list>");
    r = singleExpressionPart(b, l + 1);
    r = r && argumentList_1(b, l + 1);
    exit_section_(b, l, m, r, false, singleExpressionRecover_parser_);
    return r;
  }

  // (',' singleExpressionPart)*
  private static boolean argumentList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argumentList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!argumentList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "argumentList_1", c)) break;
    }
    return true;
  }

  // ',' singleExpressionPart
  private static boolean argumentList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argumentList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_COMMA);
    r = r && singleExpressionPart(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '(' argumentList? ')'
  public static boolean arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arguments")) return false;
    if (!nextTokenIs(b, OP_LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_LPAREN);
    r = r && arguments_1(b, l + 1);
    r = r && consumeToken(b, OP_RPAREN);
    exit_section_(b, m, ARGUMENTS, r);
    return r;
  }

  // argumentList?
  private static boolean arguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arguments_1")) return false;
    argumentList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '[' (keyvalList | elementList)? ']'
  public static boolean arrayLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayLiteral")) return false;
    if (!nextTokenIs(b, OP_LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_LBRACKET);
    r = r && arrayLiteral_1(b, l + 1);
    r = r && consumeToken(b, OP_RBRACKET);
    exit_section_(b, m, ARRAY_LITERAL, r);
    return r;
  }

  // (keyvalList | elementList)?
  private static boolean arrayLiteral_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayLiteral_1")) return false;
    arrayLiteral_1_0(b, l + 1);
    return true;
  }

  // keyvalList | elementList
  private static boolean arrayLiteral_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayLiteral_1_0")) return false;
    boolean r;
    r = keyvalList(b, l + 1);
    if (!r) r = elementList(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // assignmentOperator ternaryExpressionWrapper
  public static boolean assignExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignExpression")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _LEFT_, ASSIGN_EXPRESSION, "<assign expression>");
    r = assignmentOperator(b, l + 1);
    p = r; // pin = 1
    r = r && ternaryExpressionWrapper(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // ternaryExpressionWrapper assignExpression*
  static boolean assignExpressionWrapper(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignExpressionWrapper")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ternaryExpressionWrapper(b, l + 1);
    r = r && assignExpressionWrapper_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // assignExpression*
  private static boolean assignExpressionWrapper_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignExpressionWrapper_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!assignExpression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "assignExpressionWrapper_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // '=' | '+=' | '-=' | '*=' | '/=' | '&=' | '|=' | '^='
  static boolean assignmentOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignmentOperator")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_ASSIGN);
    if (!r) r = consumeToken(b, OP_PLUS_EQ);
    if (!r) r = consumeToken(b, OP_MINUS_EQ);
    if (!r) r = consumeToken(b, OP_TIMES_EQ);
    if (!r) r = consumeToken(b, OP_DIVIDE_EQ);
    if (!r) r = consumeToken(b, OP_AND_EQ);
    if (!r) r = consumeToken(b, OP_OR_EQ);
    if (!r) r = consumeToken(b, OP_XOR_EQ);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // bitwiseOperator shiftExpressionWrapper
  public static boolean bitwiseExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitwiseExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, BITWISE_EXPRESSION, "<bitwise expression>");
    r = bitwiseOperator(b, l + 1);
    r = r && shiftExpressionWrapper(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // shiftExpressionWrapper bitwiseExpression*
  static boolean bitwiseExpressionWrapper(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitwiseExpressionWrapper")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = shiftExpressionWrapper(b, l + 1);
    r = r && bitwiseExpressionWrapper_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // bitwiseExpression*
  private static boolean bitwiseExpressionWrapper_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitwiseExpressionWrapper_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!bitwiseExpression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "bitwiseExpressionWrapper_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // '&' | '^' | '|'
  static boolean bitwiseOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitwiseOperator")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_BINARY_AND);
    if (!r) r = consumeToken(b, OP_XOR);
    if (!r) r = consumeToken(b, OP_BINARY_OR);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '{' statementList? '}'
  public static boolean block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block")) return false;
    if (!nextTokenIs(b, OP_LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_LBRACE);
    r = r && block_1(b, l + 1);
    r = r && consumeToken(b, OP_RBRACE);
    exit_section_(b, m, BLOCK, r);
    return r;
  }

  // statementList?
  private static boolean block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_1")) return false;
    statementList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'break' eos
  public static boolean breakStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "breakStatement")) return false;
    if (!nextTokenIs(b, KW_BREAK)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BREAK_STATEMENT, null);
    r = consumeToken(b, KW_BREAK);
    p = r; // pin = 1
    r = r && eos(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // (comparisonOperator | equalityOperator) bitwiseExpressionWrapper
  public static boolean compareExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compareExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, COMPARE_EXPRESSION, "<compare expression>");
    r = compareExpression_0(b, l + 1);
    r = r && bitwiseExpressionWrapper(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // comparisonOperator | equalityOperator
  private static boolean compareExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compareExpression_0")) return false;
    boolean r;
    r = comparisonOperator(b, l + 1);
    if (!r) r = equalityOperator(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // bitwiseExpressionWrapper compareExpression*
  static boolean compareExpressionWrapper(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compareExpressionWrapper")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bitwiseExpressionWrapper(b, l + 1);
    r = r && compareExpressionWrapper_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // compareExpression*
  private static boolean compareExpressionWrapper_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compareExpressionWrapper_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!compareExpression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "compareExpressionWrapper_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // '<=' | '>=' | '<' | '>'
  static boolean comparisonOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comparisonOperator")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_LE);
    if (!r) r = consumeToken(b, OP_GE);
    if (!r) r = consumeToken(b, OP_LT);
    if (!r) r = consumeToken(b, OP_GT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'continue' eos
  public static boolean continueStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "continueStatement")) return false;
    if (!nextTokenIs(b, KW_CONTINUE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CONTINUE_STATEMENT, null);
    r = consumeToken(b, KW_CONTINUE);
    p = r; // pin = 1
    r = r && eos(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'do' (block | statement) whileCondition eos
  public static boolean doWhileStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "doWhileStatement")) return false;
    if (!nextTokenIs(b, KW_DO)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, DO_WHILE_STATEMENT, null);
    r = consumeToken(b, KW_DO);
    p = r; // pin = 1
    r = r && report_error_(b, doWhileStatement_1(b, l + 1));
    r = p && report_error_(b, whileCondition(b, l + 1)) && r;
    r = p && eos(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // block | statement
  private static boolean doWhileStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "doWhileStatement_1")) return false;
    boolean r;
    r = block(b, l + 1);
    if (!r) r = statement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // singleExpression (',' singleExpression)*
  public static boolean elementList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elementList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ELEMENT_LIST, "<element list>");
    r = singleExpression(b, l + 1);
    r = r && elementList_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (',' singleExpression)*
  private static boolean elementList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elementList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!elementList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "elementList_1", c)) break;
    }
    return true;
  }

  // ',' singleExpression
  private static boolean elementList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elementList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_COMMA);
    r = r && singleExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'else' (block | statement)
  public static boolean elseBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseBlock")) return false;
    if (!nextTokenIs(b, KW_ELSE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ELSE_BLOCK, null);
    r = consumeToken(b, KW_ELSE);
    p = r; // pin = 1
    r = r && elseBlock_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // block | statement
  private static boolean elseBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseBlock_1")) return false;
    boolean r;
    r = block(b, l + 1);
    if (!r) r = statement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // ';'
  public static boolean emptyStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "emptyStatement")) return false;
    if (!nextTokenIs(b, OP_SEMICOLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_SEMICOLON);
    exit_section_(b, m, EMPTY_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // ';'
  public static boolean eos(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "eos")) return false;
    if (!nextTokenIs(b, OP_SEMICOLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_SEMICOLON);
    exit_section_(b, m, EOS, r);
    return r;
  }

  /* ********************************************************** */
  // '===' | '==' | '!==' | '!='
  static boolean equalityOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equalityOperator")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_IDENTITY_EQUALS);
    if (!r) r = consumeToken(b, OP_EQUALS);
    if (!r) r = consumeToken(b, OP_IDENTITY_NOT_EQUALS);
    if (!r) r = consumeToken(b, OP_NOT_EQUALS);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // singleExpression eos
  public static boolean expressionStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expressionStatement")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION_STATEMENT, "<expression statement>");
    r = singleExpression(b, l + 1);
    p = r; // pin = 1
    r = r && eos(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'var'? referenceExpression
  public static boolean forInitializer(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forInitializer")) return false;
    if (!nextTokenIs(b, "<for initializer>", IDENTIFIER, KW_VAR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FOR_INITIALIZER, "<for initializer>");
    r = forInitializer_0(b, l + 1);
    r = r && referenceExpression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'var'?
  private static boolean forInitializer_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forInitializer_0")) return false;
    consumeToken(b, KW_VAR);
    return true;
  }

  /* ********************************************************** */
  // 'for' '(' forInitializer ((':' forInitializer)? 'in' singleExpression | initialiser ';' singleExpression ';' singleExpression) ')' (block | statement)
  public static boolean forStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forStatement")) return false;
    if (!nextTokenIs(b, KW_FOR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FOR_STATEMENT, null);
    r = consumeTokens(b, 1, KW_FOR, OP_LPAREN);
    p = r; // pin = 1
    r = r && report_error_(b, forInitializer(b, l + 1));
    r = p && report_error_(b, forStatement_3(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, OP_RPAREN)) && r;
    r = p && forStatement_5(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (':' forInitializer)? 'in' singleExpression | initialiser ';' singleExpression ';' singleExpression
  private static boolean forStatement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forStatement_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = forStatement_3_0(b, l + 1);
    if (!r) r = forStatement_3_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (':' forInitializer)? 'in' singleExpression
  private static boolean forStatement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forStatement_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = forStatement_3_0_0(b, l + 1);
    r = r && consumeToken(b, KW_IN);
    r = r && singleExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (':' forInitializer)?
  private static boolean forStatement_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forStatement_3_0_0")) return false;
    forStatement_3_0_0_0(b, l + 1);
    return true;
  }

  // ':' forInitializer
  private static boolean forStatement_3_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forStatement_3_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_COLON);
    r = r && forInitializer(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // initialiser ';' singleExpression ';' singleExpression
  private static boolean forStatement_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forStatement_3_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = initialiser(b, l + 1);
    r = r && consumeToken(b, OP_SEMICOLON);
    r = r && singleExpression(b, l + 1);
    r = r && consumeToken(b, OP_SEMICOLON);
    r = r && singleExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // block | statement
  private static boolean forStatement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forStatement_5")) return false;
    boolean r;
    r = block(b, l + 1);
    if (!r) r = statement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // parameter (',' parameter)*
  public static boolean formalParameterList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "formalParameterList")) return false;
    if (!nextTokenIs(b, "<formal parameter list>", IDENTIFIER, OP_REFERENCE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FORMAL_PARAMETER_LIST, "<formal parameter list>");
    r = parameter(b, l + 1);
    r = r && formalParameterList_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (',' parameter)*
  private static boolean formalParameterList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "formalParameterList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!formalParameterList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "formalParameterList_1", c)) break;
    }
    return true;
  }

  // ',' parameter
  private static boolean formalParameterList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "formalParameterList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_COMMA);
    r = r && parameter(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'function' functionName '(' formalParameterList? ')' block
  public static boolean functionDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDeclaration")) return false;
    if (!nextTokenIs(b, KW_FUNCTION)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_DECLARATION, null);
    r = consumeToken(b, KW_FUNCTION);
    p = r; // pin = 1
    r = r && report_error_(b, functionName(b, l + 1));
    r = p && report_error_(b, consumeToken(b, OP_LPAREN)) && r;
    r = p && report_error_(b, functionDeclaration_3(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, OP_RPAREN)) && r;
    r = p && block(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // formalParameterList?
  private static boolean functionDeclaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDeclaration_3")) return false;
    formalParameterList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'function' '(' formalParameterList? ')' block
  public static boolean functionExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionExpression")) return false;
    if (!nextTokenIs(b, KW_FUNCTION)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_EXPRESSION, null);
    r = consumeTokens(b, 1, KW_FUNCTION, OP_LPAREN);
    p = r; // pin = 1
    r = r && report_error_(b, functionExpression_2(b, l + 1));
    r = p && report_error_(b, consumeToken(b, OP_RPAREN)) && r;
    r = p && block(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // formalParameterList?
  private static boolean functionExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionExpression_2")) return false;
    formalParameterList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // identifier
  public static boolean functionName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionName")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, FUNCTION_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // 'if' '(' singleExpression ')' thenBlock elseBlock?
  public static boolean ifStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifStatement")) return false;
    if (!nextTokenIs(b, KW_IF)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, IF_STATEMENT, null);
    r = consumeTokens(b, 1, KW_IF, OP_LPAREN);
    p = r; // pin = 1
    r = r && report_error_(b, singleExpression(b, l + 1));
    r = p && report_error_(b, consumeToken(b, OP_RPAREN)) && r;
    r = p && report_error_(b, thenBlock(b, l + 1)) && r;
    r = p && ifStatement_5(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // elseBlock?
  private static boolean ifStatement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifStatement_5")) return false;
    elseBlock(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '=' singleExpression
  public static boolean initialiser(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "initialiser")) return false;
    if (!nextTokenIs(b, OP_ASSIGN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, INITIALISER, null);
    r = consumeToken(b, OP_ASSIGN);
    p = r; // pin = 1
    r = r && singleExpression(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // singleExpression ':' singleExpression
  public static boolean keyval(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "keyval")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KEYVAL, "<keyval>");
    r = singleExpression(b, l + 1);
    r = r && consumeToken(b, OP_COLON);
    r = r && singleExpression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // keyval (',' keyval)*
  public static boolean keyvalList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "keyvalList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KEYVAL_LIST, "<keyval list>");
    r = keyval(b, l + 1);
    r = r && keyvalList_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (',' keyval)*
  private static boolean keyvalList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "keyvalList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!keyvalList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "keyvalList_1", c)) break;
    }
    return true;
  }

  // ',' keyval
  private static boolean keyvalList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "keyvalList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_COMMA);
    r = r && keyval(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // memberExpression
  static boolean leftHandSideExpression(PsiBuilder b, int l) {
    return memberExpression(b, l + 1);
  }

  /* ********************************************************** */
  // 'null' | 'true' | 'false' | string | number
  public static boolean literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL, "<literal>");
    r = consumeToken(b, KW_NULL);
    if (!r) r = consumeToken(b, KW_TRUE);
    if (!r) r = consumeToken(b, KW_FALSE);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, NUMBER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ('&&' | 'and') compareExpressionWrapper
  public static boolean logicAndExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicAndExpression")) return false;
    if (!nextTokenIs(b, "<logic and expression>", OP_AND, OP_LOGICAL_AND)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, LOGIC_AND_EXPRESSION, "<logic and expression>");
    r = logicAndExpression_0(b, l + 1);
    r = r && compareExpressionWrapper(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '&&' | 'and'
  private static boolean logicAndExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicAndExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_LOGICAL_AND);
    if (!r) r = consumeToken(b, OP_AND);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // compareExpressionWrapper logicAndExpression*
  static boolean logicAndExpressionWrapper(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicAndExpressionWrapper")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = compareExpressionWrapper(b, l + 1);
    r = r && logicAndExpressionWrapper_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // logicAndExpression*
  private static boolean logicAndExpressionWrapper_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicAndExpressionWrapper_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!logicAndExpression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "logicAndExpressionWrapper_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ('||' | 'or') logicAndExpressionWrapper
  public static boolean logicOrExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicOrExpression")) return false;
    if (!nextTokenIs(b, "<logic or expression>", OP_LOGICAL_OR, OP_OR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, LOGIC_OR_EXPRESSION, "<logic or expression>");
    r = logicOrExpression_0(b, l + 1);
    r = r && logicAndExpressionWrapper(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '||' | 'or'
  private static boolean logicOrExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicOrExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_LOGICAL_OR);
    if (!r) r = consumeToken(b, OP_OR);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // logicAndExpressionWrapper logicOrExpression*
  static boolean logicOrExpressionWrapper(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicOrExpressionWrapper")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = logicAndExpressionWrapper(b, l + 1);
    r = r && logicOrExpressionWrapper_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // logicOrExpression*
  private static boolean logicOrExpressionWrapper_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicOrExpressionWrapper_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!logicOrExpression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "logicOrExpressionWrapper_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (methodCall | primaryExpression | functionExpression) ('[' singleExpression ']')*
  static boolean memberExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "memberExpression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = memberExpression_0(b, l + 1);
    r = r && memberExpression_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // methodCall | primaryExpression | functionExpression
  private static boolean memberExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "memberExpression_0")) return false;
    boolean r;
    r = methodCall(b, l + 1);
    if (!r) r = primaryExpression(b, l + 1);
    if (!r) r = functionExpression(b, l + 1);
    return r;
  }

  // ('[' singleExpression ']')*
  private static boolean memberExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "memberExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!memberExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "memberExpression_1", c)) break;
    }
    return true;
  }

  // '[' singleExpression ']'
  private static boolean memberExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "memberExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_LBRACKET);
    r = r && singleExpression(b, l + 1);
    r = r && consumeToken(b, OP_RBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // referenceExpression arguments+
  public static boolean methodCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodCall")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = referenceExpression(b, l + 1);
    r = r && methodCall_1(b, l + 1);
    exit_section_(b, m, METHOD_CALL, r);
    return r;
  }

  // arguments+
  private static boolean methodCall_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodCall_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = arguments(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!arguments(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "methodCall_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'var' | 'global'
  public static boolean modifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier")) return false;
    if (!nextTokenIs(b, "<modifier>", KW_GLOBAL, KW_VAR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MODIFIER, "<modifier>");
    r = consumeToken(b, KW_VAR);
    if (!r) r = consumeToken(b, KW_GLOBAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // multiplicativeOperator prefixExpression
  public static boolean multiplicativeExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicativeExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, MULTIPLICATIVE_EXPRESSION, "<multiplicative expression>");
    r = multiplicativeOperator(b, l + 1);
    r = r && prefixExpression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // prefixExpression multiplicativeExpression*
  static boolean multiplicativeExpressionWrapper(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicativeExpressionWrapper")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = prefixExpression(b, l + 1);
    r = r && multiplicativeExpressionWrapper_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // multiplicativeExpression*
  private static boolean multiplicativeExpressionWrapper_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicativeExpressionWrapper_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!multiplicativeExpression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "multiplicativeExpressionWrapper_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // '**' | '*' | '/' | '%'
  static boolean multiplicativeOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicativeOperator")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_POW);
    if (!r) r = consumeToken(b, OP_TIMES);
    if (!r) r = consumeToken(b, OP_DIVIDE);
    if (!r) r = consumeToken(b, OP_MODULO);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '@'? identifier
  public static boolean parameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter")) return false;
    if (!nextTokenIs(b, "<parameter>", IDENTIFIER, OP_REFERENCE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAMETER, "<parameter>");
    r = parameter_0(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '@'?
  private static boolean parameter_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_0")) return false;
    consumeToken(b, OP_REFERENCE);
    return true;
  }

  /* ********************************************************** */
  // (prefixOperator prefixExpression) | suffixExpressionWrapper
  public static boolean prefixExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefixExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PREFIX_EXPRESSION, "<prefix expression>");
    r = prefixExpression_0(b, l + 1);
    if (!r) r = suffixExpressionWrapper(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // prefixOperator prefixExpression
  private static boolean prefixExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefixExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = prefixOperator(b, l + 1);
    r = r && prefixExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '-' |  '!' | 'not'
  public static boolean prefixOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefixOperator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PREFIX_OPERATOR, "<prefix operator>");
    r = consumeToken(b, OP_MINUS);
    if (!r) r = consumeToken(b, OP_EXCLAMATION_MARK);
    if (!r) r = consumeToken(b, OP_NOT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // referenceExpression | literal | arrayLiteral | '(' singleExpression ')'
  public static boolean primaryExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRIMARY_EXPRESSION, "<primary expression>");
    r = referenceExpression(b, l + 1);
    if (!r) r = literal(b, l + 1);
    if (!r) r = arrayLiteral(b, l + 1);
    if (!r) r = primaryExpression_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '(' singleExpression ')'
  private static boolean primaryExpression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryExpression_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_LPAREN);
    r = r && singleExpression(b, l + 1);
    r = r && consumeToken(b, OP_RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // sourceElements? <<eof>>
  static boolean program(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "program")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = program_0(b, l + 1);
    r = r && eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // sourceElements?
  private static boolean program_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "program_0")) return false;
    sourceElements(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // identifier
  public static boolean referenceExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "referenceExpression")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, REFERENCE_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // 'return' singleExpression? eos
  public static boolean returnStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "returnStatement")) return false;
    if (!nextTokenIs(b, KW_RETURN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RETURN_STATEMENT, null);
    r = consumeToken(b, KW_RETURN);
    r = r && returnStatement_1(b, l + 1);
    p = r; // pin = 2
    r = r && eos(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // singleExpression?
  private static boolean returnStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "returnStatement_1")) return false;
    singleExpression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // shiftOperator additiveExpressionWrapper
  public static boolean shiftExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shiftExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, SHIFT_EXPRESSION, "<shift expression>");
    r = shiftOperator(b, l + 1);
    r = r && additiveExpressionWrapper(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // additiveExpressionWrapper shiftExpression*
  static boolean shiftExpressionWrapper(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shiftExpressionWrapper")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = additiveExpressionWrapper(b, l + 1);
    r = r && shiftExpressionWrapper_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // shiftExpression*
  private static boolean shiftExpressionWrapper_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shiftExpressionWrapper_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!shiftExpression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "shiftExpressionWrapper_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // '>>>' | '<<' | '>>'
  static boolean shiftOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shiftOperator")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_UNSIGNED_RSHIFT);
    if (!r) r = consumeToken(b, OP_LSHIFT);
    if (!r) r = consumeToken(b, OP_RSHIFT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // assignExpressionWrapper
  public static boolean singleExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "singleExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SINGLE_EXPRESSION, "<single expression>");
    r = assignExpressionWrapper(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // singleExpression
  static boolean singleExpressionPart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "singleExpressionPart")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = singleExpression(b, l + 1);
    exit_section_(b, l, m, r, false, singleExpressionPartRecover_parser_);
    return r;
  }

  /* ********************************************************** */
  // !(')' | ',')
  static boolean singleExpressionPartRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "singleExpressionPartRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !singleExpressionPartRecover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ')' | ','
  private static boolean singleExpressionPartRecover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "singleExpressionPartRecover_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_RPAREN);
    if (!r) r = consumeToken(b, OP_COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !(')')
  static boolean singleExpressionRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "singleExpressionRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, OP_RPAREN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // functionDeclaration | statement | c_style_comment | doc_comment
  static boolean sourceElement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sourceElement")) return false;
    boolean r;
    r = functionDeclaration(b, l + 1);
    if (!r) r = statement(b, l + 1);
    if (!r) r = consumeToken(b, C_STYLE_COMMENT);
    if (!r) r = consumeToken(b, DOC_COMMENT);
    return r;
  }

  /* ********************************************************** */
  // sourceElement+
  static boolean sourceElements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sourceElements")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sourceElement(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!sourceElement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "sourceElements", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // variableStatement
  //     |   emptyStatement
  //     |   expressionStatement
  //     |   ifStatement
  //     |   whileStatement
  //     |   doWhileStatement
  //     |   forStatement
  //     |   returnStatement
  //     |   breakStatement
  //     |   continueStatement
  static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    r = variableStatement(b, l + 1);
    if (!r) r = emptyStatement(b, l + 1);
    if (!r) r = expressionStatement(b, l + 1);
    if (!r) r = ifStatement(b, l + 1);
    if (!r) r = whileStatement(b, l + 1);
    if (!r) r = doWhileStatement(b, l + 1);
    if (!r) r = forStatement(b, l + 1);
    if (!r) r = returnStatement(b, l + 1);
    if (!r) r = breakStatement(b, l + 1);
    if (!r) r = continueStatement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // statement+
  public static boolean statementList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statementList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT_LIST, "<statement list>");
    r = statement(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "statementList", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '--' | '++'
  public static boolean suffixExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "suffixExpression")) return false;
    if (!nextTokenIs(b, "<suffix expression>", OP_DEC, OP_INC)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, SUFFIX_EXPRESSION, "<suffix expression>");
    r = consumeToken(b, OP_DEC);
    if (!r) r = consumeToken(b, OP_INC);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // leftHandSideExpression suffixExpression*
  static boolean suffixExpressionWrapper(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "suffixExpressionWrapper")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = leftHandSideExpression(b, l + 1);
    r = r && suffixExpressionWrapper_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // suffixExpression*
  private static boolean suffixExpressionWrapper_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "suffixExpressionWrapper_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!suffixExpression(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "suffixExpressionWrapper_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // '?' singleExpression ':' ternaryExpressionWrapper
  public static boolean ternaryExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ternaryExpression")) return false;
    if (!nextTokenIs(b, OP_TERNARY)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, TERNARY_EXPRESSION, null);
    r = consumeToken(b, OP_TERNARY);
    r = r && singleExpression(b, l + 1);
    r = r && consumeToken(b, OP_COLON);
    r = r && ternaryExpressionWrapper(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // logicOrExpressionWrapper ternaryExpression?
  static boolean ternaryExpressionWrapper(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ternaryExpressionWrapper")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = logicOrExpressionWrapper(b, l + 1);
    r = r && ternaryExpressionWrapper_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ternaryExpression?
  private static boolean ternaryExpressionWrapper_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ternaryExpressionWrapper_1")) return false;
    ternaryExpression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // block | statement
  public static boolean thenBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "thenBlock")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, THEN_BLOCK, "<then block>");
    r = block(b, l + 1);
    if (!r) r = statement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // identifier initialiser?
  public static boolean variableDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableDeclaration")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_DECLARATION, null);
    r = consumeToken(b, IDENTIFIER);
    p = r; // pin = 1
    r = r && variableDeclaration_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // initialiser?
  private static boolean variableDeclaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableDeclaration_1")) return false;
    initialiser(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // variableDeclaration (',' variableDeclaration)*
  static boolean variableDeclarationList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableDeclarationList")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variableDeclaration(b, l + 1);
    r = r && variableDeclarationList_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' variableDeclaration)*
  private static boolean variableDeclarationList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableDeclarationList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!variableDeclarationList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "variableDeclarationList_1", c)) break;
    }
    return true;
  }

  // ',' variableDeclaration
  private static boolean variableDeclarationList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableDeclarationList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_COMMA);
    r = r && variableDeclaration(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // modifier variableDeclarationList eos
  public static boolean variableStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableStatement")) return false;
    if (!nextTokenIs(b, "<variable statement>", KW_GLOBAL, KW_VAR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_STATEMENT, "<variable statement>");
    r = modifier(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, variableDeclarationList(b, l + 1));
    r = p && eos(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'while' '(' singleExpression ')'
  public static boolean whileCondition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whileCondition")) return false;
    if (!nextTokenIs(b, KW_WHILE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, WHILE_CONDITION, null);
    r = consumeTokens(b, 1, KW_WHILE, OP_LPAREN);
    p = r; // pin = 1
    r = r && report_error_(b, singleExpression(b, l + 1));
    r = p && consumeToken(b, OP_RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // whileCondition (block | statement)
  public static boolean whileStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whileStatement")) return false;
    if (!nextTokenIs(b, KW_WHILE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, WHILE_STATEMENT, null);
    r = whileCondition(b, l + 1);
    p = r; // pin = 1
    r = r && whileStatement_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // block | statement
  private static boolean whileStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whileStatement_1")) return false;
    boolean r;
    r = block(b, l + 1);
    if (!r) r = statement(b, l + 1);
    return r;
  }

  static final Parser singleExpressionPartRecover_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return singleExpressionPartRecover(b, l + 1);
    }
  };
  static final Parser singleExpressionRecover_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return singleExpressionRecover(b, l + 1);
    }
  };
}
