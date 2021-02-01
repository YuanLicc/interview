package com.yl.learn.antlr;

import junit.framework.TestCase;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

public class CalculatorTest extends TestCase {

    public void test() {
        String exp = "1 + 1 * 2 * (0.5 - 1) / 10;";
        
        CaculatorLexer lexer = new CaculatorLexer(CharStreams.fromString(exp));
        TokenStream tokenStream = new CommonTokenStream(lexer);
        CaculatorParser parser = new CaculatorParser(tokenStream);
        CaculatorParser.CalcContext calcContext = parser.calc();
        CaculatorParser.ExprContext exprContext = calcContext.expr();
        
        System.out.println(exprContext.children);
    }
}
