package com.yl.learn.algorithm.r20210111;

import junit.framework.TestCase;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 *
 *  提示：
 *
 *
 *  num1 和num2 的长度都小于 5100
 *  num1 和num2 都只包含数字 0-9
 *  num1 和num2 都不包含任何前导零
 *  你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 *
 *  Related Topics 字符串
 */
public class FourOneFive extends TestCase {
    
    public String addStrings(String num1, String num2) {
        return new String(add(num1.toCharArray(), num2.toCharArray()));
    }
    
    private char[] add(char[] num1, char[] num2) {
        int len = (num1.length > num2.length ? num1.length : num2.length) + 1;
        char[] tmp = new char[len];
        int n1 = num1.length - 1, n2 = num2.length - 1;
        
        int up = 0;
        int index = tmp.length - 1;
        while (n1 >= 0 && n2 >= 0) {
            int sum = (num1[n1--] - '0' + num2[n2--] - '0') + up;
            tmp[index--] = (char) (sum % 10 + '0');
            up = sum / 10;
        }
        
        char[] remain = n1 >= 0 ? num1 : num2;
        int i = n1 >= 0 ? n1 : n2;
        
        if(i >= 0) {
            while (i >= 0) {
                int sum = (remain[i--] - '0') + up;
                tmp[index--] = (char) (sum % 10 + '0');
                up = sum / 10;
            }
        }
        
        if(up != 0) tmp[index--] = (char) (up + '0');
        
        if(index == 0) {
            char[] rs = new char[tmp.length - 1];
            System.arraycopy(tmp, 1, rs, 0, rs.length);
            return rs;
        }
        
        return tmp;
    }
    
    public void test() {
        System.out.println(addStrings("999", "99"));
    }
}
