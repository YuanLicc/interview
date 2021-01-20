package com.yl.learn.algorithm.r20210111;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

public class OneNineOne extends TestCase {
    public int hammingWeight(int n) {
        int rs = 0;
        if(n < 0) {
            n -= Integer.MIN_VALUE;
            rs++;
        }
        while (n != 0) {
            if((n & 1) == 1) rs++;
            n = n >> 1;
        }
        return rs;
    }
    
    public void test() {
        PrintUtil.println(hammingWeight(0b1111111111101));
    }
}
