package com.yl.learn.algorithm.bytedance;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 示例 1:
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 *
 * 来源：力扣（LeetCode）704
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ArrayBinarySearch {

    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int middle = (start + end) / 2;

            if(nums[middle] == target) return middle;
            else if(nums[middle] > target) end = middle - 1;
            else start = middle + 1;
        }
        return nums[start] == target ? start : -1;
    }

}
