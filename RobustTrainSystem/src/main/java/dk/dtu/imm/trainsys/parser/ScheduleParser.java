// Generated from Schedule.g4 by ANTLR 4.2

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
public class ScheduleParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, TIME=2, ID=3, TRAINID=4, NEWLINE=5, WS=6, COMMENT=7;
	public static final String[] tokenNames = {
		"<INVALID>", "'STOP'", "TIME", "ID", "TRAINID", "NEWLINE", "WS", "COMMENT"
	};
	public static final int
		RULE_parse = 0, RULE_trains = 1, RULE_train = 2, RULE_fullroute = 3, RULE_partialroute = 4, 
		RULE_schedule = 5;
	public static final String[] ruleNames = {
		"parse", "trains", "train", "fullroute", "partialroute", "schedule"
	};

	@Override
	public String getGrammarFileName() { return "Schedule.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ScheduleParser(TokenStream input) {
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
			if ( listener instanceof ScheduleListener ) ((ScheduleListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScheduleListener ) ((ScheduleListener)listener).exitParse(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12); trains();
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
			if ( listener instanceof ScheduleListener ) ((ScheduleListener)listener).enterTrains(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScheduleListener ) ((ScheduleListener)listener).exitTrains(this);
		}
	}

	public final TrainsContext trains() throws RecognitionException {
		TrainsContext _localctx = new TrainsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_trains);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(14); train();
				}
				}
				setState(17); 
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
		public TerminalNode TRAINID() { return getToken(ScheduleParser.TRAINID, 0); }
		public TrainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_train; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScheduleListener ) ((ScheduleListener)listener).enterTrain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScheduleListener ) ((ScheduleListener)listener).exitTrain(this);
		}
	}

	public final TrainContext train() throws RecognitionException {
		TrainContext _localctx = new TrainContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_train);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19); match(TRAINID);
			setState(20); fullroute();
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
			if ( listener instanceof ScheduleListener ) ((ScheduleListener)listener).enterFullroute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScheduleListener ) ((ScheduleListener)listener).exitFullroute(this);
		}
	}

	public final FullrouteContext fullroute() throws RecognitionException {
		FullrouteContext _localctx = new FullrouteContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_fullroute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(22); partialroute();
				}
				}
				setState(25); 
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
		public List<ScheduleContext> schedule() {
			return getRuleContexts(ScheduleContext.class);
		}
		public ScheduleContext schedule(int i) {
			return getRuleContext(ScheduleContext.class,i);
		}
		public PartialrouteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partialroute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScheduleListener ) ((ScheduleListener)listener).enterPartialroute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScheduleListener ) ((ScheduleListener)listener).exitPartialroute(this);
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
			setState(28); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(27); schedule();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(30); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(33);
			_la = _input.LA(1);
			if (_la==1) {
				{
				setState(32); match(1);
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

	public static class ScheduleContext extends ParserRuleContext {
		public TerminalNode TIME() { return getToken(ScheduleParser.TIME, 0); }
		public TerminalNode ID() { return getToken(ScheduleParser.ID, 0); }
		public ScheduleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_schedule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScheduleListener ) ((ScheduleListener)listener).enterSchedule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScheduleListener ) ((ScheduleListener)listener).exitSchedule(this);
		}
	}

	public final ScheduleContext schedule() throws RecognitionException {
		ScheduleContext _localctx = new ScheduleContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_schedule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35); match(ID);
			setState(36); match(TIME);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\t)\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\3\6\3\22\n\3\r\3\16\3\23"+
		"\3\4\3\4\3\4\3\5\6\5\32\n\5\r\5\16\5\33\3\6\6\6\37\n\6\r\6\16\6 \3\6\5"+
		"\6$\n\6\3\7\3\7\3\7\3\7\2\2\b\2\4\6\b\n\f\2\2&\2\16\3\2\2\2\4\21\3\2\2"+
		"\2\6\25\3\2\2\2\b\31\3\2\2\2\n\36\3\2\2\2\f%\3\2\2\2\16\17\5\4\3\2\17"+
		"\3\3\2\2\2\20\22\5\6\4\2\21\20\3\2\2\2\22\23\3\2\2\2\23\21\3\2\2\2\23"+
		"\24\3\2\2\2\24\5\3\2\2\2\25\26\7\6\2\2\26\27\5\b\5\2\27\7\3\2\2\2\30\32"+
		"\5\n\6\2\31\30\3\2\2\2\32\33\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\t"+
		"\3\2\2\2\35\37\5\f\7\2\36\35\3\2\2\2\37 \3\2\2\2 \36\3\2\2\2 !\3\2\2\2"+
		"!#\3\2\2\2\"$\7\3\2\2#\"\3\2\2\2#$\3\2\2\2$\13\3\2\2\2%&\7\5\2\2&\'\7"+
		"\4\2\2\'\r\3\2\2\2\6\23\33 #";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}