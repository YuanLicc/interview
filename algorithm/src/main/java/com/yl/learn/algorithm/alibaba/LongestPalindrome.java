package com.yl.learn.algorithm.alibaba;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）5
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindrome extends TestCase {
    
    public String longestPalindrome(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];
        int max = 1;
        int maxIndex = 0;
        for(int i = 0; i < s.length(); i++) dp[i][i] = true;
        for(int i = 1; i < s.length(); i++) {
            for(int j = 0; (i + j) < s.length(); j++) {
                if(i == 1 && s.charAt(j) == s.charAt(j + i)) dp[j][j + i] = true;
                else if(s.charAt(j) == s.charAt(j + i) && dp[j + 1][i + j - 1]) dp[j][j + i] = true;
                if(dp[j][j + i] && (i + 1) > max) {
                    maxIndex = j;
                    max = i + 1;
                }
            }
        }
        return s.substring(maxIndex, maxIndex + max);
    }
    
    public void test() {
        PrintUtil.println(longestPalindrome("abc"));
    }
    
}
