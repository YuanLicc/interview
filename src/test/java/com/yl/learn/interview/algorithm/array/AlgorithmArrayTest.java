package com.yl.learn.interview.algorithm.array;

import com.yl.learn.interview.util.PrintUtil;
import com.yl.learn.interview.util.Timer;
import junit.framework.TestCase;

public class AlgorithmArrayTest extends TestCase {

    String delimiter = ", 使用时间：";
    String prefix = "结果：";
    String suffix = " 纳秒";

    public void testOne() {
        int[][] oneCaseOne = {{1,2,8,9},{2,4,9,12}, {4,7,10,13},{6,8,11,15}};

        Timer oneTimer = Timer.start();
        PrintUtil.printlnWithNaoTime(One.find(7, oneCaseOne)
                , oneTimer, prefix, delimiter, suffix);

        oneTimer.reset();
        PrintUtil.printlnWithNaoTime(One.find(15, oneCaseOne)
                , oneTimer, prefix, delimiter, suffix);

        // 解决
        oneTimer.reset();
        PrintUtil.printlnWithNaoTime(One.solution(7, oneCaseOne)
                , oneTimer, prefix, delimiter, suffix);

        oneTimer.reset();
        PrintUtil.printlnWithNaoTime(One.solution(15, oneCaseOne)
                , oneTimer, prefix, delimiter, suffix);
    }

    public void testTwo() {
        Timer timer = Timer.start();

        PrintUtil.printlnWithNaoTime(Two.replaceStr(new StringBuffer("We Are "), "%20")
                , timer, prefix, delimiter, suffix);

        timer.reset();
        PrintUtil.printlnWithNaoTime(Two.replaceSpace(new StringBuffer("We Are "), "%20")
                , timer, prefix, delimiter, suffix);

        timer.reset();
        PrintUtil.printlnWithNaoTime(Two.solution(new StringBuffer("We Are "))
                , timer, prefix, delimiter, suffix);

    }
}
