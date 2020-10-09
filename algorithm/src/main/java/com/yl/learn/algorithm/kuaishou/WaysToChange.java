package com.yl.learn.algorithm.kuaishou;

/**
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 *
 * 示例1:
 *  输入: n = 5
 *  输出：2
 *  解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 * 示例2:
 *
 *  输入: n = 10
 *  输出：4
 *  解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 *
 * 来源：力扣（LeetCode）面试题 08.11. 硬币
 * 链接：https://leetcode-cn.com/problems/coin-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WaysToChange {

    public int waysToChange(int n) {
        int coins[] = {1, 5, 10, 25};
        int [][] dp = new int[coins.length][n + 1];
        for(int i = 0; i < dp.length; i++) dp[i][0] = 1;
        for(int i = 1; i < dp[0].length; i++) dp[0][i] = i % coins[0] == 0 ? 1 : 0;

        for(int i = 1; i < coins.length; i++) {
            for(int j = 1; j < dp[i].length; j++) {
                if(j >= coins[i]) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
                }
                else dp[i][j] = dp[i - 1][j];
                dp[i][j] = dp[i][j] % 1000000007;
            }
        }
        return dp[coins.length - 1][n];
    }
}
