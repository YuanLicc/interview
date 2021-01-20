package com.yl.learn.algorithm.r20210111;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

import java.util.LinkedList;
import java.util.List;

public class NineThree extends TestCase {
    
    public List<String> restoreIpAddresses(String s) {
        dfs(s.toCharArray(), new char[0], 0, 0);
        return rs;
    }
    
    private List<String> rs = new LinkedList<>();
    
    private void dfs(char[] chars, char[] prefix, int index, int num) {
        if(num == 4 && index == chars.length) {
            rs.add(new String(prefix, 1, prefix.length - 1));
            return;
        }
        if(num == 4 || index >= chars.length) return;
        
        if(chars[index] == '0') {
            dfs(chars, copy(prefix, chars, index, index), index + 1, num + 1);
            return;
        }
        
        for (int i = 0; i < 3 && (index + i) < chars.length; i++) {
            if(check(chars, index, i + index)) {
                dfs(chars, copy(prefix, chars, index, index + i), index + i + 1, num + 1);
            }
        }
    }
    
    private char[] copy(char[] prefix, char[] chars, int start, int end) {
        char[] rs = new char[prefix.length + end - start + 2];
        System.arraycopy(prefix, 0, rs, 0, prefix.length);
        rs[prefix.length] = '.';
        System.arraycopy(chars, start, rs, prefix.length + 1, end - start + 1);
        return rs;
    }
    
    private boolean check(char[] chars, int start, int end) {
        int num = 0;
        while (start <= end) num = num * 10 + (chars[start++] - '0');
        return num >= 0 && num <= 255;
    }
    
    public void test() {
        PrintUtil.println(restoreIpAddresses("101023"));
    }
    
}
