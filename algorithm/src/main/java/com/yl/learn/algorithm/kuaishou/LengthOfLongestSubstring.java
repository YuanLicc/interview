package com.yl.learn.algorithm.kuaishou;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 来源：力扣（LeetCode）3
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLongestSubstring {
    
    public int lengthOfLongestSubstring(String s) {
        if(s == null) return 0;
        if(s.length() <= 1) return s.length();
        Map<Character, Integer> cIndexMap = new HashMap<>();
        cIndexMap.put(s.charAt(0), 0);
        int minIndex = 0;
        int max = 1;
        for(int i = 1; i < s.length(); i++) {
            char curChar = s.charAt(i);
            Integer get = cIndexMap.get(curChar);
            if(get == null || (get != null && get < minIndex)) {
                cIndexMap.put(curChar, i);
                max = max > (i - minIndex + 1) ? max : (i - minIndex + 1);
            }
            else {
                minIndex = cIndexMap.get(curChar) + 1;
                cIndexMap.put(curChar, i);
            }
        }
        return max;
    }
    
}
