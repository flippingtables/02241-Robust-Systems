// Generated from Railway.g4 by ANTLR 4.2

package dk.dtu.imm.trainsys.parser;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RailwayParser}.
 */
public interface RailwayListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RailwayParser#railsys}.
	 * @param ctx the parse tree
	 */
	void enterRailsys(@NotNull RailwayParser.RailsysContext ctx);
	/**
	 * Exit a parse tree produced by {@link RailwayParser#railsys}.
	 * @param ctx the parse tree
	 */
	void exitRailsys(@NotNull RailwayParser.RailsysContext ctx);

	/**
	 * Enter a parse tree produced by {@link RailwayParser#connect}.
	 * @param ctx the parse tree
	 */
	void enterConnect(@NotNull RailwayParser.ConnectContext ctx);
	/**
	 * Exit a parse tree produced by {@link RailwayParser#connect}.
	 * @param ctx the parse tree
	 */
	void exitConnect(@NotNull RailwayParser.ConnectContext ctx);

	/**
	 * Enter a parse tree produced by {@link RailwayParser#station}.
	 * @param ctx the parse tree
	 */
	void enterStation(@NotNull RailwayParser.StationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RailwayParser#station}.
	 * @param ctx the parse tree
	 */
	void exitStation(@NotNull RailwayParser.StationContext ctx);

	/**
	 * Enter a parse tree produced by {@link RailwayParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(@NotNull RailwayParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link RailwayParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(@NotNull RailwayParser.ParseContext ctx);

	/**
	 * Enter a parse tree produced by {@link RailwayParser#end}.
	 * @param ctx the parse tree
	 */
	void enterEnd(@NotNull RailwayParser.EndContext ctx);
	/**
	 * Exit a parse tree produced by {@link RailwayParser#end}.
	 * @param ctx the parse tree
	 */
	void exitEnd(@NotNull RailwayParser.EndContext ctx);
}