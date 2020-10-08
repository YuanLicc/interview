package com.yl.learn.algorithm.suiji;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"
 *
 * 来源：力扣（LeetCode）60
 * 链接：https://leetcode-cn.com/problems/permutation-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GetPermutation {

    public String getPermutation(int n, int k) {
        char[] rs = new char[n];
        for(int i = 0; i < n; i++) rs[i] = (char)('1' + i);
        k--;
        while (k > 0) {
            int i = rs.length - 2;
            while (rs[i] < rs[i + 1]) i++;
            int j = rs.length - 1;
            while (rs[i] > rs[j]) j++;
            char tmp = rs[i];
            rs[i] = rs[j];
            rs[j] = tmp;
            i++;
            j = rs.length - 1;
            while (i < j) {
                tmp = rs[i];
                rs[i] = rs[j];
                rs[j] = tmp;
                i++;
                j--;
            }
            k--;
        }
        return new String(rs);
    }
}
