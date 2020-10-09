package com.yl.learn.algorithm.alibaba;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）78
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        rs.add(new ArrayList(1));
        return rs;
    }

    List<List<Integer>> rs = new ArrayList<>();

    private void dfs(int[] nums, int i, List<Integer> list) {
        if(i >= nums.length) return;
        dfs(nums, i + 1, copy(list));
        List<Integer> copied = copy(list);
        copied.add(nums[i]);
        rs.add(copied);
        dfs(nums, i + 1, copied);
    }

    private List<Integer> copy(List<Integer> copied) {
        if(copied.size() == 0) return new ArrayList<>();
        List<Integer> rs = new ArrayList<>();
        for(int i = 0; i < copied.size(); i++) rs.add(copied.get(i));
        return rs;
    }

}
