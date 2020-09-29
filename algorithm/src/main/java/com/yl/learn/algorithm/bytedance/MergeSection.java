package com.yl.learn.algorithm.bytedance;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 示例 1:
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 来源：力扣（LeetCode）56
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeSection extends TestCase {

    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(item -> item[0]));
        List<int[]> rs = new ArrayList<>();
        for(int i = 0; i < intervals.length - 1; i++) {
            if(chechAndMerge(intervals[i], intervals[i + 1])) {
            }
            else rs.add(intervals[i]);
        }
        rs.add(intervals[intervals.length - 1]);
        return rs.toArray(new int[rs.size()][2]);
    }

    private boolean chechAndMerge(int[] interval, int[] interval1) {
        int min = Math.max(interval[0], interval1[0]);
        int max = Math.min(interval[1], interval1[1]);
        if(min <= max) {
            interval1[0] = Math.min(interval[0], interval1[0]);
            interval1[1] = Math.max(interval[1], interval1[1]);
            interval[0] = interval[1] + 1;
            return true;
        }
        return false;
    }

    public void test() {

    }

}
