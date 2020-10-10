package com.yl.learn.algorithm.alibaba;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 * 来源：力扣（LeetCode）350
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Intersect {
    // 输入：nums1 = [1,2,2,1], nums2 = [2,2]
    // 输出：[2,2]
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] min = nums1.length <= nums2.length ? nums1 : nums2;
        int[] max = nums1.length > nums2.length ? nums1 : nums2;
        Map<Integer, Integer> map = new HashMap<>(min.length);
        for(int i = 0; i < min.length; i++) {
            Integer get = map.get(min[i]);
            if(get == null) map.put(min[i], 1);
            else map.put(min[i], get + 1);
        }
        List<Integer> rr = new ArrayList<>(map.size());
        for(int i = 0; i < max.length; i++) {
            Integer get = map.get(max[i]);
            if(get != null) {
                rr.add(max[i]);
                get--;
                if (get == 0) map.remove(max[i]);
                else map.put(max[i], get);
            }
        }
        int[] rs = new int[rr.size()];
        for(int i = 0; i < rr.size(); i++) rs[i] = rr.get(i);
        return rs;
    }
}
