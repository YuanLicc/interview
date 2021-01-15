package com.yl.learn.algorithm.r20210111;

public class OfferOneOne {
    
    // [10,1,10,10,10]
    public int minArray(int[] numbers) {
        if(numbers.length == 1) return numbers[0];
        int start = 0, end = numbers.length - 1;
        int min = Integer.MAX_VALUE;
    
        while (start <= end) {
            int middle = (start + end) / 2;
            if(numbers[middle] > numbers[start]) {
                min = min < numbers[start] ? min : numbers[start];
                start = middle + 1;
            }
            else if(numbers[middle] < numbers[end]) {
                min = min > numbers[middle] ? numbers[middle] : min;
                end = middle - 1;
            }
            else {
                min = min < numbers[start] ? min : numbers[start];
                min = min < numbers[end] ? min : numbers[end];
                start++;
                end--;
            }
        }
        return min;
    }
    
}
