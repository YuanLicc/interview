package com.yl.learn.util.util;

import junit.framework.TestCase;

public class SortUtil extends TestCase {
    
    public static <T extends Comparable<T>> void selectSort(T[] array) {
        if(array == null || array.length <= 1) return;
        
        int index = 0;
        while(index < array.length) {
            T min = array[index];
            int minIndex = index;
            for(int i = index + 1; i < array.length; i++) {
                if(array[i].compareTo(min) < 0) {
                    minIndex = i;
                    min = array[i];
                }
            }
            array[minIndex] = array[index];
            array[index] = min;
            index++;
        }
    }

    public static <T extends Comparable<T>> void insertSort(T[] array) {
        if(array == null || array.length <= 1) return;

        for(int i = 1; i < array.length; i++) {
            for(int j = i - 1; j >= 0; j--) {
                T cur = array[j];
                if(array[j + 1].compareTo(cur) < 0) {
                    T tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    public void testInsertSort() {
        Integer[] arr = new Integer[]{1, -1, 20, 10, 11, 33};
        insertSort(arr);
        PrintUtil.printlnArray(arr);
    }
    
    public void testSelectSort() {
        Integer[] arr = new Integer[]{1, -1, 20, 10, 11, 33};
        selectSort(arr);
        PrintUtil.printlnArray(arr);
    }
    
}
