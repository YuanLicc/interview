package com.yl.learn.algorithm.kuaishou;

import java.util.Stack;

/**
 * 根据 逆波兰表示法，求表达式的值。
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *
 * 示例 1：
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 *
 * 来源：力扣（LeetCode）150
 * 链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class EvalRPN {

    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        for(int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            switch (s) {
                case "+" : {
                    int sum = nums.pop() + nums.pop();
                    nums.push(sum);
                    break;
                }
                case "*" : {
                    int cc = nums.pop() * nums.pop();
                    nums.push(cc);
                    break;
                }
                case "-" : {
                    int minus = nums.pop();
                    nums.push(nums.pop() - minus);
                    break;
                }
                case "/" : {
                    int divide = nums.pop();
                    nums.push(nums.pop() / divide);
                    break;
                }
                default: {
                    nums.push(Integer.valueOf(s));
                }
            }
        }
        return nums.pop();
    }

}
