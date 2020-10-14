package com.yl.learn;

public class Init {

    public static int a;
    public static int b = 123;
    public final static int A;
    public final static int B = 111;
    public final static Object A1 = new Object();

    static {
        A = 123;
        System.out.println("init");
    }

    public static void method() {
        System.out.println();
    }
}
