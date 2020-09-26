package com.yl.learn.algorithm.yuanfudao;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 示例:
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * 来源：力扣（LeetCode）59
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GenerateMatrix extends TestCase {

    public int[][] generateMatrix(int n) {
        if(n <= 0) return new int[0][];

        int num = 1;
        int[][] rs = new int[n][n];
        for(int i = 0; i < n / 2; i++) {
            int column = i;
            int row = i;
            int max = n - i - 1;
            while(column <= n - i - 1) rs[row][column++] = num++;
            column = max;
            row = i + 1;
            while (row <= n - i - 1) rs[row++][column] = num++;
            row = max;
            column = max - 1;
            while (column >=  i) rs[row][column--] = num++;
            row = max - 1;
            column = i;
            while (row > i) rs[row--][column] = num++;
        }
        if(n % 2 == 1) rs[n / 2][n / 2] = n * n;
        return rs;
    }

    public void test() {
        PrintUtil.printlnArray(generateMatrix(1));
    }
}
