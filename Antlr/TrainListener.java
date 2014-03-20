// Generated from Train.g4 by ANTLR 4.2
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TrainParser}.
 */
public interface TrainListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TrainParser#railsys}.
	 * @param ctx the parse tree
	 */
	void enterRailsys(@NotNull TrainParser.RailsysContext ctx);
	/**
	 * Exit a parse tree produced by {@link TrainParser#railsys}.
	 * @param ctx the parse tree
	 */
	void exitRailsys(@NotNull TrainParser.RailsysContext ctx);

	/**
	 * Enter a parse tree produced by {@link TrainParser#connect}.
	 * @param ctx the parse tree
	 */
	void enterConnect(@NotNull TrainParser.ConnectContext ctx);
	/**
	 * Exit a parse tree produced by {@link TrainParser#connect}.
	 * @param ctx the parse tree
	 */
	void exitConnect(@NotNull TrainParser.ConnectContext ctx);

	/**
	 * Enter a parse tree produced by {@link TrainParser#station}.
	 * @param ctx the parse tree
	 */
	void enterStation(@NotNull TrainParser.StationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TrainParser#station}.
	 * @param ctx the parse tree
	 */
	void exitStation(@NotNull TrainParser.StationContext ctx);

	/**
	 * Enter a parse tree produced by {@link TrainParser#comments}.
	 * @param ctx the parse tree
	 */
	void enterComments(@NotNull TrainParser.CommentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TrainParser#comments}.
	 * @param ctx the parse tree
	 */
	void exitComments(@NotNull TrainParser.CommentsContext ctx);

	/**
	 * Enter a parse tree produced by {@link TrainParser#end}.
	 * @param ctx the parse tree
	 */
	void enterEnd(@NotNull TrainParser.EndContext ctx);
	/**
	 * Exit a parse tree produced by {@link TrainParser#end}.
	 * @param ctx the parse tree
	 */
	void exitEnd(@NotNull TrainParser.EndContext ctx);
}