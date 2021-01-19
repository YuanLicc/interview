package com.yl.learn;

import com.yl.learn.util.util.PrintUtil;

public class Init {

    public static int a;
    public static int b = 123;
    public final static int A;
    public final static int B = 111;
    public final static Object A1 = new Object();

    static {
        A = 123;
        PrintUtil.println("init");
    }

    public static void method() {
        PrintUtil.println();
    }
}
