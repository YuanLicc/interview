package com.yl.learn.algorithm.r20210111;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

public class Nine extends TestCase {
    
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(x < 10) return true;
        String xS = string(x);
        
        for (int i = 0; i < xS.length() / 2; i++) {
            if(xS.charAt(i) != xS.charAt(xS.length() - i - 1)) return false;
        }
        return true;
    }
    
    private String string(int x) {
        StringBuilder sb = new StringBuilder();
        while (x > 0) {
            sb.append(x % 10);
            x = x / 10;
        }
        return sb.toString();
    }
    
    public void test() {
        PrintUtil.println(isPalindrome(Integer.MAX_VALUE));
    }
}
