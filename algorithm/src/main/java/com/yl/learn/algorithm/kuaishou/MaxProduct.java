package com.yl.learn.algorithm.kuaishou;

/**
 * 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
 * 请你计算并返回该式的最大值。
 *
 * 示例 1：
 * 输入：nums = [3,4,5,2]
 * 输出：12
 * 解释：如果选择下标 i=1 和 j=2（下标从 0 开始），则可以获得最大值，(nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12 。
 *
 * 来源：力扣（LeetCode）1464
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-two-elements-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProduct {

    public int maxProduct(int[] nums) {
        int first = 0, second = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= first) {
                second = first;
                first = nums[i];
            }
            else {
                second = second > nums[i] ? second : nums[i];
            }
        }
        return (first - 1) * (second - 1);
    }
}
