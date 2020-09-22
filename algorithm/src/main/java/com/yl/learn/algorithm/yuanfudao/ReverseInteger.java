package com.yl.learn.algorithm.yuanfudao;

import junit.framework.TestCase;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 *
 * 来源：力扣（LeetCode）7
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 */
public class ReverseInteger extends TestCase {
    public int reverse(int x) {
        int rs = 0;

        while(x != 0) {
            int addNum = x % 10;
            if(x < 0 && (Integer.MIN_VALUE - addNum) / 10 > rs) return 0;
            if(x > 0 && (Integer.MAX_VALUE - addNum) / 10 < rs) return 0;

            rs = rs * 10 + addNum;
            x = x / 10;
        }

        return rs;
    }

    public void test() {
        reverse(123);
    }
}
