package com.yl.learn.algorithm.r20210111;

import junit.framework.TestCase;

import java.util.LinkedList;

/**
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 */
public class OfferFiveNine extends TestCase {
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 1) return nums;
        LinkedList<Integer> queue = new LinkedList<>();
        int[] rs = new int[nums.length - k + 1];
        int index = 0;
        
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.addLast(i);
            
            while (!queue.isEmpty() && queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }
            if(i >= k - 1) {
                rs[index++] = nums[queue.peekFirst()];
            }
        }
        return rs;
    }
    
    public void test() {
        maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3);
    }
    
}
