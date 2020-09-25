package com.yl.learn.algorithm.yuanfudao;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 * 来源：力扣（LeetCode）48
 * 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MatrixRotate extends TestCase {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length <= 1) return;
        for(int i = 0; i < matrix.length / 2; i++) {
            int start = i;
            int end = matrix.length - i - 1;
            while(start < end) {
                int up = matrix[i][start]; // 距离左侧 = start - i;
                matrix[i][start] = matrix[end - (start - i)][i]; // 距离下侧 = start - i
                matrix[end - (start - i)][i] = matrix[end][end - (start - i)]; // 距离右侧 = start - i
                matrix[end][end - (start - i)] = matrix[i + (start - i)][end];
                matrix[i + (start - i)][end] = up;
                start++;
            }
        }
    }
    
    public void test() {
        int[][] mat = new int[][]{
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}
        };
        rotate(mat);
        PrintUtil.printlnArray(mat);
    }
}
