package com.yl.learn.interview.algorithm.util;

import com.yl.learn.interview.util.PrintUtil;
import com.yl.learn.interview.util.StringUtil;
import com.yl.learn.interview.util.Timer;
import junit.framework.TestCase;

public class PrintUtilTest extends TestCase {

    public void testPrintLine() {
        String prefix = "start", suffix = "end";
        int column = 100, row = 2;

        Timer timer = Timer.start();

        PrintUtil.printLine(prefix, suffix);

        PrintUtil.printLine(column, row);

        PrintUtil.printLine(column, prefix, suffix);

        PrintUtil.printLine();

        PrintUtil.printLine(column);

        PrintUtil.printlnLine(prefix, suffix);

        PrintUtil.printlnLine(column, row);

        PrintUtil.printlnLine(column, prefix, suffix);

        PrintUtil.printlnLine();

        PrintUtil.printlnLine(column);


        PrintUtil.printLine(column, row, prefix, suffix);
        PrintUtil.printLine(-1, -1, prefix, suffix);
        PrintUtil.printLine(column, -1, prefix, suffix);
        PrintUtil.printLine(-1, row, prefix, suffix);
        PrintUtil.printLine(column, row, null, null);

        PrintUtil.printlnLine(column);
        PrintUtil.printlnLine(column, 2, prefix, suffix);

        PrintUtil.print(prefix, prefix, suffix);

        PrintUtil.print(null, prefix, suffix);

        PrintUtil.printWithNaoTime(prefix, timer);

        PrintUtil.printWithNaoTime(prefix, null);

        PrintUtil.printWithNaoTime(prefix, timer, prefix);

        PrintUtil.printWithNaoTime(prefix, timer, prefix, prefix, prefix);

        PrintUtil.printlnWithNaoTime(prefix, timer);

        PrintUtil.println(prefix, prefix, suffix);

        PrintUtil.printlnWithNaoTime(prefix, suffix, timer);

        PrintUtil.println(StringUtil.newString('a', -1), prefix, suffix);

    }
}
