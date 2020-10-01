package com.yl.learn.algorithm.kuaishou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）15
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeNumsSum {

    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length <= 2) return new ArrayList(1);
        Arrays.sort(nums);

        List<List<Integer>> rs = new ArrayList<>();

        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                if(start > i + 1 && nums[start] == nums[start - 1]) {
                    start++;
                    continue;
                }
                if(end < nums.length - 1 && nums[end] == nums[end + 1]) {
                    end++;
                    continue;
                }
                int se = nums[start] + nums[end] + nums[i];
                if(se == 0) {
                    List<Integer> item = new ArrayList<>(3);
                    item.add(nums[i]);
                    item.add(nums[start]);
                    item.add(nums[end]);
                    rs.add(item);
                    start++;
                    end--;
                }
                else if(se > 0) end--;
                else start++;
            }
        }
        return rs;
    }
}
