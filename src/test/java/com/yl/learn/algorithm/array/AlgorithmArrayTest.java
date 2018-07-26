package com.yl.learn.algorithm.array;

import junit.framework.TestCase;

public class AlgorithmArrayTest extends TestCase {

    public void testOne() {
        int[][] oneCaseOne = {{1,2,8,9},{2,4,9,12}, {4,7,10,13},{6,8,11,15}};

        System.out.println(One.find(7, oneCaseOne));
        System.out.println(One.find(15, oneCaseOne));

        // 解决
        System.out.println(One.solution(7, oneCaseOne));
        System.out.println(One.solution(15, oneCaseOne));
    }

    public void testTwo() {
        System.out.println(Two.replaceStr(new StringBuffer("We Are "), "%20"));

        System.out.println(Two.replaceSpace(new StringBuffer("We Are "), "%20"));
    }
}
