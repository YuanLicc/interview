package com.yl.learn.algorithm.r20210111;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

public class Three extends TestCase {
    
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        Map<Character, Integer> window = new HashMap<>(s.length());
        int max = 1;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer get = window.get(s.charAt(i));
            if(get == null || get < start) {
                window.put(s.charAt(i), i);
                int len = i - start + 1;
                max = max > len ? max :len;
            }
            else {
                int len = i - get;
                max = max > len ? max : len;
                start = get + 1;
                window.put(s.charAt(i), i);
            }
        }
        return max;
    }
    
    public void test() {
        PrintUtil.println(lengthOfLongestSubstring("tmmzuxt"));
    }
    
}
