// Generated from Route.g4 by ANTLR 4.2

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
public class RouteLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, ID=2, TRAINID=3, NEWLINE=4, WS=5, COMMENT=6;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'STOP'", "ID", "TRAINID", "NEWLINE", "WS", "COMMENT"
	};
	public static final String[] ruleNames = {
		"T__0", "ID", "TRAINID", "NEWLINE", "WS", "COMMENT"
	};


	public RouteLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Route.g4"; }

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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\b\67\b\1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\2\3\2\3\3\6\3\26"+
		"\n\3\r\3\16\3\27\3\4\3\4\7\4\34\n\4\f\4\16\4\37\13\4\3\5\5\5\"\n\5\3\5"+
		"\3\5\3\5\3\5\3\6\6\6)\n\6\r\6\16\6*\3\6\3\6\3\7\3\7\7\7\61\n\7\f\7\16"+
		"\7\64\13\7\3\7\3\7\2\2\b\3\3\5\4\7\5\t\6\13\7\r\b\3\2\7\6\2\62;c|\u00e7"+
		"\u00e8\u00fa\u00fa\b\2C\\c|\u00c7\u00c8\u00da\u00da\u00e7\u00e8\u00fa"+
		"\u00fa\t\2\62;C\\c|\u00c7\u00c8\u00da\u00da\u00e7\u00e8\u00fa\u00fa\4"+
		"\2\13\13\"\"\4\2\f\f\17\17;\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\3\17\3\2\2\2\5\25\3\2\2\2\7\31\3\2\2\2"+
		"\t!\3\2\2\2\13(\3\2\2\2\r.\3\2\2\2\17\20\7U\2\2\20\21\7V\2\2\21\22\7Q"+
		"\2\2\22\23\7R\2\2\23\4\3\2\2\2\24\26\t\2\2\2\25\24\3\2\2\2\26\27\3\2\2"+
		"\2\27\25\3\2\2\2\27\30\3\2\2\2\30\6\3\2\2\2\31\35\t\3\2\2\32\34\t\4\2"+
		"\2\33\32\3\2\2\2\34\37\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36\b\3\2\2"+
		"\2\37\35\3\2\2\2 \"\7\17\2\2! \3\2\2\2!\"\3\2\2\2\"#\3\2\2\2#$\7\f\2\2"+
		"$%\3\2\2\2%&\b\5\2\2&\n\3\2\2\2\')\t\5\2\2(\'\3\2\2\2)*\3\2\2\2*(\3\2"+
		"\2\2*+\3\2\2\2+,\3\2\2\2,-\b\6\2\2-\f\3\2\2\2.\62\7%\2\2/\61\n\6\2\2\60"+
		"/\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\65\3\2\2\2\64\62"+
		"\3\2\2\2\65\66\b\7\2\2\66\16\3\2\2\2\b\2\27\35!*\62\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}