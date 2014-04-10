// Generated from Route.g4 by ANTLR 4.2

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
public class RouteParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, ID=2, TRAINID=3, NEWLINE=4, WS=5, COMMENT=6;
	public static final String[] tokenNames = {
		"<INVALID>", "'STOP'", "ID", "TRAINID", "NEWLINE", "WS", "COMMENT"
	};
	public static final int
		RULE_parse = 0, RULE_trains = 1, RULE_train = 2, RULE_fullroute = 3, RULE_partialroute = 4;
	public static final String[] ruleNames = {
		"parse", "trains", "train", "fullroute", "partialroute"
	};

	@Override
	public String getGrammarFileName() { return "Route.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RouteParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ParseContext extends ParserRuleContext {
		public TrainsContext trains() {
			return getRuleContext(TrainsContext.class,0);
		}
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RouteListener ) ((RouteListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RouteListener ) ((RouteListener)listener).exitParse(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10); trains();
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

	public static class TrainsContext extends ParserRuleContext {
		public TrainContext train(int i) {
			return getRuleContext(TrainContext.class,i);
		}
		public List<TrainContext> train() {
			return getRuleContexts(TrainContext.class);
		}
		public TrainsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trains; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RouteListener ) ((RouteListener)listener).enterTrains(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RouteListener ) ((RouteListener)listener).exitTrains(this);
		}
	}

	public final TrainsContext trains() throws RecognitionException {
		TrainsContext _localctx = new TrainsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_trains);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(12); train();
				}
				}
				setState(15); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TRAINID );
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

	public static class TrainContext extends ParserRuleContext {
		public FullrouteContext fullroute() {
			return getRuleContext(FullrouteContext.class,0);
		}
		public TerminalNode TRAINID() { return getToken(RouteParser.TRAINID, 0); }
		public TrainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_train; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RouteListener ) ((RouteListener)listener).enterTrain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RouteListener ) ((RouteListener)listener).exitTrain(this);
		}
	}

	public final TrainContext train() throws RecognitionException {
		TrainContext _localctx = new TrainContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_train);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17); match(TRAINID);
			setState(18); fullroute();
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

	public static class FullrouteContext extends ParserRuleContext {
		public List<PartialrouteContext> partialroute() {
			return getRuleContexts(PartialrouteContext.class);
		}
		public PartialrouteContext partialroute(int i) {
			return getRuleContext(PartialrouteContext.class,i);
		}
		public FullrouteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fullroute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RouteListener ) ((RouteListener)listener).enterFullroute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RouteListener ) ((RouteListener)listener).exitFullroute(this);
		}
	}

	public final FullrouteContext fullroute() throws RecognitionException {
		FullrouteContext _localctx = new FullrouteContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_fullroute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(20); partialroute();
				}
				}
				setState(23); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
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

	public static class PartialrouteContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(RouteParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(RouteParser.ID, i);
		}
		public PartialrouteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partialroute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RouteListener ) ((RouteListener)listener).enterPartialroute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RouteListener ) ((RouteListener)listener).exitPartialroute(this);
		}
	}

	public final PartialrouteContext partialroute() throws RecognitionException {
		PartialrouteContext _localctx = new PartialrouteContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_partialroute);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(26); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(25); match(ID);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(28); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(31);
			_la = _input.LA(1);
			if (_la==1) {
				{
				setState(30); match(1);
				}
			}

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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\b$\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\3\6\3\20\n\3\r\3\16\3\21\3\4\3\4"+
		"\3\4\3\5\6\5\30\n\5\r\5\16\5\31\3\6\6\6\35\n\6\r\6\16\6\36\3\6\5\6\"\n"+
		"\6\3\6\2\2\7\2\4\6\b\n\2\2\"\2\f\3\2\2\2\4\17\3\2\2\2\6\23\3\2\2\2\b\27"+
		"\3\2\2\2\n\34\3\2\2\2\f\r\5\4\3\2\r\3\3\2\2\2\16\20\5\6\4\2\17\16\3\2"+
		"\2\2\20\21\3\2\2\2\21\17\3\2\2\2\21\22\3\2\2\2\22\5\3\2\2\2\23\24\7\5"+
		"\2\2\24\25\5\b\5\2\25\7\3\2\2\2\26\30\5\n\6\2\27\26\3\2\2\2\30\31\3\2"+
		"\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32\t\3\2\2\2\33\35\7\4\2\2\34\33\3\2"+
		"\2\2\35\36\3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37!\3\2\2\2 \"\7\3\2\2"+
		"! \3\2\2\2!\"\3\2\2\2\"\13\3\2\2\2\6\21\31\36!";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}