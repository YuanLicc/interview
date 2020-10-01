package com.yl.learn.algorithm.kuaishou;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 *
 * 示例 2：
 * 输入：n = 7
 * 输出：21
 *
 * 来源：力扣（LeetCode）offer 10
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GuaNumWays {
    
    public int numWays(int n) {
        if(n <= 1) return 1;
        int pre = 1, cur = 1, cnt = 0;
        while (n > 1) {
            cnt = ((pre + cur) % 1000000007);
            pre = cur;
            cur = cnt;
            n--;
        }
        return cnt;
    }
}
