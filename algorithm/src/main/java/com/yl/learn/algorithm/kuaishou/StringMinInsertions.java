package com.yl.learn.algorithm.kuaishou;

/**
 * 给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。
 * 请你返回让 s 成为回文串的 最少操作次数 。
 * 「回文串」是正读和反读都相同的字符串。
 *
 * 示例 1：
 * 输入：s = "zzazz"
 * 输出：0
 * 解释：字符串 "zzazz" 已经是回文串了，所以不需要做任何插入操作。
 * 示例 2：
 *
 * 输入：s = "mbadm"
 * 输出：2
 * 解释：字符串可变为 "mbdadbm" 或者 "mdbabdm" 。
 *
 * 来源：力扣（LeetCode）1312
 * 链接：https://leetcode-cn.com/problems/minimum-insertion-steps-to-make-a-string-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StringMinInsertions {

    public int minInsertions(String s) {
        int p[][] = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) p[i][i] = 0;
        for(int i = 1; i < s.length(); i++) {
            for(int j = 0; (i + j) < s.length(); j++) {
                if(s.charAt(j) == s.charAt(i + j)) {
                    p[j][i + j] = p[j + 1][i + j - 1];
                }
                else {
                    p[j][i + j] = Math.min(p[j + 1][i + j], p[j][i + j - 1]) + 1;
                }
            }
        }
        return p[0][s.length() - 1];
    }
}
