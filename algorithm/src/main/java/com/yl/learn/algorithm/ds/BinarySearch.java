package com.yl.learn.algorithm.ds;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

public class BinarySearch extends TestCase {
    
    public int binarySearch(int[] sortedArr, int value) {
        
        if(sortedArr == null || sortedArr.length == 0) {
            return -1;
        }
        
        int start = 0;
        int end = sortedArr.length - 1;
        
        while(start < end) {
            int middle = (start + end) / 2;
            
            if(sortedArr[middle] == value) {
                return middle;
            }
            else if(value > sortedArr[middle]) {
                start = middle + 1;
            }
            else {
                end = middle - 1;
            }
        }
        
        return sortedArr[start] == value ? start : -1;
    }
    
    public void testArr() {
        int[] testArr1 = new int[] {1, 2, 3, 4, 5, 6, 7};
        PrintUtil.template("binary search sorted array: 1, 2, 3, 4, 5, 6, 7 key 2", () -> PrintUtil.println(binarySearch(testArr1, 2)));
        PrintUtil.template("binary search sorted array: 1, 2, 3, 4, 5, 6, 7 key 1", () -> PrintUtil.println(binarySearch(testArr1, 1)));
        PrintUtil.template("binary search sorted array: 1, 2, 3, 4, 5, 6, 7 key 5", () -> PrintUtil.println(binarySearch(testArr1, 5)));
        PrintUtil.template("binary search sorted array: 1, 2, 3, 4, 5, 6, 7 key 7", () -> PrintUtil.println(binarySearch(testArr1, 7)));
        PrintUtil.template("binary search sorted array: 1, 2, 3, 4, 5, 6, 7 key -1", () -> PrintUtil.println(binarySearch(testArr1, -1)));
        PrintUtil.template("binary search sorted array: 1, 2, 3, 4, 5, 6, 7 key 8", () -> PrintUtil.println(binarySearch(testArr1, 8)));
    }
}
