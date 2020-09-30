package com.yl.learn.algorithm.kuaishou;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 *
 * 来源：力扣（LeetCode）151
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseWords {
    
    public String reverseWords(String s) {
        s = s.trim();
        char[] chars = s.toCharArray();
        int index = 0;
        for(int i = 1; i < s.length();i++) {
            if(i == s.length() - 1) {
                reverse(chars, index, i);
            }
            else if(chars[i] == ' ') {
                reverse(chars, index, i - 1);
                index = i + 1;
            }
        }
        reverse(chars, 0, s.length() - 1);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < chars.length;) {
            if(chars[i] == ' ') {
                int cnt = 0;
                while(chars[i] == ' ') {
                    if(cnt == 0) sb.append(' ');
                    i++;
                    cnt++;
                }
                continue;
            }
            else {
                sb.append(chars[i]);
                i++;
            }
        }
        return sb.toString();
    }
    
    private void reverse(char[] s, int start, int end) {
        if(start >= end) return;
        while (start < end) {
            char t = s[start];
            s[start] = s[end];
            s[end] = t;
            start++;
            end--;
        }
    }
    
}
