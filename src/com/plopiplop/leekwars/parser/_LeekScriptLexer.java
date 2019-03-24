/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

package com.plopiplop.leekwars.parser;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.plopiplop.leekwars.psi.LSTypes.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>_LeekScriptLexer.flex</tt>
 */
public class _LeekScriptLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [11, 6, 4]
   * Total runtime size is 14112 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[(ZZ_CMAP_Z[ch>>10]<<6)|((ch>>4)&0x3f)]<<4)|(ch&0xf)];
  }

  /* The ZZ_CMAP_Z table has 1088 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\2\11\1\12\1\13\6\14\1\15\23\14\1\16"+
    "\1\14\1\17\1\20\12\14\1\21\10\11\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1"+
    "\32\1\33\1\34\1\35\2\11\1\14\1\36\3\11\1\37\10\11\1\40\1\41\5\14\1\42\1\43"+
    "\11\11\1\44\2\11\1\45\5\11\1\46\4\11\1\47\1\50\4\11\51\14\1\51\3\14\1\52\1"+
    "\53\4\14\1\54\12\11\1\55\u0381\11");

  /* The ZZ_CMAP_Y table has 2944 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\1\1\11\1\12\1\13\1\14\1\13\1\14\34"+
    "\13\1\15\1\16\1\17\10\1\1\20\1\21\1\13\1\22\4\13\1\23\10\13\1\24\12\13\1\25"+
    "\1\13\1\26\1\25\1\13\1\27\4\1\1\13\1\30\1\31\2\1\2\13\1\30\1\1\1\32\1\25\5"+
    "\13\1\33\1\34\1\35\1\1\1\36\1\13\1\1\1\37\5\13\1\40\1\41\1\42\1\13\1\30\1"+
    "\43\1\13\1\44\1\45\1\1\1\13\1\46\4\1\1\13\1\47\4\1\1\50\2\13\1\51\1\1\1\52"+
    "\1\16\1\25\1\53\1\54\1\55\1\56\1\57\1\60\2\16\1\61\1\54\1\55\1\62\1\1\1\63"+
    "\1\1\1\64\1\65\1\22\1\55\1\66\1\1\1\67\1\16\1\70\1\71\1\54\1\55\1\66\1\1\1"+
    "\60\1\16\1\41\1\72\1\73\1\74\1\75\1\1\1\67\2\1\1\76\1\36\1\55\1\51\1\1\1\77"+
    "\1\16\1\1\1\100\1\36\1\55\1\101\1\1\1\57\1\16\1\102\1\76\1\36\1\13\1\103\1"+
    "\57\1\104\1\16\1\42\1\105\1\106\1\13\1\107\1\110\3\1\1\25\2\13\1\111\1\110"+
    "\3\1\1\112\1\113\1\114\1\115\1\116\1\117\2\1\1\67\3\1\1\120\1\13\1\121\1\1"+
    "\1\122\7\1\2\13\1\30\1\123\1\1\1\124\1\125\1\126\1\127\1\1\2\13\1\130\2\13"+
    "\1\131\24\13\1\132\1\133\2\13\1\132\2\13\1\134\1\135\1\14\3\13\1\135\3\13"+
    "\1\30\2\1\1\13\1\1\5\13\1\136\1\25\45\13\1\137\1\13\1\25\1\30\4\13\1\30\1"+
    "\140\1\141\1\16\1\13\1\16\1\13\1\16\1\141\1\67\3\13\1\142\1\1\1\143\4\1\5"+
    "\13\1\27\1\144\1\13\1\145\4\13\1\40\1\13\1\146\3\1\1\13\1\147\1\150\2\13\1"+
    "\151\1\13\1\75\3\1\1\13\1\110\3\13\1\150\4\1\1\152\5\1\1\105\2\13\1\142\1"+
    "\153\3\1\1\154\1\13\1\155\1\42\2\13\1\40\1\1\2\13\1\142\1\1\1\37\1\42\1\13"+
    "\1\147\1\46\5\1\1\156\1\157\14\13\4\1\21\13\1\136\2\13\1\136\1\160\1\13\1"+
    "\147\3\13\1\161\1\162\1\163\1\121\1\162\2\1\1\164\4\1\1\165\1\1\1\121\6\1"+
    "\1\166\1\167\1\170\1\171\1\172\3\1\1\173\147\1\2\13\1\146\2\13\1\146\10\13"+
    "\1\174\1\175\2\13\1\130\3\13\1\176\1\1\1\13\1\110\4\177\4\1\1\123\35\1\1\200"+
    "\2\1\1\201\1\25\4\13\1\202\1\25\4\13\1\131\1\105\1\13\1\147\1\25\4\13\1\146"+
    "\1\1\1\13\1\30\3\1\1\13\40\1\133\13\1\40\4\1\135\13\1\40\2\1\10\13\1\121\4"+
    "\1\2\13\1\147\20\13\1\121\1\13\1\203\1\1\2\13\1\146\1\123\1\13\1\147\4\13"+
    "\1\40\2\1\1\204\1\205\5\13\1\206\1\13\1\146\1\27\3\1\1\204\1\207\1\13\1\31"+
    "\1\1\3\13\1\142\1\205\2\13\1\142\3\1\1\210\1\42\1\13\1\40\1\13\1\110\1\1\1"+
    "\13\1\121\1\50\2\13\1\31\1\123\1\1\1\211\1\212\2\13\1\46\1\1\1\213\1\1\1\13"+
    "\1\214\3\13\1\215\1\216\1\217\1\30\1\64\1\220\1\221\1\177\2\13\1\131\1\40"+
    "\7\13\1\31\1\1\72\13\1\142\1\13\1\222\2\13\1\151\20\1\26\13\1\147\6\13\1\75"+
    "\2\1\1\110\1\223\1\55\1\224\1\225\6\13\1\16\1\1\1\154\25\13\1\147\1\1\4\13"+
    "\1\205\2\13\1\27\2\1\1\151\7\1\1\211\7\13\1\121\2\1\1\25\1\30\1\25\1\30\1"+
    "\226\4\13\1\146\1\227\1\230\2\1\1\231\1\13\1\14\1\232\2\147\2\1\7\13\1\30"+
    "\30\1\1\13\1\121\3\13\1\67\2\1\2\13\1\1\1\13\1\233\2\13\1\40\1\13\1\147\2"+
    "\13\1\234\3\1\11\13\1\147\1\1\2\13\1\234\1\13\1\151\2\13\1\27\3\13\1\142\11"+
    "\1\23\13\1\110\1\13\1\40\1\27\11\1\1\235\2\13\1\236\1\13\1\40\1\13\1\110\1"+
    "\13\1\146\4\1\1\13\1\237\1\13\1\40\1\13\1\75\4\1\3\13\1\240\4\1\1\67\1\241"+
    "\1\13\1\142\2\1\1\13\1\121\1\13\1\121\2\1\1\120\1\13\1\150\1\1\3\13\1\40\1"+
    "\13\1\40\1\13\1\31\1\13\1\16\6\1\4\13\1\46\3\1\3\13\1\31\3\13\1\31\60\1\1"+
    "\154\2\13\1\27\4\1\1\154\2\13\2\1\1\13\1\46\1\1\1\154\1\13\1\110\2\1\2\13"+
    "\1\242\1\154\2\13\1\31\1\243\1\244\2\1\1\13\1\22\1\151\5\1\1\245\1\246\1\46"+
    "\2\13\1\146\2\1\1\71\1\54\1\55\1\66\1\1\1\247\1\16\11\1\3\13\1\150\1\250\3"+
    "\1\3\13\1\1\1\251\13\1\2\13\1\146\2\1\1\252\2\1\3\13\1\1\1\253\3\1\2\13\1"+
    "\30\5\1\1\13\1\75\30\1\4\13\1\1\1\123\34\1\3\13\1\46\20\1\1\55\1\13\1\146"+
    "\1\1\1\67\2\1\1\205\1\13\67\1\71\13\1\75\16\1\14\13\1\142\53\1\2\13\1\146"+
    "\75\1\44\13\1\110\33\1\43\13\1\46\1\13\1\146\7\1\1\13\1\147\1\1\3\13\1\1\1"+
    "\142\1\1\1\154\1\254\1\13\67\1\4\13\1\150\1\67\3\1\1\154\4\1\1\67\1\1\76\13"+
    "\1\121\1\1\57\13\1\31\20\1\1\16\77\1\6\13\1\30\1\121\1\46\1\75\66\1\5\13\1"+
    "\211\3\13\1\141\1\255\1\256\1\257\3\13\1\260\1\261\1\13\1\262\1\263\1\36\24"+
    "\13\1\264\1\13\1\36\1\131\1\13\1\131\1\13\1\211\1\13\1\211\1\146\1\13\1\146"+
    "\1\13\1\55\1\13\1\55\1\13\1\213\3\1\14\13\1\150\3\1\4\13\1\142\113\1\1\257"+
    "\1\13\1\265\1\266\1\267\1\270\1\271\1\272\1\273\1\151\1\274\1\151\24\1\55"+
    "\13\1\110\2\1\103\13\1\150\15\13\1\147\150\13\1\16\25\1\41\13\1\147\36\1");

  /* The ZZ_CMAP_A table has 3024 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\2\1\1\1\11\2\1\22\0\1\2\1\60\1\12\2\0\1\42\1\55\1\7\1\45\1\46\1\14"+
    "\1\40\1\53\1\41\1\6\1\13\12\5\1\44\1\43\1\62\1\54\1\61\1\64\1\63\32\4\1\47"+
    "\1\10\1\50\1\57\1\4\1\0\1\25\1\31\1\20\1\36\1\32\1\15\1\27\1\35\1\22\1\4\1"+
    "\37\1\30\1\4\1\17\1\23\2\4\1\26\1\33\1\21\1\16\1\24\1\34\3\4\1\51\1\56\1\52"+
    "\7\0\1\11\24\0\1\3\12\0\1\3\4\0\1\3\5\0\27\3\1\0\12\3\4\0\14\3\16\0\5\3\7"+
    "\0\1\3\1\0\1\3\1\0\5\3\1\0\2\3\2\0\4\3\1\0\1\3\6\0\1\3\1\0\3\3\1\0\1\3\1\0"+
    "\4\3\1\0\23\3\1\0\13\3\10\0\6\3\1\0\26\3\2\0\1\3\6\0\10\3\10\0\13\3\5\0\3"+
    "\3\33\0\6\3\1\0\1\3\17\0\2\3\7\0\2\3\12\0\3\3\2\0\2\3\1\0\16\3\15\0\11\3\13"+
    "\0\1\3\30\0\6\3\4\0\2\3\4\0\1\3\5\0\6\3\4\0\1\3\11\0\1\3\3\0\1\3\7\0\11\3"+
    "\7\0\5\3\1\0\10\3\6\0\26\3\3\0\1\3\2\0\1\3\7\0\11\3\4\0\10\3\2\0\2\3\2\0\26"+
    "\3\1\0\7\3\1\0\1\3\3\0\4\3\3\0\1\3\20\0\1\3\15\0\2\3\1\0\1\3\5\0\6\3\4\0\2"+
    "\3\1\0\2\3\1\0\2\3\1\0\2\3\17\0\4\3\1\0\1\3\3\0\3\3\20\0\11\3\1\0\2\3\1\0"+
    "\2\3\1\0\5\3\3\0\1\3\2\0\1\3\30\0\1\3\13\0\10\3\2\0\1\3\3\0\1\3\1\0\6\3\3"+
    "\0\3\3\1\0\4\3\3\0\2\3\1\0\1\3\1\0\2\3\3\0\2\3\3\0\3\3\3\0\14\3\13\0\10\3"+
    "\1\0\2\3\10\0\3\3\5\0\1\3\4\0\10\3\1\0\6\3\1\0\5\3\3\0\1\3\3\0\2\3\15\0\13"+
    "\3\2\0\1\3\6\0\3\3\10\0\1\3\5\0\22\3\3\0\10\3\1\0\11\3\1\0\1\3\2\0\7\3\11"+
    "\0\1\3\1\0\2\3\15\0\2\3\1\0\1\3\2\0\2\3\1\0\1\3\2\0\1\3\6\0\4\3\1\0\7\3\1"+
    "\0\3\3\1\0\1\3\1\0\1\3\2\0\2\3\1\0\4\3\1\0\2\3\11\0\1\3\2\0\5\3\1\0\1\3\25"+
    "\0\14\3\1\0\24\3\13\0\5\3\22\0\7\3\4\0\4\3\3\0\1\3\3\0\2\3\7\0\3\3\4\0\15"+
    "\3\14\0\1\3\1\0\6\3\1\0\1\3\5\0\1\3\2\0\13\3\1\0\15\3\1\0\4\3\2\0\7\3\1\0"+
    "\1\3\1\0\4\3\2\0\1\3\1\0\4\3\2\0\7\3\1\0\1\3\1\0\4\3\2\0\16\3\2\0\6\3\2\0"+
    "\15\3\2\0\1\3\1\0\10\3\7\0\15\3\1\0\6\3\23\0\1\3\4\0\1\3\3\0\5\3\2\0\22\3"+
    "\1\0\1\3\5\0\17\3\1\0\16\3\2\0\5\3\13\0\14\3\13\0\1\3\15\0\7\3\7\0\16\3\15"+
    "\0\2\3\11\0\4\3\1\0\4\3\3\0\2\3\11\0\10\3\1\0\1\3\1\0\1\3\1\0\1\3\1\0\6\3"+
    "\1\0\7\3\1\0\1\3\3\0\3\3\1\0\7\3\3\0\4\3\2\0\6\3\14\0\2\11\7\0\1\3\15\0\1"+
    "\3\2\0\1\3\4\0\1\3\2\0\12\3\1\0\1\3\3\0\5\3\6\0\1\3\1\0\1\3\1\0\1\3\1\0\4"+
    "\3\1\0\13\3\2\0\4\3\5\0\5\3\4\0\1\3\4\0\2\3\13\0\5\3\6\0\4\3\3\0\2\3\14\0"+
    "\10\3\7\0\10\3\1\0\7\3\6\0\2\3\12\0\5\3\5\0\2\3\3\0\7\3\6\0\3\3\12\0\2\3\13"+
    "\0\11\3\2\0\27\3\2\0\7\3\1\0\3\3\1\0\4\3\1\0\4\3\2\0\6\3\3\0\1\3\1\0\1\3\2"+
    "\0\5\3\1\0\12\3\12\0\5\3\1\0\3\3\1\0\10\3\4\0\7\3\3\0\1\3\3\0\2\3\1\0\1\3"+
    "\3\0\2\3\2\0\5\3\2\0\1\3\1\0\1\3\30\0\3\3\3\0\6\3\2\0\6\3\2\0\6\3\11\0\7\3"+
    "\4\0\5\3\3\0\5\3\5\0\1\3\1\0\10\3\1\0\5\3\1\0\1\3\1\0\2\3\1\0\2\3\1\0\12\3"+
    "\6\0\12\3\2\0\6\3\2\0\6\3\2\0\6\3\2\0\3\3\3\0\14\3\1\0\16\3\1\0\2\3\1\0\2"+
    "\3\1\0\10\3\6\0\4\3\4\0\16\3\2\0\1\3\1\0\14\3\1\0\2\3\3\0\1\3\2\0\4\3\1\0"+
    "\2\3\12\0\10\3\6\0\6\3\1\0\3\3\1\0\12\3\3\0\1\3\12\0\4\3\25\0\1\3\1\0\1\3"+
    "\3\0\7\3\1\0\1\3\1\0\4\3\1\0\17\3\1\0\2\3\14\0\3\3\7\0\4\3\11\0\2\3\1\0\1"+
    "\3\20\0\4\3\10\0\1\3\13\0\10\3\5\0\3\3\2\0\1\3\2\0\2\3\2\0\4\3\1\0\14\3\1"+
    "\0\1\3\1\0\7\3\1\0\21\3\1\0\4\3\2\0\10\3\1\0\7\3\1\0\14\3\1\0\4\3\1\0\5\3"+
    "\1\0\1\3\3\0\14\3\2\0\10\3\1\0\2\3\1\0\1\3\2\0\1\3\1\0\12\3\1\0\4\3\1\0\1"+
    "\3\1\0\1\3\6\0\1\3\4\0\1\3\1\0\1\3\1\0\1\3\1\0\3\3\1\0\2\3\1\0\1\3\2\0\1\3"+
    "\1\0\1\3\1\0\1\3\1\0\1\3\1\0\1\3\1\0\2\3\1\0\1\3\2\0\4\3\1\0\7\3\1\0\4\3\1"+
    "\0\4\3\1\0\1\3\1\0\12\3\1\0\5\3\1\0\3\3\1\0\5\3\1\0\5\3");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\2\1\1\5\1\6"+
    "\16\3\1\7\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\27\1\30\1\31\1\32\1\33\1\4\1\0"+
    "\1\34\3\0\1\35\1\36\1\37\1\40\1\41\7\3"+
    "\1\42\1\43\1\44\7\3\1\45\1\46\1\47\1\50"+
    "\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\60"+
    "\1\61\1\62\1\63\1\64\1\36\1\65\1\3\1\66"+
    "\2\3\1\67\3\3\1\70\1\71\5\3\1\72\1\73"+
    "\1\74\1\0\2\65\2\3\1\75\1\3\1\76\4\3"+
    "\1\77\1\3\1\36\1\0\1\3\1\100\4\3\1\101"+
    "\1\102\3\3\1\103\1\104\2\3\1\105\1\106\1\107";

  private static int [] zzUnpackAction() {
    int [] result = new int[142];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\65\0\152\0\237\0\324\0\u0109\0\u013e\0\u0173"+
    "\0\u01a8\0\u01dd\0\u0212\0\u0247\0\u027c\0\u02b1\0\u02e6\0\u031b"+
    "\0\u0350\0\u0385\0\u03ba\0\u03ef\0\u0424\0\u0459\0\u048e\0\u04c3"+
    "\0\u04f8\0\65\0\65\0\65\0\65\0\65\0\65\0\65"+
    "\0\65\0\65\0\65\0\u052d\0\u0562\0\u0597\0\u05cc\0\u0601"+
    "\0\u0636\0\u066b\0\65\0\65\0\u06a0\0\u0109\0\65\0\u06d5"+
    "\0\u013e\0\u070a\0\u073f\0\u0774\0\65\0\65\0\65\0\u07a9"+
    "\0\u07de\0\u0813\0\u0848\0\u087d\0\u08b2\0\u08e7\0\237\0\u091c"+
    "\0\237\0\u0951\0\u0986\0\u09bb\0\u09f0\0\u0a25\0\u0a5a\0\u0a8f"+
    "\0\237\0\65\0\65\0\65\0\65\0\u0ac4\0\65\0\65"+
    "\0\65\0\65\0\65\0\u0af9\0\65\0\u0b2e\0\65\0\65"+
    "\0\u0b63\0\u0b98\0\u0bcd\0\237\0\u0c02\0\u0c37\0\237\0\u0c6c"+
    "\0\u0ca1\0\u0cd6\0\237\0\237\0\u0d0b\0\u0d40\0\u0d75\0\u0daa"+
    "\0\u0ddf\0\65\0\65\0\65\0\u0e14\0\u0e49\0\65\0\u0e7e"+
    "\0\u0eb3\0\237\0\u0ee8\0\237\0\u0f1d\0\u0f52\0\u0f87\0\u0fbc"+
    "\0\237\0\u0ff1\0\65\0\u1026\0\u105b\0\237\0\u1090\0\u10c5"+
    "\0\u10fa\0\u112f\0\237\0\237\0\u1164\0\u1199\0\u11ce\0\237"+
    "\0\237\0\u1203\0\u1238\0\237\0\237\0\237";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[142];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\2\3\2\4\1\5\1\2\1\6\2\2\1\7"+
    "\1\10\1\11\1\12\1\4\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\1\23\1\4\1\24\1\25"+
    "\1\4\1\26\1\4\1\27\1\4\1\30\1\31\1\32"+
    "\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42"+
    "\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52"+
    "\1\53\1\54\66\0\2\3\66\0\2\4\7\0\23\4"+
    "\32\0\1\5\1\55\56\0\7\56\1\57\1\60\54\56"+
    "\10\61\1\62\1\61\1\57\52\61\13\0\1\63\1\64"+
    "\37\0\1\65\24\0\1\66\37\0\1\67\14\0\2\4"+
    "\7\0\1\4\1\70\4\4\1\71\1\4\1\72\12\4"+
    "\31\0\2\4\7\0\1\4\1\73\4\4\1\74\14\4"+
    "\31\0\2\4\7\0\6\4\1\75\14\4\31\0\2\4"+
    "\7\0\11\4\1\76\11\4\31\0\2\4\7\0\1\77"+
    "\1\4\1\100\20\4\31\0\2\4\7\0\11\4\1\101"+
    "\11\4\31\0\2\4\7\0\10\4\1\102\12\4\31\0"+
    "\2\4\7\0\2\4\1\103\20\4\31\0\2\4\7\0"+
    "\15\4\1\104\5\4\31\0\2\4\7\0\13\4\1\105"+
    "\7\4\31\0\2\4\7\0\11\4\1\106\11\4\31\0"+
    "\2\4\7\0\13\4\1\107\7\4\31\0\2\4\7\0"+
    "\20\4\1\110\2\4\31\0\2\4\7\0\6\4\1\111"+
    "\14\4\65\0\1\112\13\0\1\113\51\0\1\114\12\0"+
    "\1\115\64\0\1\116\64\0\1\117\1\120\63\0\1\121"+
    "\1\0\1\122\62\0\1\123\64\0\1\124\64\0\1\125"+
    "\4\0\1\126\57\0\1\127\5\0\1\130\7\0\1\55"+
    "\57\0\1\56\1\0\7\56\1\0\53\56\1\61\1\0"+
    "\7\61\1\0\53\61\1\63\1\0\7\63\1\0\53\63"+
    "\14\131\1\132\50\131\4\0\2\4\7\0\2\4\1\133"+
    "\20\4\31\0\2\4\7\0\11\4\1\134\11\4\31\0"+
    "\2\4\7\0\13\4\1\135\7\4\31\0\2\4\7\0"+
    "\13\4\1\136\7\4\31\0\2\4\7\0\4\4\1\137"+
    "\16\4\31\0\2\4\7\0\2\4\1\140\20\4\31\0"+
    "\2\4\7\0\1\4\1\141\21\4\31\0\2\4\7\0"+
    "\3\4\1\142\17\4\31\0\2\4\7\0\11\4\1\143"+
    "\11\4\31\0\2\4\7\0\21\4\1\144\1\4\31\0"+
    "\2\4\7\0\4\4\1\145\16\4\31\0\2\4\7\0"+
    "\6\4\1\146\14\4\31\0\2\4\7\0\15\4\1\147"+
    "\5\4\31\0\2\4\7\0\16\4\1\150\4\4\31\0"+
    "\2\4\7\0\5\4\1\151\15\4\101\0\1\152\64\0"+
    "\1\153\71\0\1\154\3\0\14\131\1\155\50\131\13\156"+
    "\1\157\1\0\50\156\4\0\2\4\7\0\3\4\1\160"+
    "\17\4\31\0\2\4\7\0\16\4\1\161\4\4\31\0"+
    "\2\4\7\0\13\4\1\162\7\4\31\0\2\4\7\0"+
    "\4\4\1\163\16\4\31\0\2\4\7\0\15\4\1\164"+
    "\5\4\31\0\2\4\7\0\13\4\1\165\7\4\31\0"+
    "\2\4\7\0\1\4\1\166\21\4\31\0\2\4\7\0"+
    "\14\4\1\167\6\4\31\0\2\4\7\0\10\4\1\170"+
    "\12\4\31\0\2\4\7\0\15\4\1\171\5\4\31\0"+
    "\2\4\7\0\13\4\1\172\7\4\25\0\13\131\1\173"+
    "\1\155\50\131\14\156\1\174\50\156\4\0\2\4\7\0"+
    "\4\4\1\175\16\4\31\0\2\4\7\0\15\4\1\176"+
    "\5\4\31\0\2\4\7\0\5\4\1\177\15\4\31\0"+
    "\2\4\7\0\1\4\1\200\21\4\31\0\2\4\7\0"+
    "\11\4\1\201\11\4\31\0\2\4\7\0\10\4\1\202"+
    "\12\4\31\0\2\4\7\0\22\4\1\203\31\0\2\4"+
    "\7\0\15\4\1\204\5\4\25\0\13\156\1\157\1\174"+
    "\50\156\4\0\2\4\7\0\5\4\1\205\15\4\31\0"+
    "\2\4\7\0\2\4\1\206\20\4\31\0\2\4\7\0"+
    "\21\4\1\207\1\4\31\0\2\4\7\0\2\4\1\210"+
    "\20\4\31\0\2\4\7\0\13\4\1\211\7\4\31\0"+
    "\2\4\7\0\6\4\1\212\14\4\31\0\2\4\7\0"+
    "\1\4\1\213\21\4\31\0\2\4\7\0\15\4\1\214"+
    "\5\4\31\0\2\4\7\0\2\4\1\215\20\4\31\0"+
    "\2\4\7\0\15\4\1\216\5\4\25\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4717];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\27\1\12\11\7\1\2\11\1\1\1\0"+
    "\1\11\3\0\2\1\3\11\22\1\4\11\1\1\5\11"+
    "\1\1\1\11\1\1\2\11\21\1\3\11\1\0\1\1"+
    "\1\11\13\1\1\11\1\0\22\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[142];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  public _LeekScriptLexer() {
    this((java.io.Reader)null);
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public _LeekScriptLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return BAD_CHARACTER;
            } 
            // fall through
          case 72: break;
          case 2: 
            { return WHITE_SPACE;
            } 
            // fall through
          case 73: break;
          case 3: 
            { return IDENTIFIER;
            } 
            // fall through
          case 74: break;
          case 4: 
            { return NUMBER;
            } 
            // fall through
          case 75: break;
          case 5: 
            { return OP_DIVIDE;
            } 
            // fall through
          case 76: break;
          case 6: 
            { return OP_TIMES;
            } 
            // fall through
          case 77: break;
          case 7: 
            { return OP_PLUS;
            } 
            // fall through
          case 78: break;
          case 8: 
            { return OP_MINUS;
            } 
            // fall through
          case 79: break;
          case 9: 
            { return OP_MODULO;
            } 
            // fall through
          case 80: break;
          case 10: 
            { return OP_SEMICOLON;
            } 
            // fall through
          case 81: break;
          case 11: 
            { return OP_COLON;
            } 
            // fall through
          case 82: break;
          case 12: 
            { return OP_LPAREN;
            } 
            // fall through
          case 83: break;
          case 13: 
            { return OP_RPAREN;
            } 
            // fall through
          case 84: break;
          case 14: 
            { return OP_LBRACKET;
            } 
            // fall through
          case 85: break;
          case 15: 
            { return OP_RBRACKET;
            } 
            // fall through
          case 86: break;
          case 16: 
            { return OP_LBRACE;
            } 
            // fall through
          case 87: break;
          case 17: 
            { return OP_RBRACE;
            } 
            // fall through
          case 88: break;
          case 18: 
            { return OP_COMMA;
            } 
            // fall through
          case 89: break;
          case 19: 
            { return OP_ASSIGN;
            } 
            // fall through
          case 90: break;
          case 20: 
            { return OP_BINARY_AND;
            } 
            // fall through
          case 91: break;
          case 21: 
            { return OP_BINARY_OR;
            } 
            // fall through
          case 92: break;
          case 22: 
            { return OP_XOR;
            } 
            // fall through
          case 93: break;
          case 23: 
            { return OP_EXCLAMATION_MARK;
            } 
            // fall through
          case 94: break;
          case 24: 
            { return OP_GT;
            } 
            // fall through
          case 95: break;
          case 25: 
            { return OP_LT;
            } 
            // fall through
          case 96: break;
          case 26: 
            { return OP_REFERENCE;
            } 
            // fall through
          case 97: break;
          case 27: 
            { return OP_TERNARY;
            } 
            // fall through
          case 98: break;
          case 28: 
            { return STRING;
            } 
            // fall through
          case 99: break;
          case 29: 
            { return COMMENT;
            } 
            // fall through
          case 100: break;
          case 30: 
            { return C_STYLE_COMMENT;
            } 
            // fall through
          case 101: break;
          case 31: 
            { return OP_DIVIDE_EQ;
            } 
            // fall through
          case 102: break;
          case 32: 
            { return OP_POW;
            } 
            // fall through
          case 103: break;
          case 33: 
            { return OP_TIMES_EQ;
            } 
            // fall through
          case 104: break;
          case 34: 
            { return KW_IF;
            } 
            // fall through
          case 105: break;
          case 35: 
            { return KW_IN;
            } 
            // fall through
          case 106: break;
          case 36: 
            { return OP_OR;
            } 
            // fall through
          case 107: break;
          case 37: 
            { return KW_DO;
            } 
            // fall through
          case 108: break;
          case 38: 
            { return OP_INC;
            } 
            // fall through
          case 109: break;
          case 39: 
            { return OP_PLUS_EQ;
            } 
            // fall through
          case 110: break;
          case 40: 
            { return OP_DEC;
            } 
            // fall through
          case 111: break;
          case 41: 
            { return OP_MINUS_EQ;
            } 
            // fall through
          case 112: break;
          case 42: 
            { return OP_EQUALS;
            } 
            // fall through
          case 113: break;
          case 43: 
            { return OP_AND_EQ;
            } 
            // fall through
          case 114: break;
          case 44: 
            { return OP_LOGICAL_AND;
            } 
            // fall through
          case 115: break;
          case 45: 
            { return OP_OR_EQ;
            } 
            // fall through
          case 116: break;
          case 46: 
            { return OP_LOGICAL_OR;
            } 
            // fall through
          case 117: break;
          case 47: 
            { return OP_XOR_EQ;
            } 
            // fall through
          case 118: break;
          case 48: 
            { return OP_NOT_EQUALS;
            } 
            // fall through
          case 119: break;
          case 49: 
            { return OP_GE;
            } 
            // fall through
          case 120: break;
          case 50: 
            { return OP_RSHIFT;
            } 
            // fall through
          case 121: break;
          case 51: 
            { return OP_LE;
            } 
            // fall through
          case 122: break;
          case 52: 
            { return OP_LSHIFT;
            } 
            // fall through
          case 123: break;
          case 53: 
            { return DOC_COMMENT;
            } 
            // fall through
          case 124: break;
          case 54: 
            { return KW_FOR;
            } 
            // fall through
          case 125: break;
          case 55: 
            { return OP_NOT;
            } 
            // fall through
          case 126: break;
          case 56: 
            { return KW_VAR;
            } 
            // fall through
          case 127: break;
          case 57: 
            { return OP_AND;
            } 
            // fall through
          case 128: break;
          case 58: 
            { return OP_IDENTITY_EQUALS;
            } 
            // fall through
          case 129: break;
          case 59: 
            { return OP_IDENTITY_NOT_EQUALS;
            } 
            // fall through
          case 130: break;
          case 60: 
            { return OP_UNSIGNED_RSHIFT;
            } 
            // fall through
          case 131: break;
          case 61: 
            { return KW_NULL;
            } 
            // fall through
          case 132: break;
          case 62: 
            { return KW_TRUE;
            } 
            // fall through
          case 133: break;
          case 63: 
            { return KW_ELSE;
            } 
            // fall through
          case 134: break;
          case 64: 
            { return KW_FALSE;
            } 
            // fall through
          case 135: break;
          case 65: 
            { return KW_BREAK;
            } 
            // fall through
          case 136: break;
          case 66: 
            { return KW_WHILE;
            } 
            // fall through
          case 137: break;
          case 67: 
            { return KW_RETURN;
            } 
            // fall through
          case 138: break;
          case 68: 
            { return KW_GLOBAL;
            } 
            // fall through
          case 139: break;
          case 69: 
            { return KW_INCLUDE;
            } 
            // fall through
          case 140: break;
          case 70: 
            { return KW_FUNCTION;
            } 
            // fall through
          case 141: break;
          case 71: 
            { return KW_CONTINUE;
            } 
            // fall through
          case 142: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
