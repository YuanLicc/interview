package com.yl.learn.algorithm.r20210111;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 *  示例:
 *
 *  输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *  Related Topics 回溯算法
 */
public class FourSix extends TestCase {
    public List<List<Integer>> permute(int[] nums) {
        
        for (int i = 0; i < nums.length; i++) {
            List<Integer> row = new ArrayList<>(nums.length);
            row.add(nums[i]);
            
            dfs(rm(nums, i), row);
        }
        
        return rs;
    }
    
    List<List<Integer>> rs = new ArrayList<>();
    
    private void dfs(int[] nums, List<Integer> row) {
        if(nums.length == 0) rs.add(row);
        
        for (int i = 0; i < nums.length; i++) {
            dfs(rm(nums, i), add(row, nums[i]));
        }
    }
    
    private List<Integer> add(List<Integer> so, int num) {
        List<Integer> rs = new ArrayList<>(so);
        rs.add(num);
        return rs;
    }
    
    private int[] rm(int[] so, int index) {
        int[] rs = new int[so.length - 1];
        int ix = 0;
        for (int i = 0; i < so.length; i++) {
            if(i != index) {
                rs[ix++] = so[i];
            }
        }
        return rs;
    }
    
    public void test() {
        permute(new int[] {1, 2, 3});
    }
}
