package com.yl.learn.interview.algorithm.string;

public class Reverse {

    public static String reverse(String src) {
        if(src == null || src.length() == 0) return null;

        String re = new String();

        int length = src.length() - 1;
        for(int i = length; i >= 0; i--) {
            re += src.charAt(i);
        }
        return re;
    }

}
