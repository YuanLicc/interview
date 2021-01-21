package com.yl.learn.algorithm.r20210111;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

public class OneOneFourThree extends TestCase {
    
    // dp[i][j] = if i == j dp[i - 1][j - 1] + 1, dp[i - 1][j], dp[i][j - 1] else dp[i - 1][j], dp[i][j - 1]
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        
        for (int i = 1; i < dp.length; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j < dp[i].length; j++) {
                char c2 = text2.charAt(j - 1);
                if(c1 == c2) dp[i][j] = Math.max(Math.max(dp[i - 1][j - 1] + 1, dp[i][j - 1]), dp[i - 1][j]);
                else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        
        return dp[text1.length()][text2.length()];
    }
    
    public void test() {
        PrintUtil.println(longestCommonSubsequence("123", "1aa22a3"));
        PrintUtil.println(longestCommonSubsequence("abcde", "ace"));
        PrintUtil.println(longestCommonSubsequence("abc", "abc"));
        PrintUtil.println(longestCommonSubsequence("abc", "de"));
    }
}
