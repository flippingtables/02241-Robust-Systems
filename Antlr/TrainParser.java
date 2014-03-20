// Generated from Train.g4 by ANTLR 4.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TrainParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__3=1, T__2=2, T__1=3, T__0=4, STRING=5, ID=6, WS=7;
	public static final String[] tokenNames = {
		"<INVALID>", "'STAT'", "'CONN'", "'END'", "'#'", "STRING", "ID", "WS"
	};
	public static final int
		RULE_railsys = 0, RULE_station = 1, RULE_connect = 2, RULE_end = 3, RULE_comments = 4;
	public static final String[] ruleNames = {
		"railsys", "station", "connect", "end", "comments"
	};

	@Override
	public String getGrammarFileName() { return "Train.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TrainParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RailsysContext extends ParserRuleContext {
		public TerminalNode WS() { return getToken(TrainParser.WS, 0); }
		public CommentsContext comments() {
			return getRuleContext(CommentsContext.class,0);
		}
		public List<RailsysContext> railsys() {
			return getRuleContexts(RailsysContext.class);
		}
		public StationContext station() {
			return getRuleContext(StationContext.class,0);
		}
		public RailsysContext railsys(int i) {
			return getRuleContext(RailsysContext.class,i);
		}
		public ConnectContext connect() {
			return getRuleContext(ConnectContext.class,0);
		}
		public EndContext end() {
			return getRuleContext(EndContext.class,0);
		}
		public RailsysContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_railsys; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TrainListener ) ((TrainListener)listener).enterRailsys(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TrainListener ) ((TrainListener)listener).exitRailsys(this);
		}
	}

	public final RailsysContext railsys() throws RecognitionException {
		return railsys(0);
	}

	private RailsysContext railsys(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RailsysContext _localctx = new RailsysContext(_ctx, _parentState);
		RailsysContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_railsys, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			switch (_input.LA(1)) {
			case 1:
				{
				setState(11); station();
				}
				break;
			case 2:
				{
				setState(12); connect();
				}
				break;
			case 3:
				{
				setState(13); end();
				}
				break;
			case 4:
				{
				setState(14); comments();
				}
				break;
			case WS:
				{
				setState(15); match(WS);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(22);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RailsysContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_railsys);
					setState(18);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(19); railsys(0);
					}
					} 
				}
				setState(24);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class StationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TrainParser.ID, 0); }
		public TerminalNode STRING() { return getToken(TrainParser.STRING, 0); }
		public StationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_station; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TrainListener ) ((TrainListener)listener).enterStation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TrainListener ) ((TrainListener)listener).exitStation(this);
		}
	}

	public final StationContext station() throws RecognitionException {
		StationContext _localctx = new StationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_station);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25); match(1);
			setState(26); match(STRING);
			setState(27); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConnectContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(TrainParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(TrainParser.ID, i);
		}
		public ConnectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_connect; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TrainListener ) ((TrainListener)listener).enterConnect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TrainListener ) ((TrainListener)listener).exitConnect(this);
		}
	}

	public final ConnectContext connect() throws RecognitionException {
		ConnectContext _localctx = new ConnectContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_connect);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29); match(2);
			setState(30); match(ID);
			setState(31); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EndContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TrainParser.ID, 0); }
		public EndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_end; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TrainListener ) ((TrainListener)listener).enterEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TrainListener ) ((TrainListener)listener).exitEnd(this);
		}
	}

	public final EndContext end() throws RecognitionException {
		EndContext _localctx = new EndContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_end);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33); match(3);
			setState(34); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommentsContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(TrainParser.STRING, 0); }
		public CommentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TrainListener ) ((TrainListener)listener).enterComments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TrainListener ) ((TrainListener)listener).exitComments(this);
		}
	}

	public final CommentsContext comments() throws RecognitionException {
		CommentsContext _localctx = new CommentsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_comments);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36); match(4);
			setState(37); match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0: return railsys_sempred((RailsysContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean railsys_sempred(RailsysContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\t*\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\3\2\3\2\5\2\23\n\2\3\2\3\2"+
		"\7\2\27\n\2\f\2\16\2\32\13\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\2\3\2\7\2\4\6\b\n\2\2)\2\22\3\2\2\2\4\33\3\2\2\2\6"+
		"\37\3\2\2\2\b#\3\2\2\2\n&\3\2\2\2\f\r\b\2\1\2\r\23\5\4\3\2\16\23\5\6\4"+
		"\2\17\23\5\b\5\2\20\23\5\n\6\2\21\23\7\t\2\2\22\f\3\2\2\2\22\16\3\2\2"+
		"\2\22\17\3\2\2\2\22\20\3\2\2\2\22\21\3\2\2\2\23\30\3\2\2\2\24\25\f\5\2"+
		"\2\25\27\5\2\2\2\26\24\3\2\2\2\27\32\3\2\2\2\30\26\3\2\2\2\30\31\3\2\2"+
		"\2\31\3\3\2\2\2\32\30\3\2\2\2\33\34\7\3\2\2\34\35\7\7\2\2\35\36\7\b\2"+
		"\2\36\5\3\2\2\2\37 \7\4\2\2 !\7\b\2\2!\"\7\b\2\2\"\7\3\2\2\2#$\7\5\2\2"+
		"$%\7\b\2\2%\t\3\2\2\2&\'\7\6\2\2\'(\7\7\2\2(\13\3\2\2\2\4\22\30";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}