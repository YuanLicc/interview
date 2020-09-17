package com.yl.learn.algorithm.yuanfudao;

import junit.framework.TestCase;

public class FindNumberOfLIS extends TestCase {
    
    public int findNumberOfLIS(int[] nums) {
        
        int cell[] = new int[nums.length];
        
        cell[0] = 1;
        
        int cnt = 1;
        int max = 1;
        for(int i = 1; i < cell.length; i++) {
            cell[i] = 1;
            for(int j = i - 1; j >= 0; j--) {
                if(nums[j] <= nums[i]) {
                    cell[i] = cell[j] + 1;
                    if(max == cell[i]) {
                        cnt++;
                    }
                    else if(max < cell[i]) {
                        cnt = 1;
                        max = cell[i];
                    }
                }
            }
            cnt = max == 1 ? cnt + 1 : cnt;
        }
        return cnt;
    }
    
    public void test() {
        findNumberOfLIS(new int[]{1,3,5,4,7});
    }
    
}
