// Generated from Schedule.g4 by ANTLR 4.2

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
public class ScheduleLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, TIME=2, ID=3, TRAINID=4, NEWLINE=5, WS=6, COMMENT=7;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'STOP'", "TIME", "ID", "TRAINID", "NEWLINE", "WS", "COMMENT"
	};
	public static final String[] ruleNames = {
		"T__0", "TIME", "ID", "TRAINID", "NEWLINE", "WS", "COMMENT"
	};


	public ScheduleLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Schedule.g4"; }

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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\t?\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\4\6\4\36\n\4\r\4\16\4\37\3\5\3\5\7\5$\n\5\f\5\16"+
		"\5\'\13\5\3\6\5\6*\n\6\3\6\3\6\3\6\3\6\3\7\6\7\61\n\7\r\7\16\7\62\3\7"+
		"\3\7\3\b\3\b\7\b9\n\b\f\b\16\b<\13\b\3\b\3\b\2\2\t\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\3\2\t\3\2\62\64\3\2\62;\6\2\62;c|\u00e7\u00e8\u00fa\u00fa"+
		"\b\2C\\c|\u00c7\u00c8\u00da\u00da\u00e7\u00e8\u00fa\u00fa\t\2\62;C\\c"+
		"|\u00c7\u00c8\u00da\u00da\u00e7\u00e8\u00fa\u00fa\4\2\13\13\"\"\4\2\f"+
		"\f\17\17C\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\3\21\3\2\2\2\5\26\3\2\2\2\7\35\3\2\2\2\t!\3"+
		"\2\2\2\13)\3\2\2\2\r\60\3\2\2\2\17\66\3\2\2\2\21\22\7U\2\2\22\23\7V\2"+
		"\2\23\24\7Q\2\2\24\25\7R\2\2\25\4\3\2\2\2\26\27\t\2\2\2\27\30\t\3\2\2"+
		"\30\31\7<\2\2\31\32\t\3\2\2\32\33\t\3\2\2\33\6\3\2\2\2\34\36\t\4\2\2\35"+
		"\34\3\2\2\2\36\37\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 \b\3\2\2\2!%\t\5\2"+
		"\2\"$\t\6\2\2#\"\3\2\2\2$\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2&\n\3\2\2\2\'%"+
		"\3\2\2\2(*\7\17\2\2)(\3\2\2\2)*\3\2\2\2*+\3\2\2\2+,\7\f\2\2,-\3\2\2\2"+
		"-.\b\6\2\2.\f\3\2\2\2/\61\t\7\2\2\60/\3\2\2\2\61\62\3\2\2\2\62\60\3\2"+
		"\2\2\62\63\3\2\2\2\63\64\3\2\2\2\64\65\b\7\2\2\65\16\3\2\2\2\66:\7%\2"+
		"\2\679\n\b\2\28\67\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;=\3\2\2\2<:\3"+
		"\2\2\2=>\b\b\2\2>\20\3\2\2\2\b\2\37%)\62:\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}