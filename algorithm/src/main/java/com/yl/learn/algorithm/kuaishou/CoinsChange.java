package com.yl.learn.algorithm.kuaishou;

/**
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
 *
 * 示例 1:
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2:
 *
 * 输入: amount = 3, coins = [2]
 * 输出: 0
 * 解释: 只用面额2的硬币不能凑成总金额3。
 * 示例 3:
 *
 * 输入: amount = 10, coins = [10]
 * 输出: 1
 *
 * 来源：力扣（LeetCode）518
 * 链接：https://leetcode-cn.com/problems/coin-change-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CoinsChange {

    public int change(int amount, int[] coins) {
        if(amount <= 0) return 1;
        if(coins.length == 0) return 0;
        int[][] dp = new int[coins.length][amount + 1];
        for(int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i < dp[0].length; i++) {
            if(i % coins[0] == 0) dp[0][i] = 1;
        }

        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[i].length; j++) {
                dp[i][j] = dp[i - 1][j] + (j >= coins[i] ? dp[i][j - coins[i]] : 0);
            }
        }
        return dp[coins.length - 1][amount];
    }

}
