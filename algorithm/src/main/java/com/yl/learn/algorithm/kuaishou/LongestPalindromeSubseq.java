package com.yl.learn.algorithm.kuaishou;

/**
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 *
 * 示例 1:
 * 输入:
 *
 * "bbbab"
 * 输出:
 *
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 *
 * 示例 2:
 * 输入:
 *
 * "cbbd"
 * 输出:
 *
 * 2
 * 一个可能的最长回文子序列为 "bb"。
 *
 * 来源：力扣（LeetCode）516
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindromeSubseq {

    public int longestPalindromeSubseq(String s) {

        int p[][] = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) p[i][i] = 1;

        for(int i = 1; i < s.length(); i++) {
            for(int j = 0; (i + j) < s.length(); j++) {
                if(s.charAt(j) == s.charAt(i + j)) {
                    p[j][i + j] = p[j + 1][i + j - 1] + 2;
                }
                else p[j][i + j] = Math.max(p[j + 1][i + j], p[j][i + j - 1]);
            }
        }
        return p[0][s.length() - 1];
    }
}
