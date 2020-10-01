package com.yl.learn.algorithm.kuaishou;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 来源：力扣（LeetCode）128
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestConsecutive {
    // 100, 4, 200, 1, 3, 2
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> mm = new HashMap();
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            if(mm.get(nums[i]) != null) continue;
            Integer left = mm.get(nums[i] - 1);
            Integer right = mm.get(nums[i] + 1);
            int sum = (left == null ? 0 : left) + (right == null ? 0 : right) + 1;
            mm.put(nums[i], sum);
            max = max > sum ? max : sum;
            if(left != null && mm.get(nums[i] - left) != null) {
                mm.put(nums[i] - left, sum);
            }
            if(right != null && mm.get(nums[i] + right) != null) {
                mm.put(nums[i] + right, sum);
            }
        }
        return max;
    }
}
