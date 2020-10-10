package com.yl.learn.algorithm.alibaba;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）46
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Permute {
    
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, new ArrayList<>());
        return rs;
    }
    
    List<List<Integer>> rs = new ArrayList<>();
    
    private void dfs(int[] nums, List<Integer> selected) {
        if(nums.length == 0) {
            rs.add(selected);
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            int[] cpNums = rm(nums, i);
            List<Integer> cp = copied(selected);
            cp.add(nums[i]);
            dfs(cpNums, cp);
        }
    }
    
    private List<Integer> copied(List<Integer> list) {
        List<Integer> cp = new ArrayList<>(list.size());
        for(int i = 0; i < list.size(); i++) cp.add(list.get(i));
        return cp;
    }
    
    private int[] rm(int[] nums, int rmI) {
        int[] rs = new int[nums.length - 1];
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i != rmI) rs[index++] = nums[i];
        }
        return rs;
    }
    
}
