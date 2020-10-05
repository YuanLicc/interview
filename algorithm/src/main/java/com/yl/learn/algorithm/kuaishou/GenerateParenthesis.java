package com.yl.learn.algorithm.kuaishou;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例：
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * 来源：力扣（LeetCode）22
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        dfs(0, 0, "", n);
        return rs;
    }
    List<String> rs = new ArrayList<>();
    private void dfs(int left, int right, String s, int n) {
        if(left == right && left == n) {
            rs.add(s);
            return;
        }
        if(left > n || right > n || right > left) return;
        dfs(left + 1, right, s + "(", n);
        dfs(left, right + 1, s + ")", n);
    }
}
