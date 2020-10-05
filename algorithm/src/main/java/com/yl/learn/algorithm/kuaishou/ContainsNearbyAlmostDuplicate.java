package com.yl.learn.algorithm.kuaishou;

public class ContainsNearbyAlmostDuplicate {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j < nums.length && (j - i) <= k; j++) {
                if(Math.abs((long) nums[i] - (long) nums[j]) <= t) return true;
            }
        }
        return false;
    }
}
