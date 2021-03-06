package com.yl.learn.algorithm.kuaishou;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）20
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KuoHaoValid {

    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;
        if(s.length() % 2 == 1) return false;

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(' : {
                    stack.push(')');
                    break;
                }
                case '[' : {
                    stack.push(']');
                    break;
                }
                case '{' : {
                    stack.push('}');
                    break;
                }
                default: {
                    if(stack.isEmpty()) return false;
                    if(stack.pop() != c) return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
