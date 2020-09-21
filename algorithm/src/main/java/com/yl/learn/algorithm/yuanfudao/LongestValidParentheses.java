package com.yl.learn.algorithm.yuanfudao;

import junit.framework.TestCase;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 *
 * 来源：力扣（LeetCode）32
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 */
public class LongestValidParentheses extends TestCase {

    public int longestValidParentheses(String s) {
        if(s == null || s.length() <= 1) return 0;

        int max = 0;
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == ')') continue;
            int left = 1;
            int right = 0;
            int validCnt = 0;
            for(int j = i + 1; j < s.length(); j++) {
                if(s.charAt(j) == '(') left++;
                else right++;

                if(left == right) validCnt = left;
                else if(left < right) break;
            }

            max = max > validCnt ? max : validCnt;
        }

        return max * 2;
    }

    public int longestValidParentheses1(String s) {
        if(s == null || s.length() <= 1) return 0;

        int max = 0;
        int[] cell = new int[s.length()];
        //(())
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == ')') {
                if(s.charAt(i - 1) == '(') {
                    cell[i] = 2 + (i - 2 > 0 ? cell[i - 2] : 0);
                }
                else if(i - cell[i - 1] - 1 >= 0 && s.charAt(i - cell[i - 1] - 1) == '(') {
                    cell[i] = 2 + cell[i - 1] + (i - cell[i - 1] - 2 >= 0 ? cell[i - cell[i - 1] - 2] : 0);
                }
            }
            max = max > cell[i] ? max : cell[i];
        }

        return max;
    }

    public void test() {
        longestValidParentheses1("(()())");
    }

}
