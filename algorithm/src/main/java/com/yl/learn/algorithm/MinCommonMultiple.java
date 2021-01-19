package com.yl.learn.algorithm;

import com.yl.learn.util.util.PrintUtil;

/**
 * 最小公倍数
 */
public class MinCommonMultiple {


    /**
     * 利用最大公约数求值，最小公倍数 = num1 * num2 / 最大公约数
     * @param num1
     * @param num2
     * @return
     */
    public static int min(int num1, int num2) {

        int maxDivisor = MaxCommonDivisor.greatest(num1, num2);

        return num1 * num2 / maxDivisor;
    }

    public static void main(String[] args) {

        PrintUtil.println(min(20, 5));
    }
}
