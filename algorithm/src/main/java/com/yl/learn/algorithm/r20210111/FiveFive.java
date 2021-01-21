package com.yl.learn.algorithm.r20210111;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

public class FiveFive extends TestCase {
    // 1,2,3,4
    public boolean canJump(int[] nums) {
        return canJump(nums, 0);
    }
    
    private boolean canJump(int[] nums, int index) {
        if(index >= nums.length - 1) return true;
        if(nums[index] == 0) return false;
        
        for (int i = nums[index]; i > 0; i--) {
            if(canJump(nums, i + index)) {
                return true;
            }
        }
        return false;
    }
    
    public void test() {
        PrintUtil.println(canJump(new int[]{2,3,1,1,4}));
    }
    
}
