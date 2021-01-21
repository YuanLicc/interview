package com.yl.learn.algorithm.r20210111;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

public class TwoZeroNine extends TestCase {
    
    // 1,1,1,1,2 => 4
    //
     public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0) return 0;
        int sumPre = 0, start = 0, len = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] >= s) return 1;
            int minus = sumPre + nums[i];
            if(minus >= s) {
                while (minus - nums[start] >= s && start < i) {
                    minus = minus - nums[start];
                    start++;
                }
                int cLen = i - start + 1;
                len = len < cLen ? len : cLen;
                sumPre = minus;
            }
            else {
                sumPre = minus;
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
    
    public void test() {
        PrintUtil.println(minSubArrayLen(5, new int[] {1,1,1,1,2}));
    }
    
}
