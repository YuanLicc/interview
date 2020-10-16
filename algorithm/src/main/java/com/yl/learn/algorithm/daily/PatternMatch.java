package com.yl.learn.algorithm.daily;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

public class PatternMatch extends TestCase {

    public boolean isMatch(String s, String p) {
        if(p.length() == 0 && s.length() != 0) return false;
        if(p.length() == 0 && s.length() == 0) return true;

        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        if(!init(dp, p)) return false;

        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[i].length; j++) {
                char sC = s.charAt(j - 1);
                char pC = p.charAt(i - 1);
                if(dp[i - 1][j - 1] && (sC == pC || pC == '.' || (pC == '*' && sC == s.charAt(j - 2)) || (pC == '*' && j > 1 && s.charAt(j - 2) == pC))) dp[i][j] = true;
                else if(i > 1 && dp[i - 2][j] && pC == '*') dp[i][j] = true;
                else if(dp[i - 1][j] && pC == '*') dp[i][j] = true;
                else if(dp[i][j - 1] && pC == '*' && ((j > 1 && s.charAt(j - 2) == pC) || (i > 1 && p.charAt(i - 2) == '.'))) dp[i][j] = true;
            }
        }
        PrintUtil.printlnArray(dp);
        return dp[p.length()][s.length()];
    }

    private boolean init(boolean[][] dp, String p) {
        dp[0][0] = true;
        if(p.charAt(0) == '*') return false;
        boolean is = true;
        for(int i = 1; i < dp.length; i++) {
            char c = p.charAt(i - 1);
            if(is) {
                if(c == '*') {
                    char preC = p.charAt(i - 2);
                    if(preC == '*') return false;
                    dp[i][0] = true;
                }
                else {
                    if(i == dp.length - 1) break;
                    char nextC = p.charAt(i);
                    if(nextC != '*') is = false;
                }
            }
        }
        return true;
    }

    public void test() {
        isMatch("aaba", "ab*a*c*a");
    }

}
