package com.yl.learn.algorithm.sort.insert;

/**
 * 从第一个元素开始，该元素可以认为已经被排序；
 * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
 * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
 * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 * 将新元素插入到该位置后；
 * 重复步骤2~5。
 */
public class InsertSort {

    public static void sort(int[] sorted) {

        if(sorted == null || sorted.length <= 1) {
            return;
        }

        for(int i = 1; i < sorted.length; i++) {

            for(int j = i - 1; j >= 0; j--) {
                if(sorted[i] >= sorted[j]) {

                    int temp = sorted[i];

                    for(int k = i; k > j + 1; k--) {
                        sorted[k] = sorted[k - 1];
                    }

                    sorted[j + 1] = temp;
                    break;
                }
            }

        }

    }

}
