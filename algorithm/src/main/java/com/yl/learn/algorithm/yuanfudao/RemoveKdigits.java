package com.yl.learn.algorithm.yuanfudao;

import junit.framework.TestCase;

import java.util.Stack;

/**
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * 注意:
 *
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 *
 * 来源：力扣（LeetCode）402
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 */
public class RemoveKdigits extends TestCase {

    public String removeKdigits(String num, int k) {
        if(num == null || num.length() == 0 || k >= num.length()) return "0";

        // 12321 3 121
        Stack<Character> stack = new Stack<>();
        stack.push(num.charAt(0));
        int deleteNum = 0;
        for(int i = 1; i < num.length(); i++) {
            while(!stack.isEmpty() && deleteNum < k && stack.peek() > num.charAt(i)) {
                stack.pop();
                deleteNum++;
            }
            stack.push(num.charAt(i));
        }

        for(; deleteNum < k; deleteNum++) {
            stack.pop();
        }

        boolean first = true;
        StringBuilder sb = new StringBuilder(num.length() - k);

        for(int i = 0; i < stack.size(); i++) {
            if(first && stack.get(i) == '0') {}
            else {
                sb.append(stack.get(i));
                first = false;
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
