package com.yl.learn.algorithm.r20210111;

import junit.framework.TestCase;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *  初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 有足够的空间（空间大小等于 m + n）来保存 nums2 中的元素。
 *
 *  示例 1：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 *
 *  示例 2：
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *
 *  提示：
 *  0 <= n, m <= 200
 *  1 <= n + m <= 200
 *  nums1.length == m + n
 *  nums2.length == n
 *  -109 <= nums1[i], nums2[i] <= 109
 *
 *  Related Topics 数组 双指针
 */
public class EightEight extends TestCase {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        
        int index = nums1.length - 1;
        m--;
        n--;
        
        while (index >= 0) {
            if(m >= 0 && n >= 0) {
                if(nums1[m] >= nums2[n]) nums1[index--] = nums1[m--];
                else nums1[index--] = nums2[n--];
            }
            else if(m >= 0) {
                nums1[index--] = nums1[m--];
            }
            else {
                nums1[index--] = nums2[n--];
            }
        }
    }
}
