package com.yl.learn.algorithm.r20210111;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

public class OneFiveOne extends TestCase {
    
    public String reverseWords(String s) {
        if(s == null || s.length() <= 1) return s;
        
        char[] sChars = s.toCharArray();
        reverse(sChars, 0, sChars.length - 1);
        
        int p1 = 0, p2 = 0;
        while (p2 < s.length()) {
            while (p2 < s.length() && sChars[p2] != ' ') {
                p2++;
            }
            reverse(sChars, p1, p2 - 1);
            while (p2 < s.length() && sChars[p2] == ' ') {
                p2++;
            }
            p1 = p2;
        }
        
        return trim(sChars);
    }
    
    private String trim(char[] chars) {
        int start = 0, end = chars.length - 1;
        while (start < chars.length && chars[start] == ' ') start++;
        while (end >= start && chars[end] == ' ') end--;
        
        StringBuilder sb = new StringBuilder(end - start + 1);
        
        while (start <= end) {
            if(chars[start] == ' ') {
                while (start <= end && chars[start] == ' ') start++;
                sb.append(' ');
            }
            else sb.append(chars[start++]);
        }
        return sb.toString();
    }
    
    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char tmp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = tmp;
        }
    }
    
    public void test() {
        PrintUtil.println(reverseWords("a is b csdcasd casdsc!"));
    }
}
