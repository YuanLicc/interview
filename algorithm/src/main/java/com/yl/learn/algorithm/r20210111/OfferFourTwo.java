package com.yl.learn.algorithm.r20210111;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 * 示例1:
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 */
public class OfferFourTwo extends TestCase {
    // dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]]);
    public int maxSubArray(int[] nums) {
        int max = nums[0], pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int sum = pre + nums[i];
            pre = sum > nums[i] ? sum : nums[i];
            max = max > pre ? max : pre;
        }
        return pre;
    }
    
    public void test() {
        PrintUtil.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
    
}
