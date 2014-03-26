// Generated from ScheduleExt.g4 by ANTLR 4.2
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ScheduleExtParser}.
 */
public interface ScheduleExtListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ScheduleExtParser#route_no_stop}.
	 * @param ctx the parse tree
	 */
	void enterRoute_no_stop(@NotNull ScheduleExtParser.Route_no_stopContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheduleExtParser#route_no_stop}.
	 * @param ctx the parse tree
	 */
	void exitRoute_no_stop(@NotNull ScheduleExtParser.Route_no_stopContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScheduleExtParser#route}.
	 * @param ctx the parse tree
	 */
	void enterRoute(@NotNull ScheduleExtParser.RouteContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheduleExtParser#route}.
	 * @param ctx the parse tree
	 */
	void exitRoute(@NotNull ScheduleExtParser.RouteContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScheduleExtParser#route_stop}.
	 * @param ctx the parse tree
	 */
	void enterRoute_stop(@NotNull ScheduleExtParser.Route_stopContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheduleExtParser#route_stop}.
	 * @param ctx the parse tree
	 */
	void exitRoute_stop(@NotNull ScheduleExtParser.Route_stopContext ctx);
}