// Generated from Schedule.g4 by ANTLR 4.2
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
		T__0=1, ID=2, WS=3;
	public static final String[] tokenNames = {
		"<INVALID>", "'STOP'", "ID", "WS"
	};
	public static final int
		RULE_route = 0, RULE_route_no_stop = 1, RULE_route_stop = 2;
	public static final String[] ruleNames = {
		"route", "route_no_stop", "route_stop"
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
	public static class RouteContext extends ParserRuleContext {
		public TerminalNode WS() { return getToken(ScheduleParser.WS, 0); }
		public Route_stopContext route_stop() {
			return getRuleContext(Route_stopContext.class,0);
		}
		public TerminalNode ID() { return getToken(ScheduleParser.ID, 0); }
		public RouteContext route() {
			return getRuleContext(RouteContext.class,0);
		}
		public RouteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_route; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScheduleListener ) ((ScheduleListener)listener).enterRoute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScheduleListener ) ((ScheduleListener)listener).exitRoute(this);
		}
	}

	public final RouteContext route() throws RecognitionException {
		RouteContext _localctx = new RouteContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_route);
		try {
			setState(10);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(6); match(ID);
				setState(7); route();
				}
				break;
			case 1:
				enterOuterAlt(_localctx, 2);
				{
				setState(8); route_stop();
				}
				break;
			case WS:
				enterOuterAlt(_localctx, 3);
				{
				setState(9); match(WS);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Route_no_stopContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ScheduleParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ScheduleParser.ID, i);
		}
		public Route_no_stopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_route_no_stop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScheduleListener ) ((ScheduleListener)listener).enterRoute_no_stop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScheduleListener ) ((ScheduleListener)listener).exitRoute_no_stop(this);
		}
	}

	public final Route_no_stopContext route_no_stop() throws RecognitionException {
		Route_no_stopContext _localctx = new Route_no_stopContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_route_no_stop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12); match(ID);
			setState(13); match(ID);
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

	public static class Route_stopContext extends ParserRuleContext {
		public RouteContext route() {
			return getRuleContext(RouteContext.class,0);
		}
		public Route_stopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_route_stop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScheduleListener ) ((ScheduleListener)listener).enterRoute_stop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScheduleListener ) ((ScheduleListener)listener).exitRoute_stop(this);
		}
	}

	public final Route_stopContext route_stop() throws RecognitionException {
		Route_stopContext _localctx = new Route_stopContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_route_stop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15); match(1);
			setState(16); route();
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\5\25\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\3\2\3\2\3\2\3\2\5\2\r\n\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\2\2"+
		"\5\2\4\6\2\2\23\2\f\3\2\2\2\4\16\3\2\2\2\6\21\3\2\2\2\b\t\7\4\2\2\t\r"+
		"\5\2\2\2\n\r\5\6\4\2\13\r\7\5\2\2\f\b\3\2\2\2\f\n\3\2\2\2\f\13\3\2\2\2"+
		"\r\3\3\2\2\2\16\17\7\4\2\2\17\20\7\4\2\2\20\5\3\2\2\2\21\22\7\3\2\2\22"+
		"\23\5\2\2\2\23\7\3\2\2\2\3\f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}