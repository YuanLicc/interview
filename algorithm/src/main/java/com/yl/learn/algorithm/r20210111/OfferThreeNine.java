package com.yl.learn.algorithm.r20210111;

import junit.framework.TestCase;

public class OfferThreeNine extends TestCase {
    
    public int majorityElement(int[] nums) {
        int cnt = 1;
        int num = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if(cnt == 0) {
                cnt = 1;
                num = nums[i];
            }
            else if(nums[i] == num) cnt++;
            else cnt--;
        }
        return num;
    }
    
}
