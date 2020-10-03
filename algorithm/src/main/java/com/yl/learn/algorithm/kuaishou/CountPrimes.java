package com.yl.learn.algorithm.kuaishou;

import junit.framework.TestCase;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例 1：
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 * 输入：n = 1
 * 输出：0
 *  
 *
 * 提示：
 *
 * 0 <= n <= 5 * 106
 *
 * 来源：力扣（LeetCode）204
 * 链接：https://leetcode-cn.com/problems/count-primes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountPrimes extends TestCase {

    public int countPrimes(int n) {
        if(n <= 1) return 0;
        boolean cell[] = new boolean[n - 1];
        int cnt = 0;
        for(int i = 0; i < cell.length - 1; i++) {
            if(cell[i]) continue;
            else cnt++;
            for(int j = 2 * i + 2; j < cell.length; j += (i + 2)) {
                cell[j] = true;
            }
        }
        return cnt;
    }

    public void test() {
        countPrimes(499979);
    }
}
