package com.yl.learn.algorithm.bytedance;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

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
public class LengthOfLongestSubstring extends TestCase {
    
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int max = 0;
        int start = 0;
        Map<Character, Integer> win = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(win.get(c) != null) {
                int ind = win.get(c) + 1;
                start = ind > start ? ind : start;
            }
            win.put(c, i);
            max = i - start + 1 > max ? i - start + 1 : max;
        }
        return max;
    }
    
    public void test() {
        PrintUtil.println(lengthOfLongestSubstring("abba"));
        PrintUtil.println(lengthOfLongestSubstring("a"));
    }
}
