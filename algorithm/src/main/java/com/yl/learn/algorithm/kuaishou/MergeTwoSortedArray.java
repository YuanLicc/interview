package com.yl.learn.algorithm.kuaishou;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 来源：力扣（LeetCode）88
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;
        int index = m + n - 1;
        while (m >= 1 && n >= 1) {
            if(nums1[m - 1] > nums2[n - 1]) {
                nums1[index--] = nums1[m - 1];
                m--;
            }
            else {
                nums1[index--] = nums2[n - 1];
                n--;
            }
        }
        while(n >= 1) {
            nums1[index--] = nums2[n - 1];
            n--;
        }
    }

}
