package com.yl.learn.algorithm.ds;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

// 两数最大公约数，辗转相除法 gcd(a, b) = gcd(b, a % b)
public class Gcd extends TestCase {
    
    public long gcd(long a, long b) {
        
        while(b != 0) {
            long new_b = a % b;
            a = b;
            b = new_b;
        }
        
        return a;
    }
    
    public void testGcdRecursion() {
        PrintUtil.println(gcd(10, 100));
        PrintUtil.println(gcd(100, 17));
        PrintUtil.println(gcd(11232424, 3232424));
    }
    
    
}
