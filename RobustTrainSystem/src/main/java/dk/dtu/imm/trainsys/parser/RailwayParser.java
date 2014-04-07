// Generated from Railway.g4 by ANTLR 4.2

package dk.dtu.imm.trainsys.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RailwayParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__3=1, T__2=2, T__1=3, T__0=4, STRING=5, ID=6, NEWLINE=7, WS=8, COMMENT=9;
	public static final String[] tokenNames = {
		"<INVALID>", "'STAT'", "'CONN'", "'#'", "'END'", "STRING", "ID", "NEWLINE", 
		"WS", "COMMENT"
	};
	public static final int
		RULE_parse = 0, RULE_railsys = 1, RULE_comments = 2, RULE_station = 3, 
		RULE_connect = 4, RULE_end = 5;
	public static final String[] ruleNames = {
		"parse", "railsys", "comments", "station", "connect", "end"
	};

	@Override
	public String getGrammarFileName() { return "Railway.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RailwayParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ParseContext extends ParserRuleContext {
		public RailsysContext railsys() {
			return getRuleContext(RailsysContext.class,0);
		}
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RailwayListener ) ((RailwayListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RailwayListener ) ((RailwayListener)listener).exitParse(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12); railsys(0);
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

	public static class RailsysContext extends ParserRuleContext {
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
			if ( listener instanceof RailwayListener ) ((RailwayListener)listener).enterRailsys(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RailwayListener ) ((RailwayListener)listener).exitRailsys(this);
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
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_railsys, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			switch (_input.LA(1)) {
			case 1:
				{
				setState(15); station();
				}
				break;
			case 2:
				{
				setState(16); connect();
				}
				break;
			case 4:
				{
				setState(17); end();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(24);
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
					setState(20);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(21); railsys(0);
					}
					} 
				}
				setState(26);
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

	public static class CommentsContext extends ParserRuleContext {
		public TerminalNode STRING(int i) {
			return getToken(RailwayParser.STRING, i);
		}
		public List<TerminalNode> STRING() { return getTokens(RailwayParser.STRING); }
		public CommentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RailwayListener ) ((RailwayListener)listener).enterComments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RailwayListener ) ((RailwayListener)listener).exitComments(this);
		}
	}

	public final CommentsContext comments() throws RecognitionException {
		CommentsContext _localctx = new CommentsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_comments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27); match(3);
			setState(29); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(28); match(STRING);
				}
				}
				setState(31); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==STRING );
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

	public static class StationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(RailwayParser.ID, 0); }
		public TerminalNode STRING() { return getToken(RailwayParser.STRING, 0); }
		public StationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_station; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RailwayListener ) ((RailwayListener)listener).enterStation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RailwayListener ) ((RailwayListener)listener).exitStation(this);
		}
	}

	public final StationContext station() throws RecognitionException {
		StationContext _localctx = new StationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_station);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33); match(1);
			setState(34); match(STRING);
			setState(35); match(ID);
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
		public List<TerminalNode> ID() { return getTokens(RailwayParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(RailwayParser.ID, i);
		}
		public ConnectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_connect; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RailwayListener ) ((RailwayListener)listener).enterConnect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RailwayListener ) ((RailwayListener)listener).exitConnect(this);
		}
	}

	public final ConnectContext connect() throws RecognitionException {
		ConnectContext _localctx = new ConnectContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_connect);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37); match(2);
			setState(38); match(ID);
			setState(39); match(ID);
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
		public TerminalNode ID() { return getToken(RailwayParser.ID, 0); }
		public EndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_end; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RailwayListener ) ((RailwayListener)listener).enterEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RailwayListener ) ((RailwayListener)listener).exitEnd(this);
		}
	}

	public final EndContext end() throws RecognitionException {
		EndContext _localctx = new EndContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_end);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41); match(4);
			setState(42); match(ID);
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
		case 1: return railsys_sempred((RailsysContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean railsys_sempred(RailsysContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\13/\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\3\3\3\3\3\3\3\5\3\25\n\3"+
		"\3\3\3\3\7\3\31\n\3\f\3\16\3\34\13\3\3\4\3\4\6\4 \n\4\r\4\16\4!\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\2\3\4\b\2\4\6\b\n\f\2\2,\2"+
		"\16\3\2\2\2\4\24\3\2\2\2\6\35\3\2\2\2\b#\3\2\2\2\n\'\3\2\2\2\f+\3\2\2"+
		"\2\16\17\5\4\3\2\17\3\3\2\2\2\20\21\b\3\1\2\21\25\5\b\5\2\22\25\5\n\6"+
		"\2\23\25\5\f\7\2\24\20\3\2\2\2\24\22\3\2\2\2\24\23\3\2\2\2\25\32\3\2\2"+
		"\2\26\27\f\3\2\2\27\31\5\4\3\2\30\26\3\2\2\2\31\34\3\2\2\2\32\30\3\2\2"+
		"\2\32\33\3\2\2\2\33\5\3\2\2\2\34\32\3\2\2\2\35\37\7\5\2\2\36 \7\7\2\2"+
		"\37\36\3\2\2\2 !\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"\7\3\2\2\2#$\7\3\2\2"+
		"$%\7\7\2\2%&\7\b\2\2&\t\3\2\2\2\'(\7\4\2\2()\7\b\2\2)*\7\b\2\2*\13\3\2"+
		"\2\2+,\7\6\2\2,-\7\b\2\2-\r\3\2\2\2\5\24\32!";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}