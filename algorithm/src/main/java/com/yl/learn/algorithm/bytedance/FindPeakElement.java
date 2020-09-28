package com.yl.learn.algorithm.bytedance;

import junit.framework.TestCase;

/**
 * 峰值元素是指其值大于左右相邻值的元素。
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞。
 *
 * 示例 1:
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 *
 * 示例 2:
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2； 或者返回索引 5， 其峰值元素为 6。
 *
 * 来源：力扣（LeetCode）162
 * 链接：https://leetcode-cn.com/problems/find-peak-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindPeakElement extends TestCase {

    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return 0;

        int start = 0;
        int end = nums.length - 1;
        // 1,2,1,3,5,6,4
        while (start <= end) {
            int middle = (start + end) / 2;
            if(middle == 0) {
                if(nums[0] > nums[1]) return 0;
                start = middle + 1;
            }
            else if(middle == nums.length - 1) {
                if(nums[middle] > nums[middle - 1]) return middle;
                end = middle - 1;
            }
            else if(nums[middle] > nums[middle - 1] && nums[middle] > nums[middle + 1]){
                return middle;
            }
            else if(nums[middle] > nums[middle - 1]) {
                start = middle + 1;
            }
            else {
                end = middle - 1;
            }
        }
        return -1;
    }
}
