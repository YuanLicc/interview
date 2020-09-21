package com.yl.learn.algorithm.yuanfudao;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 *
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * 输出: 1
 *
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 *
 * 来源：力扣（LeetCode）435
 * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 */
public class Leetcode435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        if(intervals == null || intervals.length == 0) return 0;
        
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        
        int[] cell = new int[intervals.length];
        cell[0] = 1;
        int max = 1;
        
        
        for(int i = 1; i < intervals.length; i++) {
            cell[i] = 1;
            for(int j = i - 1; j >= 0; j--) {
                if(!check(intervals[i], intervals[j])) {
                    cell[i] = cell[i] > (1 + cell[j]) ? cell[i] : (1 + cell[j]);
                    max = max > cell[i] ? max : cell[i];
                }
            }
        }
        return intervals.length - max;
    }
    
    private boolean check(int[] a, int[] b) {
        int min = Math.max(a[0], b[0]);
        int max = Math.min(a[1], b[1]);
        
        return min < max;
    }
}
