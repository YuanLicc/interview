package com.yl.learn.algorithm.r20210111;

import junit.framework.TestCase;

public class Four extends TestCase {
    // 1,2,3 2,3,5,6
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        //如果数组A的长度大于等于数组B，则交换数组
        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int start = 0;
        int end = m;
        int mid = (m + n + 1) / 2;
        while (start <= end) {
            int i = (start + end) / 2;
            int j = mid - i;
            if (i < end && nums2[j - 1] > nums1[i]) {
                //i偏小了，需要右移
                start = i + 1;
            } else if (i > start && nums1[i - 1] > nums2[j]) {
                //i偏大了，需要左移
                end = i - 1;
            } else {
                //i刚好合适，或i已达到数组边界
                int maxLeft;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    //如果大数组的长度是奇数，中位数就是左半部分的最大值
                    return maxLeft;
                }
                int minRight;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums2[j], nums1[i]);
                }
                //如果大数组的长度是偶数，取左侧最大值和右侧最小值的平均
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0d;
    }
    
    private double find(int[] min, int[] max) {
        int len = min.length + max.length;
        int middle = len / 2;
        if(len % 2 == 1) return find(min, max, middle);
        else return (find(min, max, middle - 1) + find(min, max, middle)) / 2.0;
    }
    
    private int find(int[] min, int[] max, int index) {
        if(index < min.length) return min[index];
        else return max[index - min.length];
    }
    
    public void test() {
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
    }
    
}
