package com.yl.learn.lambda;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

public class PrintableHasReturnTest extends TestCase {
    public void testPrintableHasReturn() {
        PrintableHasReturn printableHasReturn =(String printed) -> {
            return printed;
        };

        PrintableHasReturn printableHasReturn1 = printed -> ("".equals(printed)) + "";
        PrintUtil.println(printableHasReturn1.print("aaa"));

    }
}
