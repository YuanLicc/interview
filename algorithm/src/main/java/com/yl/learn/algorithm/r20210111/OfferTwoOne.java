package com.yl.learn.algorithm.r20210111;

import junit.framework.TestCase;

public class OfferTwoOne extends TestCase {
    
    public int[] exchange(int[] nums) {
        if(nums == null || nums.length <= 1) return nums;
        
        int pL = 0, pR = nums.length - 1;
        
        while (pL < pR) {
            while (pL < nums.length && nums[pL] % 2 == 1) pL++;
            while (pR > 0 && nums[pR] % 2 == 0) pR--;
            
            if(pL < pR) {
                int tmp = nums[pL];
                nums[pL++] = nums[pR];
                nums[pR--] = tmp;
            }
        }
        return nums;
    }
    
    public void test() {
        exchange(new int[] {1, 2, 3, 4, 5, 6, 1, 1, 1, 2, 2, 2, 2});
    }
}
