package com.yl.learn.algorithm.r20210111;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *  示例：
 *
 *  输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *
 *  提示：
 *
 *  在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *
 *  Related Topics 字符串
 */
public class FiveFiveSeven extends TestCase {
    public String reverseWords(String s) {
        char[] sChars = s.toCharArray();
        
        int start = 0;
        int end = 0;
        
        while (end < s.length()) {
            while (end < s.length() && sChars[end] != ' ') {
                end++;
            }
            
            if(end != start) {
                reverse(sChars, start, end - 1);
                
                while (end < s.length() && sChars[end] == ' ') {
                    end++;
                }
                start = end;
            }
        }
        
        return new String(sChars);
    }
    
    private void reverse(char[] s, int start, int end) {
        while (start <= end) {
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }
    
    public void test() {
        PrintUtil.println(reverseWords("Let's take LeetCode contest"));
    }
}

