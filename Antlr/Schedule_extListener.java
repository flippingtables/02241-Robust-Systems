// Generated from Schedule_ext.g4 by ANTLR 4.2
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Schedule_extParser}.
 */
public interface Schedule_extListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Schedule_extParser#route_no_stop}.
	 * @param ctx the parse tree
	 */
	void enterRoute_no_stop(@NotNull Schedule_extParser.Route_no_stopContext ctx);
	/**
	 * Exit a parse tree produced by {@link Schedule_extParser#route_no_stop}.
	 * @param ctx the parse tree
	 */
	void exitRoute_no_stop(@NotNull Schedule_extParser.Route_no_stopContext ctx);

	/**
	 * Enter a parse tree produced by {@link Schedule_extParser#route}.
	 * @param ctx the parse tree
	 */
	void enterRoute(@NotNull Schedule_extParser.RouteContext ctx);
	/**
	 * Exit a parse tree produced by {@link Schedule_extParser#route}.
	 * @param ctx the parse tree
	 */
	void exitRoute(@NotNull Schedule_extParser.RouteContext ctx);

	/**
	 * Enter a parse tree produced by {@link Schedule_extParser#route_stop}.
	 * @param ctx the parse tree
	 */
	void enterRoute_stop(@NotNull Schedule_extParser.Route_stopContext ctx);
	/**
	 * Exit a parse tree produced by {@link Schedule_extParser#route_stop}.
	 * @param ctx the parse tree
	 */
	void exitRoute_stop(@NotNull Schedule_extParser.Route_stopContext ctx);
}