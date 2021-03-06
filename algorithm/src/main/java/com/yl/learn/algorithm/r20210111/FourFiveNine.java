package com.yl.learn.algorithm.r20210111;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

/**
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 *
 *  示例 1:
 *
 *
 * 输入: "abab"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "ab" 重复两次构成。
 *
 *
 *  示例 2:
 *
 *
 * 输入: "aba"
 *
 * 输出: False
 *
 *
 *  示例 3:
 *
 *
 * 输入: "abcabcabcabc"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 *
 *  Related Topics 字符串
 */
public class FourFiveNine extends TestCase {
    
    public boolean repeatedSubstringPattern(String s) {
        int len = 1;
        while (len <= s.length() / 2) {
            if(s.length() % len == 0 && check(s, len)) return true;
            len++;
        }
        return false;
    }
    
    private boolean check(String s, int len) {
        for (int p = len; p < s.length(); p++) {
            if(s.charAt(p) != s.charAt(p - len)) return false;
        }
        return true;
    }
    
    public void test() {
        PrintUtil.println(repeatedSubstringPattern("abaababaab"));
    }
    
}
