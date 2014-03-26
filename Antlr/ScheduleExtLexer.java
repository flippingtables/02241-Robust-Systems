// Generated from ScheduleExt.g4 by ANTLR 4.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ScheduleExtLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, ID=2, WS=3, TIME=4;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'STOP'", "ID", "WS", "TIME"
	};
	public static final String[] ruleNames = {
		"T__0", "ID", "WS", "TIME"
	};


	public ScheduleExtLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ScheduleExt.g4"; }

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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\6#\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\2\3\2\3\3\6\3\22\n\3\r\3\16\3\23"+
		"\3\4\6\4\27\n\4\r\4\16\4\30\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\2\2\6"+
		"\3\3\5\4\7\5\t\6\3\2\b\4\2\62;c|\5\2\13\f\17\17\"\"\3\2\62\64\3\2\62;"+
		"\4\2<<^^\3\2\628$\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\3\13"+
		"\3\2\2\2\5\21\3\2\2\2\7\26\3\2\2\2\t\34\3\2\2\2\13\f\7U\2\2\f\r\7V\2\2"+
		"\r\16\7Q\2\2\16\17\7R\2\2\17\4\3\2\2\2\20\22\t\2\2\2\21\20\3\2\2\2\22"+
		"\23\3\2\2\2\23\21\3\2\2\2\23\24\3\2\2\2\24\6\3\2\2\2\25\27\t\3\2\2\26"+
		"\25\3\2\2\2\27\30\3\2\2\2\30\26\3\2\2\2\30\31\3\2\2\2\31\32\3\2\2\2\32"+
		"\33\b\4\2\2\33\b\3\2\2\2\34\35\t\4\2\2\35\36\t\5\2\2\36\37\3\2\2\2\37"+
		" \t\6\2\2 !\t\7\2\2!\"\t\7\2\2\"\n\3\2\2\2\5\2\23\30\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}