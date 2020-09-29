package com.yl.learn.algorithm.bytedance;

import junit.framework.TestCase;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 示例 1:
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *
 * 来源：力扣（LeetCode）322
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CoinChange extends TestCase {

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int min = dfs(coins, amount, new int[amount]);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    // min[amount] = min(amount - coins) + 1
    private int dfs(int[] coins, int amount, int[] cache) {
        if(amount == 0) return 0;
        if(amount < 0) return Integer.MAX_VALUE;
        if(cache[amount - 1] != 0) return cache[amount - 1];

        int min = Integer.MAX_VALUE;
        for(int i = coins.length - 1; i >= 0; i--) {
            if(coins[i] <= amount) {
                int x = dfs(coins, amount - coins[i], cache);
                if(x != Integer.MAX_VALUE) {
                    x = x + 1;
                    min = min < x ? min : x;
                }
            }
        }
        cache[amount - 1] = min;
        return min;
    }

    public void test() {
        coinChange(new int[]{1, 2, 5}, 11);
    }


}
