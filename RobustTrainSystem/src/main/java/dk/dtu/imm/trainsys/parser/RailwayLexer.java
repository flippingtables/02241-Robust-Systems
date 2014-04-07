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
		T__3=1, T__2=2, T__1=3, T__0=4, STRING=5, ID=6, NEWLINE=7, WS=8, COMMENT=9;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'STAT'", "'CONN'", "'#'", "'END'", "STRING", "ID", "NEWLINE", "WS", "COMMENT"
	};
	public static final String[] ruleNames = {
		"T__3", "T__2", "T__1", "T__0", "STRING", "ID", "NEWLINE", "WS", "COMMENT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\13G\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\6\6("+
		"\n\6\r\6\16\6)\3\7\6\7-\n\7\r\7\16\7.\3\b\5\b\62\n\b\3\b\3\b\3\b\3\b\3"+
		"\t\6\t9\n\t\r\t\16\t:\3\t\3\t\3\n\3\n\7\nA\n\n\f\n\16\nD\13\n\3\n\3\n"+
		"\2\2\13\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\3\2\7\4\2C\\c|\5\2\62"+
		";C\\c|\4\2\62;c|\4\2\13\13\"\"\4\2\f\f\17\17K\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\3\25\3\2\2\2\5\32\3\2\2\2\7\37\3\2\2\2\t!\3\2\2\2"+
		"\13%\3\2\2\2\r,\3\2\2\2\17\61\3\2\2\2\218\3\2\2\2\23>\3\2\2\2\25\26\7"+
		"U\2\2\26\27\7V\2\2\27\30\7C\2\2\30\31\7V\2\2\31\4\3\2\2\2\32\33\7E\2\2"+
		"\33\34\7Q\2\2\34\35\7P\2\2\35\36\7P\2\2\36\6\3\2\2\2\37 \7%\2\2 \b\3\2"+
		"\2\2!\"\7G\2\2\"#\7P\2\2#$\7F\2\2$\n\3\2\2\2%\'\t\2\2\2&(\t\3\2\2\'&\3"+
		"\2\2\2()\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*\f\3\2\2\2+-\t\4\2\2,+\3\2\2\2-"+
		".\3\2\2\2.,\3\2\2\2./\3\2\2\2/\16\3\2\2\2\60\62\7\17\2\2\61\60\3\2\2\2"+
		"\61\62\3\2\2\2\62\63\3\2\2\2\63\64\7\f\2\2\64\65\3\2\2\2\65\66\b\b\2\2"+
		"\66\20\3\2\2\2\679\t\5\2\28\67\3\2\2\29:\3\2\2\2:8\3\2\2\2:;\3\2\2\2;"+
		"<\3\2\2\2<=\b\t\2\2=\22\3\2\2\2>B\7%\2\2?A\n\6\2\2@?\3\2\2\2AD\3\2\2\2"+
		"B@\3\2\2\2BC\3\2\2\2CE\3\2\2\2DB\3\2\2\2EF\b\n\2\2F\24\3\2\2\2\b\2).\61"+
		":B\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}