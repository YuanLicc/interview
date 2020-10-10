package com.yl.learn.algorithm.alibaba;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 *  
 *
 * 示例：
 *
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *  
 *
 * 提示：
 *
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *
 *
 * 来源：力扣（LeetCode）557
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseWords3 {
    
    public String reverseWords(String s) {
        int i = 0;
        char[] chars = s.toCharArray();
        while (i < s.length()) {
            int end = i;
            while (end < s.length() && s.charAt(end) != ' ') {
                end++;
            }
            reverse(chars, i, end - 1);
            while (end < s.length() && s.charAt(end) == ' ') end++;
            i = end;
        }
        return new String(chars);
    }
    
    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
