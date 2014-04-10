// Generated from Route.g4 by ANTLR 4.2

package dk.dtu.imm.trainsys.parser;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RouteParser}.
 */
public interface RouteListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RouteParser#train}.
	 * @param ctx the parse tree
	 */
	void enterTrain(@NotNull RouteParser.TrainContext ctx);
	/**
	 * Exit a parse tree produced by {@link RouteParser#train}.
	 * @param ctx the parse tree
	 */
	void exitTrain(@NotNull RouteParser.TrainContext ctx);

	/**
	 * Enter a parse tree produced by {@link RouteParser#partialroute}.
	 * @param ctx the parse tree
	 */
	void enterPartialroute(@NotNull RouteParser.PartialrouteContext ctx);
	/**
	 * Exit a parse tree produced by {@link RouteParser#partialroute}.
	 * @param ctx the parse tree
	 */
	void exitPartialroute(@NotNull RouteParser.PartialrouteContext ctx);

	/**
	 * Enter a parse tree produced by {@link RouteParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(@NotNull RouteParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link RouteParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(@NotNull RouteParser.ParseContext ctx);

	/**
	 * Enter a parse tree produced by {@link RouteParser#fullroute}.
	 * @param ctx the parse tree
	 */
	void enterFullroute(@NotNull RouteParser.FullrouteContext ctx);
	/**
	 * Exit a parse tree produced by {@link RouteParser#fullroute}.
	 * @param ctx the parse tree
	 */
	void exitFullroute(@NotNull RouteParser.FullrouteContext ctx);

	/**
	 * Enter a parse tree produced by {@link RouteParser#trains}.
	 * @param ctx the parse tree
	 */
	void enterTrains(@NotNull RouteParser.TrainsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RouteParser#trains}.
	 * @param ctx the parse tree
	 */
	void exitTrains(@NotNull RouteParser.TrainsContext ctx);
}