package com.yl.learn.algorithm.bytedance;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

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
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestConsecutive extends TestCase {
    
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for(int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) != null) continue;
            Integer left = map.get(nums[i] - 1);
            Integer right = map.get(nums[i] + 1);
            int cur = (left == null ? 0 : left) + (right == null ? 0 : right) + 1;
            map.put(nums[i], cur);
            if(left != null && map.get(nums[i] - left) != null) map.put(nums[i] - left, cur);
            if(right != null && map.get(nums[i] + right) != null) map.put(nums[i] + right, cur);
            max = max > cur ? max : cur;
        }
        return max;
    }
    
    public void test() {
        PrintUtil.println(longestConsecutive(new int[]{1, 2, 3, 100, 4, 200, 0}));
    }
}
