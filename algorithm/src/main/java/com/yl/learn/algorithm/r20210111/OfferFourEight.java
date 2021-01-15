package com.yl.learn.algorithm.r20210111;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

public class OfferFourEight extends TestCase {
    // 12312311
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> ci = new HashMap<>();
        
        int max = 0;
        int len = 0;
        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i);
            Integer get = ci.get(c);
            
            if(get == null) {
                ci.put(c, i);
                len++;
                i++;
                continue;
            }
            
            max = max > len ? max : len;
            len = 0;
            ci = new HashMap<>();
            i = get + 1;
        }
        
        return len > max ? len : max;
    }
    
    public void test() {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }
    
}
