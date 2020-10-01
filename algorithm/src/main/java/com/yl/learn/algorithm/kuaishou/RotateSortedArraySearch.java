package com.yl.learn.algorithm.kuaishou;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 *
 * 来源：力扣（LeetCode）33
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RotateSortedArraySearch {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int middle = (start + end) / 2;
            if(nums[start] == target) return start;
            if(nums[end] == target) return end;
            if(nums[middle] == target) return middle;
            if(nums[middle] >= nums[start]) {
                if(target > nums[start] && nums[middle] > target) end = middle - 1;
                else start = middle + 1;
            }
            else {
                if(target > nums[middle] && nums[end] > target) start = middle + 1;
                else end = middle - 1;
            }
        }
        return nums[start] == target ? start : -1;
    }

}
