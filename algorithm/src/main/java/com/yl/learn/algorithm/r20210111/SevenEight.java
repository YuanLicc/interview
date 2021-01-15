package com.yl.learn.algorithm.r20210111;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，返回该数组所有可能的子集（幂集）。解集不能包含重复的子集。
 *
 *
 *  示例 1：
 *
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 *
 *  示例 2：
 *
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 *
 *
 *
 *  提示：
 *
 *
 *  1 <= nums.length <= 10
 *  -10 <= nums[i] <= 10
 *
 *  Related Topics 位运算 数组 回溯算法
 */
public class SevenEight {
    
    private List<List<Integer>> rs = new LinkedList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) return Collections.emptyList();
        sub(nums, 0, new LinkedList<>());
        return rs;
    }
    
    private void sub(int[] nums, int index, List<Integer> selected) {
        if(index > nums.length - 1) {
            rs.add(selected);
            return;
        }
        
        List<Integer> cop = new LinkedList<>(selected);
        cop.add(nums[index]);
        sub(nums, index + 1, cop);
        
        sub(nums, index + 1, new LinkedList<>(selected));
        
        
    }
    
}
