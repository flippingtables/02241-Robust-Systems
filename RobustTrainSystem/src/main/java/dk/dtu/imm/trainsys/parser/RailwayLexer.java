// Generated from Railway.g4 by ANTLR 4.2

package dk.dtu.imm.trainsys.parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RailwayLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__2=1, T__1=2, T__0=3, ID=4, STRING=5, NEWLINE=6, WS=7, COMMENT=8;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'STAT'", "'CONN'", "'END'", "ID", "STRING", "NEWLINE", "WS", "COMMENT"
	};
	public static final String[] ruleNames = {
		"T__2", "T__1", "T__0", "ID", "STRING", "NEWLINE", "WS", "COMMENT"
	};


	public RailwayLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Railway.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\nD\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\6\5#\n\5\r\5\16\5$\3\6\3"+
		"\6\7\6)\n\6\f\6\16\6,\13\6\3\7\5\7/\n\7\3\7\3\7\3\7\3\7\3\b\6\b\66\n\b"+
		"\r\b\16\b\67\3\b\3\b\3\t\3\t\7\t>\n\t\f\t\16\tA\13\t\3\t\3\t\2\2\n\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\3\2\7\6\2\62;c|\u00e7\u00e8\u00fa\u00fa"+
		"\b\2C\\c|\u00c7\u00c8\u00da\u00da\u00e7\u00e8\u00fa\u00fa\t\2\62;C\\c"+
		"|\u00c7\u00c8\u00da\u00da\u00e7\u00e8\u00fa\u00fa\4\2\13\13\"\"\4\2\f"+
		"\f\17\17H\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\3\23\3\2\2\2\5\30\3\2\2\2\7\35"+
		"\3\2\2\2\t\"\3\2\2\2\13&\3\2\2\2\r.\3\2\2\2\17\65\3\2\2\2\21;\3\2\2\2"+
		"\23\24\7U\2\2\24\25\7V\2\2\25\26\7C\2\2\26\27\7V\2\2\27\4\3\2\2\2\30\31"+
		"\7E\2\2\31\32\7Q\2\2\32\33\7P\2\2\33\34\7P\2\2\34\6\3\2\2\2\35\36\7G\2"+
		"\2\36\37\7P\2\2\37 \7F\2\2 \b\3\2\2\2!#\t\2\2\2\"!\3\2\2\2#$\3\2\2\2$"+
		"\"\3\2\2\2$%\3\2\2\2%\n\3\2\2\2&*\t\3\2\2\')\t\4\2\2(\'\3\2\2\2),\3\2"+
		"\2\2*(\3\2\2\2*+\3\2\2\2+\f\3\2\2\2,*\3\2\2\2-/\7\17\2\2.-\3\2\2\2./\3"+
		"\2\2\2/\60\3\2\2\2\60\61\7\f\2\2\61\62\3\2\2\2\62\63\b\7\2\2\63\16\3\2"+
		"\2\2\64\66\t\5\2\2\65\64\3\2\2\2\66\67\3\2\2\2\67\65\3\2\2\2\678\3\2\2"+
		"\289\3\2\2\29:\b\b\2\2:\20\3\2\2\2;?\7%\2\2<>\n\6\2\2=<\3\2\2\2>A\3\2"+
		"\2\2?=\3\2\2\2?@\3\2\2\2@B\3\2\2\2A?\3\2\2\2BC\b\t\2\2C\22\3\2\2\2\b\2"+
		"$*.\67?\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}