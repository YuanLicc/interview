package com.yl.learn.algorithm.alibaba;

/**
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * 示例 1:
 * 输入: "abab"
 * 输出: True
 *
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 * 输入: "aba"
 *
 * 输出: False
 *
 * 来源：力扣（LeetCode）459
 * 链接：https://leetcode-cn.com/problems/repeated-substring-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        if(s == null || s.length() <= 1) return false;
        for(int i = 1; i <= s.length() / 2; i++) {
            if(s.charAt(i) == s.charAt(0)) {
                if(check(s, 0, i)) return true;
            }
        }
        return false;
    }

    private boolean check(String s, int i, int i1) {
        int iEnd = i1 - 1;
        while (i < s.length() && i <= iEnd && i1 < s.length()) {
            if(s.charAt(i) != s.charAt(i1)) return false;
            i++;
            i1++;
        }
        if(i > iEnd && i1 == s.length()) return true;
        if(i <= iEnd) return false;
        return check(s, i, i1);
    }
}
