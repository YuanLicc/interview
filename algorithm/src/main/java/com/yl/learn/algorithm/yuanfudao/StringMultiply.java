package com.yl.learn.algorithm.yuanfudao;

import junit.framework.TestCase;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 *
 * 来源：力扣（LeetCode）43
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 */
public class StringMultiply extends TestCase {

    public String multiply(String num1, String num2) {
        if(num1 == null || num1 == null || num1.length() == 0 || num2.length() == 0) return "0";
        // 2282
        //  222

        int[] rs = new int[num1.length() + num2.length() + 1];

        for(int i = num1.length() - 1; i >= 0; i--) {
            int down = num1.charAt(i) - '0';
            int downWei = num1.length() - i;
            for(int j = num2.length() - 1; j >= 0; j--) {
                int up = num2.charAt(j) - '0';
                int upWei = num2.length() - j;
                int maxWei = downWei + upWei - 1;

                int mul = down * up;
                add(rs, rs.length - maxWei, mul % 10);
                if(mul >= 10) {
                    add(rs, rs.length - maxWei - 1, mul / 10);
                }
            }
        }

        int index = 0;
        while(index < rs.length && rs[index] == 0) index++;
        StringBuilder sb = new StringBuilder(rs.length - index);

        for(; index < rs.length; index++) sb.append(rs[index]);

        String num = sb.toString();
        return num.equals("") ? "0" : num;
    }

    private void add(int[] num, int index, int addNum) {
        int sum = num[index] + addNum;
        num[index] = sum % 10;
        num[index - 1] += sum / 10;
    }

    public void test() {
        multiply("123", "45");
        //  45
        // 123
        // 135
        //
    }
}
