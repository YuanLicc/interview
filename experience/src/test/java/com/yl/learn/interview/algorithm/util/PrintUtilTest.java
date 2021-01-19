package com.yl.learn.interview.algorithm.util;

import com.yl.learn.util.util.PrintUtil;
import com.yl.learn.util.util.StringUtil;
import com.yl.learn.util.util.Timer;
import junit.framework.TestCase;

public class PrintUtilTest extends TestCase {

    public void testPrintLine() {

        String prefix = "start";
        String suffix = "end";
        int column = 100, row = 2;

        Timer timer = Timer.start();

        PrintUtil.printlnLine(prefix, suffix);
        PrintUtil.println();

        PrintUtil.printlnLine(column, row);
        PrintUtil.println();

        PrintUtil.printlnLine(column, prefix, suffix);
        PrintUtil.println();

        PrintUtil.printlnLine();
        PrintUtil.println();

        PrintUtil.printlnLine(column);
        PrintUtil.println();

        PrintUtil.printlnLine(prefix, suffix);
        PrintUtil.println();

        PrintUtil.printlnLine(column, row);
        PrintUtil.println();

        PrintUtil.printlnLine(column, prefix, suffix);
        PrintUtil.println();

        PrintUtil.printlnLine();
        PrintUtil.println();

        PrintUtil.printlnLine(column);
        PrintUtil.println();

        PrintUtil.printlnLine(column, row, prefix, suffix);
        PrintUtil.println();

        PrintUtil.printlnLine(-1, -1, prefix, suffix);
        PrintUtil.println();

        PrintUtil.printlnLine(column, -1, prefix, suffix);
        PrintUtil.println();

        PrintUtil.printlnLine(-1, row, prefix, suffix);
        PrintUtil.println();

        PrintUtil.printlnLine(column, row, null, null);
        PrintUtil.println();

        PrintUtil.printlnLine(column);
        PrintUtil.println();

        PrintUtil.printlnLine(column, 2, prefix, suffix);
        PrintUtil.println();

        PrintUtil.println(prefix, prefix, suffix);
        PrintUtil.println();

        PrintUtil.println(null, prefix, suffix);
        PrintUtil.println();

        PrintUtil.printlnWithNaoTime(prefix, timer);
        PrintUtil.println();

        PrintUtil.printlnWithNaoTime(prefix, null);
        PrintUtil.println();

        PrintUtil.printlnWithNaoTime(prefix, prefix, timer);
        PrintUtil.println();

        PrintUtil.printlnWithNaoTime(prefix, timer, prefix, prefix, prefix);
        PrintUtil.println();

        PrintUtil.printlnWithNaoTime(prefix, timer);
        PrintUtil.println();

        PrintUtil.println(prefix, prefix, suffix);
        PrintUtil.println();

        PrintUtil.printlnWithNaoTime(prefix, suffix, timer);
        PrintUtil.println();

        PrintUtil.println(StringUtil.newString('a', -1), prefix, suffix);
        PrintUtil.println();

    }
}
