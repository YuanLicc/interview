package com.yl.learn.algorithm.bytedance;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 *
 * 示例 1:
 * 输入: [1,2,0]
 * 输出: 3
 *
 * 示例 2:
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *
 * 来源：力扣（LeetCode）41
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FirstMissingPositive extends TestCase {
    
    public int firstMissingPositive(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] <= 0) continue;
            if(map.get(nums[i]) == null) map.put(nums[i], 0);
            min = min > nums[i] ? nums[i] : min;
            max = max > nums[i] ? max : nums[i];
        }
        if(min != 1) return 1;
        
        min = max + 1;
        for(int item : map.keySet()) {
            if(map.get(item + 1) == null) min = min < item ? min : item;
        }
        return min + 1;
    }
    
    
    public void test() {
        firstMissingPositive(new int[]{1, 2, 4, 11});
    }
}
