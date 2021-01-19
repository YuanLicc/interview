package com.yl.learn.algorithm.r20210111;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TwoZero {
    
    private Map<Character, Character> cMap = new HashMap<Character, Character>() {{
        put(']', '[');
        put(')', '(');
        put('}', '{');
    }};
    
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char sC = stack.pop();
                if (!cMap.get(c).equals(sC)) return false;
            }
        }
        return stack.isEmpty();
    }
    
}
