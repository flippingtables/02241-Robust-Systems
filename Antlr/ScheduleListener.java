// Generated from Schedule.g4 by ANTLR 4.2
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ScheduleParser}.
 */
public interface ScheduleListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ScheduleParser#dest}.
	 * @param ctx the parse tree
	 */
	void enterDest(@NotNull ScheduleParser.DestContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheduleParser#dest}.
	 * @param ctx the parse tree
	 */
	void exitDest(@NotNull ScheduleParser.DestContext ctx);

	/**
	 * Enter a parse tree produced by {@link ScheduleParser#trainSchedule}.
	 * @param ctx the parse tree
	 */
	void enterTrainSchedule(@NotNull ScheduleParser.TrainScheduleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScheduleParser#trainSchedule}.
	 * @param ctx the parse tree
	 */
	void exitTrainSchedule(@NotNull ScheduleParser.TrainScheduleContext ctx);

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