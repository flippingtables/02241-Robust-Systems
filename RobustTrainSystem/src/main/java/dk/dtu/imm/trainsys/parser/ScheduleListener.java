// Generated from Schedule.g4 by ANTLR 4.2

package dk.dtu.imm.trainsys.parser;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ScheduleParser}.
 */
public interface ScheduleListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ScheduleParser#schedule}.
	 * @param ctx the parse tree
	 */
	void enterSchedule(@NotNull ScheduleParser.ScheduleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheduleParser#schedule}.
	 * @param ctx the parse tree
	 */
	void exitSchedule(@NotNull ScheduleParser.ScheduleContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScheduleParser#train}.
	 * @param ctx the parse tree
	 */
	void enterTrain(@NotNull ScheduleParser.TrainContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheduleParser#train}.
	 * @param ctx the parse tree
	 */
	void exitTrain(@NotNull ScheduleParser.TrainContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScheduleParser#partialroute}.
	 * @param ctx the parse tree
	 */
	void enterPartialroute(@NotNull ScheduleParser.PartialrouteContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheduleParser#partialroute}.
	 * @param ctx the parse tree
	 */
	void exitPartialroute(@NotNull ScheduleParser.PartialrouteContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScheduleParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(@NotNull ScheduleParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheduleParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(@NotNull ScheduleParser.ParseContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScheduleParser#fullroute}.
	 * @param ctx the parse tree
	 */
	void enterFullroute(@NotNull ScheduleParser.FullrouteContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheduleParser#fullroute}.
	 * @param ctx the parse tree
	 */
	void exitFullroute(@NotNull ScheduleParser.FullrouteContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScheduleParser#trains}.
	 * @param ctx the parse tree
	 */
	void enterTrains(@NotNull ScheduleParser.TrainsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheduleParser#trains}.
	 * @param ctx the parse tree
	 */
	void exitTrains(@NotNull ScheduleParser.TrainsContext ctx);
}