package com.yl.learn.algorithm.r20210111;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;
// zy
public class OneSixEight extends TestCase {
    
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int mo = n % 26;
            if(mo == 0) {
                sb.append('Z');
                n = n / 26 - 1;
            }
            else {
                sb.append((char) (mo + 'A' - 1));
                n = n / 26;
            }
            
        }
        
        return sb.reverse().toString();
    }
    
    public void test() {
        PrintUtil.println(convertToTitle(1));
        PrintUtil.println(convertToTitle(26));
        PrintUtil.println(convertToTitle(27));
        PrintUtil.println(convertToTitle(28));
        PrintUtil.println(convertToTitle(701));
        PrintUtil.println(convertToTitle(52));
    }
}
