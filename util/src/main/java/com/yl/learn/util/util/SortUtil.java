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
    
    public void testSelectSort() {
        Integer[] arr = new Integer[]{1, -1, 20, 10, 11, 33};
        selectSort(arr);
        PrintUtil.printlnArray(arr);
    }
    
}
