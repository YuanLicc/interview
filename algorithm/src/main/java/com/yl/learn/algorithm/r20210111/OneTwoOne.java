package com.yl.learn.algorithm.r20210111;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

public class OneTwoOne extends TestCase {
    // 13,1,1,2,1,4,1,1,12,342,1212
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int minus = Integer.MIN_VALUE;
        
        for (int i = 1; i < prices.length; i++) {
            int mi = prices[i] - min;
            minus = minus > mi ? minus : mi;
            min = min < prices[i] ? min : prices[i];
        }
        
        return minus < 0 ? 0 : minus;
    }
    
    public int max(int[] prices) {
        int buy = 0;
        int sell = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            buy = Math.max(buy, sell + prices[i]);
            sell = Math.max(sell, 0 - prices[i]);
        }
        return buy;
    }
    
    public void test() {
        PrintUtil.println(maxProfit(new int[]{13,1,1,2,1,4,1,1,12,342,121}));
        PrintUtil.println(max(new int[]{13,1,1,2,1,4,1,1,12,342,121}));
    }
}
