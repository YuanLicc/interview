package com.yl.learn.algorithm.r20210111;


import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *  示例 1：
 *
 *  输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 *
 *
 *  示例 2：
 *
 *  输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *
 *
 *
 *  说明：
 *
 *
 *  输出结果中的每个元素一定是唯一的。
 *  我们可以不考虑输出结果的顺序。
 *
 *  Related Topics 排序 哈希表 双指针 二分查找
 */
public class ThreeFourNine extends TestCase {
    
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> cache = new HashMap<>(nums1.length);
        for (int num : nums1) cache.put(num, 1);
    
        int[] temp = new int[nums2.length];
        int size = 0;
        for (int num : nums2) {
            Integer get = cache.get(num);
            
            if(get != null && get == 1) {
                temp[size++] = num;
                cache.put(num, 2);
            }
        }
        
        int[] rs = new int[size];
        
        System.arraycopy(temp, 0, rs, 0, size);
        return rs;
    }
}
