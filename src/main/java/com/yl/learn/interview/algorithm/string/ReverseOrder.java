package com.yl.learn.interview.algorithm.string;

public class ReverseOrder {

    public static boolean isReverseOrder(String source) {

        if(source == null) return false;

        int maxIndex = source.length() - 1;

        if(source.length() == 0) return true;

        for(int i = (maxIndex) >> 1; i >= 0; i--) {
            if(source.charAt(i) != source.charAt(maxIndex - i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isReverseOrder_buffer(String source) {
        if(source == null) return false;

        if(source.length() == 0) return true;

        StringBuffer re = new StringBuffer(source).reverse();

        if(re.toString().equals(source)) {
            return true;
        }
        return false;
    }

}
