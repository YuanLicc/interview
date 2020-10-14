package com.yl.learn.algorithm.alibaba;

import junit.framework.TestCase;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * 来源：力扣（LeetCode）215
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindKthLargest extends TestCase {

    public int findKthLargest(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        while (true) {
            int index = partition(nums, start, end);
            if(index == k - 1) return nums[index];
            else if(index > k - 1) end = index - 1;
            else start = index + 1;
        }
    }

    private int partition(int[] nums, int start, int end) {
        int tmp = nums[start];
        while (start < end) {
            while (end > start && nums[end] <= tmp) end--;
            if(start == end) break;
            nums[start] = nums[end];
            while (start < end && nums[start] > tmp) start++;
            if(start == end) break;
            nums[end] = nums[start];
        }
        nums[start] = tmp;
        return start;
    }

    public void test() {
        findKthLargest(new int[]{3,2,1,5,6,4}, 2);
    }
}
