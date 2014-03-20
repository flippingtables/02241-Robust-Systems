// Generated from Schedule.g4 by ANTLR 4.2
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ScheduleParser}.
 */
public interface ScheduleListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ScheduleParser#route_no_stop}.
	 * @param ctx the parse tree
	 */
	void enterRoute_no_stop(@NotNull ScheduleParser.Route_no_stopContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheduleParser#route_no_stop}.
	 * @param ctx the parse tree
	 */
	void exitRoute_no_stop(@NotNull ScheduleParser.Route_no_stopContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScheduleParser#route}.
	 * @param ctx the parse tree
	 */
	void enterRoute(@NotNull ScheduleParser.RouteContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheduleParser#route}.
	 * @param ctx the parse tree
	 */
	void exitRoute(@NotNull ScheduleParser.RouteContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScheduleParser#route_stop}.
	 * @param ctx the parse tree
	 */
	void enterRoute_stop(@NotNull ScheduleParser.Route_stopContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheduleParser#route_stop}.
	 * @param ctx the parse tree
	 */
	void exitRoute_stop(@NotNull ScheduleParser.Route_stopContext ctx);
}