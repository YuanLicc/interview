package com.yl.learn.algorithm.r20210111;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *
 *
 *  示例 1：
 *
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 *
 *  示例 2：
 *
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 *
 *  示例 3：
 *
 *
 * 输入：s = "a"
 * 输出："a"
 *
 *
 *  示例 4：
 *
 *
 * 输入：s = "ac"
 * 输出："a"
 *
 *
 *
 *
 *  提示：
 *
 *
 *  1 <= s.length <= 1000
 *  s 仅由数字和英文字母（大写和/或小写）组成
 *
 *  Related Topics 字符串 动态规划
 */
public class Five extends TestCase {
    public String longestPalindrome(String s) {
        if(s.length() <= 1) return s;
        
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 1;
        int end = 0;
        dp[0][0] = true;
        
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i - 1)) {
                dp[i - 1][i] = true;
                max = 2;
                end = i;
            }
            dp[i][i] = true;
        }
        
        for (int freq = 2; freq < s.length(); freq++) {
            for (int i = 0; i < s.length() - freq; i++) {
                if(s.charAt(i) == s.charAt(i + freq) && dp[i + 1][i + freq - 1]) {
                    dp[i][i + freq] = true;
                    if(freq > (max + 1)) {
                        max = freq + 1;
                        end = i + freq;
                    }
                }
            }
        }
        
        return s.substring(end - max + 1, end + 1);
    }
    
    public void test() {
        PrintUtil.println(longestPalindrome("ccc"));
    }
}

