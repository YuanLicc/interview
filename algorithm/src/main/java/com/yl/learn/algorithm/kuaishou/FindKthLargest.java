package com.yl.learn.algorithm.kuaishou;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * 来源：力扣（LeetCode）215
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindKthLargest {
    
    public int findKthLargest(int[] nums, int k) {
        if(k == 1 && nums.length == 1) return nums[0];
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int index = partition(nums, start, end);
            if(index == k - 1) return nums[index];
            if(index > (k - 1)) end = index - 1;
            else start = index + 1;
        }
        return nums[start];
    }
    
    private int partition(int[] nums, int start, int end) {
        int tmp = nums[start];
        while (start < end) {
            while (nums[end] < tmp && end > start) {
                end--;
            }
            nums[start] = nums[end];
            while (nums[start] >= tmp && start < end) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = tmp;
        return start;
    }
    
}
