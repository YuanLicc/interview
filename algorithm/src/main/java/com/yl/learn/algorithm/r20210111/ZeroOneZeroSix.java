package com.yl.learn.algorithm.r20210111;

/**
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 * 比如，字符串aabcccccaaa会变为a2b1c5a3。
 * 若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 *
 * 示例1:
 *
 *  输入："aabcccccaaa"
 *  输出："a2b1c5a3"
 *
 */
public class ZeroOneZeroSix {
    
    public String compressString(String S) {
        StringBuilder sb = new StringBuilder();
        char[] chars = S.toCharArray();
        int i = 0;
        
        while (i < chars.length) {
            char c = chars[i];
            int cnt = 0;
            while (i < chars.length && c == chars[i]) {
                i++;
                cnt++;
            }
            sb.append(c).append(cnt);
        }
        
        return sb.length() >= S.length() ? S : sb.toString();
    }
    
}
