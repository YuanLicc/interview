package com.yl.learn.interview.algorithm.util;

import com.yl.learn.interview.util.PrintUtil;
import junit.framework.TestCase;

public class PrintUtilTest extends TestCase {

    public void testPrintLine() {
        String prefix = "start", suffix = "end";
        int column = 100, row = 2;

        PrintUtil.printLine(column, row, prefix, suffix);
        PrintUtil.printLine(-1, -1, prefix, suffix);
        PrintUtil.printLine(column, -1, prefix, suffix);
        PrintUtil.printLine(-1, row, prefix, suffix);
        PrintUtil.printLine(column, row, null, null);

        PrintUtil.printlnLine(column);
        PrintUtil.printlnLine(column, 2, prefix, suffix);
    }
}
