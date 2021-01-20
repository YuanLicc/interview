package com.yl.learn.algorithm.r20210111;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

public class OneTwoTwo extends TestCase {
    
    public int maxProfit(int[] prices) {
        int sum = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > min) {
                sum += prices[i] - min;
            }
            min = prices[i];
        }
        return sum;
    }
    
    public void test() {
        PrintUtil.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
    
}
