package com.yl.learn.lambda;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

public class PrintableTest extends TestCase {

    public void testPrintable() {
        Printable printable = () -> PrintUtil.println("aaa");
        printable.print();

        PrintableOneParam printableOneParam = arg -> PrintUtil.println(arg);
        printableOneParam.print("aaaa");

        PrintableOneParam printableOneParam1 = arg -> {
            PrintUtil.println("one line");
            PrintUtil.println(arg);
        };

        String name = "ccc";

        PrintableMultiParams printableMultiParams = (arg, isPrint) -> {
            if(isPrint) {
                PrintUtil.println(arg + name);
            }
        };

        printableMultiParams.print("kk", true);
        printableMultiParams.print("kk", false);
    }
}
