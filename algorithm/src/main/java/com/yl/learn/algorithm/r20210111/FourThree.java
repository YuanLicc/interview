package com.yl.learn.algorithm.r20210111;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

public class FourThree extends TestCase {
    
    public String multiply(String num1, String num2) {
        char[] numA = num1.toCharArray();
        char[] numB = num2.toCharArray();
        int[] rs = new int[num1.length() + num2.length()];
        for (int i = numA.length - 1; i >= 0; i--) {
            int a = numA[i] - '0';
            int aZeroNum = numA.length - i - 1;
            for (int j = numB.length - 1; j >= 0; j--) {
                int b = numB[j] - '0';
                int bZeroNum = numB.length - j - 1;
                int index = rs.length - 1 - aZeroNum - bZeroNum;
                int mul = a * b + rs[index];
                
                int up = mul / 10;
                rs[index] = mul % 10;
                rs[index - 1] += up;
            }
        }
        
        return string(rs);
    }
    
    private String string(int[] arr) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        
        while (i < arr.length && arr[i] == 0) i++;
        for (; i < arr.length; i++) {
            sb.append((char) (arr[i] + '0'));
        }
        
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
    
    public void test() {
        PrintUtil.println(multiply("123456789", "987654321"));
    }
    
}
