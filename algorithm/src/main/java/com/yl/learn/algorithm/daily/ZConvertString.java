package com.yl.learn.algorithm.daily;

import junit.framework.TestCase;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * 示例 1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 来源：力扣（LeetCode）6
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZConvertString extends TestCase {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder sb = new StringBuilder(s.length());
        for(int i = 0;i < s.length() && i < numRows; i++) {
            int down = numRows - 1 - i;
            int up = i;
            int start = i;
            boolean isJ = down == 0 ? false : true;
            while(start < s.length()) {
                sb.append(s.charAt(start));
                if(isJ) {
                    start = start + down * 2;
                }
                else {
                    start = start + up * 2;
                }
                if(up == 0) isJ = true;
                else if(down == 0) isJ = false;
                else isJ = !isJ;
            }
        }
        return sb.toString();
    }
}
