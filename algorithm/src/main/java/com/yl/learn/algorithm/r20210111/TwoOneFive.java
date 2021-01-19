package com.yl.learn.algorithm.r20210111;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *  示例 1:
 *  输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *  示例 2:
 *  输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 *  说明:
 *  你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *  Related Topics 堆 分治算法
 */
public class TwoOneFive extends TestCase {
    /**
     * 首先想到的是根据快排的 partition
     */
    public int findKthLargest(int[] nums, int k) {
        int start = 0, end = nums.length - 1;
        int aimIndex = nums.length - k;
        while (start <= end) {
            int index = index(nums, start, end);
            if(index == aimIndex) return nums[index];
            else if(index < aimIndex) start = index + 1;
            else end = index - 1;
        }
        return -1;
    }
    
    private int index(int[] nums, int start, int end) {
        int temp = nums[start];
        
        while (start < end) {
            while (start < end && nums[end] >= temp) end--;
            if(start == end) break;
            nums[start] = nums[end];
            
            while (start < end && nums[start] < temp) start++;
            if(end == start) break;
            nums[end] = nums[start];
        }
        nums[start] = temp;
        return start;
    }
    
    public void testA() {
        PrintUtil.println(findKthLargest(new int[]{1, 5, 2, 3, 20,-100}, 6));
    }
}

