package com.yl.learn.algorithm.r20210111;

public class SixNine {
    
    public int mySqrt(int x) {
        int start = 1, end = x;
        while (start < end) {
            long middle = (start + end) / 2;
            if(x / middle == middle) return (int) middle;
            else if(middle > x / middle) end = (int) (middle - 1);
            else start = (int) (middle + 1);
        }
        return start > x / start ? start - 1 : start;
    }
    
}
