package com.yl.learn.algorithm.kuaishou;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * 来源：力扣（LeetCode）34
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortedArraySearchRange {

    public int[] searchRange(int[] nums, int target) {
        return new int[]{search(nums, target, true), search(nums, target, false)};
    }

    private int search(int[] nums, int target, boolean left) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if(!left) {
                if(nums[middle] == target && ((middle < nums.length - 1 && nums[middle + 1] != target) || middle == nums.length - 1)) return middle;
                if(nums[middle] <= target) start = middle + 1;
                else end = middle - 1;
            }
            else {
                if(nums[middle] == target && ((middle > 0 && nums[middle - 1] != target) || middle == 0)) return middle;
                if(nums[middle] < target) start = middle + 1;
                else end = middle - 1;
            }
        }
        return -1;
    }

    private int searchRight(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if(nums[middle] == target && ((middle < nums.length - 1 && nums[middle + 1] != target) || middle == nums.length - 1)) return middle;
            if(nums[middle] <= target) start = middle + 1;
            else end = middle - 1;
        }
        return -1;
    }

    private int searchLeft(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if(nums[middle] == target && ((middle > 0 && nums[middle - 1] != target) || middle == 0)) return middle;
            if(nums[middle] < target) start = middle + 1;
            else end = middle - 1;
        }
        return -1;
    }

}
