package com.yl.learn.antlr;// Generated from Caculator.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CaculatorParser}.
 */
public interface CaculatorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CaculatorParser#calc}.
	 * @param ctx the parse tree
	 */
	void enterCalc(CaculatorParser.CalcContext ctx);
	/**
	 * Exit a parse tree produced by {@link CaculatorParser#calc}.
	 * @param ctx the parse tree
	 */
	void exitCalc(CaculatorParser.CalcContext ctx);
	/**
	 * Enter a parse tree produced by {@link CaculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(CaculatorParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CaculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(CaculatorParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CaculatorParser#digit}.
	 * @param ctx the parse tree
	 */
	void enterDigit(CaculatorParser.DigitContext ctx);
	/**
	 * Exit a parse tree produced by {@link CaculatorParser#digit}.
	 * @param ctx the parse tree
	 */
	void exitDigit(CaculatorParser.DigitContext ctx);
	/**
	 * Enter a parse tree produced by {@link CaculatorParser#decimal}.
	 * @param ctx the parse tree
	 */
	void enterDecimal(CaculatorParser.DecimalContext ctx);
	/**
	 * Exit a parse tree produced by {@link CaculatorParser#decimal}.
	 * @param ctx the parse tree
	 */
	void exitDecimal(CaculatorParser.DecimalContext ctx);
}