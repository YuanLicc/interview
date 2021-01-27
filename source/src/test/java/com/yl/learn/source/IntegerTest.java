package com.yl.learn.source;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

public class IntegerTest extends TestCase {
    
    public void test() {
        PrintUtil.println(Integer.MIN_VALUE);
        PrintUtil.println((int)Math.pow(2, 31));
    }
}
