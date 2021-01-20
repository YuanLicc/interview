package com.yl.learn.algorithm.r20210111;

public class OneTwoThree {
    
    public int maxProfit(int[] prices) {
        int[][] dp = new int[3][2];
        for (int i = 0; i < 3; i++) {
            dp[i][0] = 0;
            dp[i][1] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - prices[i]);
                dp[j][0] = Math.max(dp[j][0], dp[j][1] + prices[i]);
            }
        }
        
        return dp[2][0];
    }
    
}
