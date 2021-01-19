package com.yl.learn;

import com.yl.learn.util.util.PrintUtil;

public class InitObject {
    public static final int finalStaticField = 1;
    
    public static final int finalStaticUnField;
    
    public static int staticField;
    
    public int objectField;
    
    static {
        finalStaticUnField = 1;
        PrintUtil.println("INIT");
    }
    
    public static void staticMethod() {
    
    }
}
