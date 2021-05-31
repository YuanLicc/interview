package com.yl.learn.algorithm.hot;

import java.util.HashMap;
import java.util.Map;

public class One {
    
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int oth = target - nums[i];
            Integer index = map.get(oth);
            if(index != null) return new int[] {index, i};
            map.put(nums[i], i);
        }
        return null;
    }
}
