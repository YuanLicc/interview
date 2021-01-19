package com.yl.learn.algorithm.r20210111;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

/**
 * * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *  * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *  *
 *  * 示例 1：
 *  * 输入：n = 2
 *  * 输出：2
 *  *
 *  * 示例 2：
 *  * 输入：n = 7
 *  * 输出：21
 */
public class OfferOneZero extends TestCase {
    
    public int numWays(int n) {
        if(n <= 2) return n;
        
        int pre = 1;
        int cur = 2;
        
        while (n > 2) {
            int tmp = (cur + pre) % 1000000007;
            pre = cur;
            cur = tmp;
            n--;
        }
        return cur;
    }
    
    public void test() {
        PrintUtil.println(numWays(7));
    }
    
}
