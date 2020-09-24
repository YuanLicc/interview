package com.yl.learn.algorithm.yuanfudao;



import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

import java.util.Arrays;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 * 示例 1:
 * 输入: [10,2]
 * 输出: "102"
 *
 * 示例 2:
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *
 * 来源：力扣（LeetCode）offer 45
 * 链接：https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof
 */
public class MinNumber extends TestCase {

    public String minNumber(int[] nums) {
        String[] numsStr = new String[nums.length];
        for(int i = 0; i < nums.length; i++) numsStr[i] = String.valueOf(nums[i]);

        Arrays.sort(numsStr, (str1, str2) -> {

            if(str1.equals(str2)) return 0;

            String s1 = str1 + str2;
            String s2 = str2 + str1;

            if(s1.compareTo(s2) < 0) return -1;
            else return 1;
        });

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < numsStr.length; i++) {
            sb.append(numsStr[i]);
        }

        return sb.toString();
    }
    public void test() {
        PrintUtil.println(minNumber(new int[]{1, 2, 3, 4, 5}));
        PrintUtil.println(minNumber(new int[]{3,30,34,5,9}));
        PrintUtil.println(minNumber(new int[]{10,2}));
        PrintUtil.println(minNumber(new int[]{2,10}));
    }

}
