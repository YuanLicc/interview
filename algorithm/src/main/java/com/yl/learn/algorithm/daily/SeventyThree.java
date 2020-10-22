package com.yl.learn.algorithm.daily;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 *
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * 进阶:
 *
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 *
 * 来源：力扣（LeetCode）73
 * 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SeventyThree {

    public void setZeroes(int[][] matrix) {
        int rowCnt = 0;
        for(int i = 0; i < matrix.length; i++) if(matrix[i][0] == 0) rowCnt++;
        int columnCnt = 0;
        for(int i = 0; i < matrix[0].length; i++) if(matrix[0][i] == 0) columnCnt++;
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; i++) if(matrix[i][0] == 0) dfs(matrix, i, false);
        for(int i = 1; i < matrix[0].length; i++) if(matrix[0][i] == 0) dfs(matrix, i, true);
        if(matrix[0][0] == 0) {
            dfs(matrix, 0, false);
            dfs(matrix, 0, true);
        }
        if(rowCnt > 0) dfs(matrix, 0, true);
        if(columnCnt > 0) dfs(matrix, 0, false);
    }

    private void dfs(int[][] matrix, int i, boolean column) {
        if(column) {
            for(int index = 0; index < matrix.length; index++) {
                matrix[index][i] = 0;
            }
        }
        else {
            for(int index = 0; index < matrix[i].length; index++) {
                matrix[i][index] = 0;
            }
        }
    }
}
