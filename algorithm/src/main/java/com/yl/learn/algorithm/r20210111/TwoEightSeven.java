package com.yl.learn.algorithm.r20210111;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

public class TwoEightSeven extends TestCase {
    
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if(i + 1 != nums[i]) {
                while (nums[i] != i + 1) {
                    int tmp = nums[i];
                    if(nums[i] == nums[nums[i] - 1]) return nums[i];
                    nums[i] = nums[nums[i] - 1];
                    nums[tmp - 1] = tmp;
                }
            }
        }
        
        return nums[nums.length - 1];
    }
    
    public void test() {
        PrintUtil.println(findDuplicate(new int[]{1, 2, 3, 4, 4,5}));
    }
}
