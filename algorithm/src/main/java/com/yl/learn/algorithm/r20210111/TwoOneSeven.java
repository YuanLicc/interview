package com.yl.learn.algorithm.r20210111;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

public class TwoOneSeven extends TestCase {
    
    public boolean containsDuplicate(int[] nums) {
        if(nums == null) return false;
        Map<Integer, Byte> ca = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if(ca.get(nums[i]) != null) return true;
            else ca.put(nums[i], Byte.MAX_VALUE);
        }
        return false;
    }
    
    public void test() {
        PrintUtil.println(containsDuplicate(new int[]{1,2,3}));
        PrintUtil.println(containsDuplicate(new int[]{1,2,3,2}));
    }
    
}
