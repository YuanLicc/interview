package com.yl.learn.algorithm.yuanfudao;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 上图为 8 皇后问题的一种解法。
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 *
 * 示例:
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *
 * 来源：力扣（LeetCode）52
 * 链接：https://leetcode-cn.com/problems/n-queens-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TotalNQueens {

    int cnt = 0;

    public int totalNQueens(int n) {
        if(n == 1) return 1;
        if(n <= 3) return 0;

        boolean[][] cell = new boolean[n][n];
        dfs(cell, 1, n);
        return cnt;
    }

    private void dfs(boolean[][] cell, int qNum, int n) {
        if(qNum > n) {
            cnt++;
            return;
        }

        for(int i = 0; i < cell.length; i++) {
            if(check(cell, qNum, i)) {
                boolean[][] cp = copy(cell, qNum);
                cp[qNum - 1][i] = true;
                dfs(cp, qNum + 1, n);
            }
        }
    }

    private boolean check(boolean[][] cell, int qNum, int i) {
        int row = qNum - 1;
        while(row >= 0) {
            if(cell[row][i]) return false;
            row--;
        }
        row = qNum - 1;
        int column = i;
        while(row >= 0 && column >= 0) {
            if(cell[row][column]) return false;
            row--;
            column--;
        }
        row = qNum - 1;
        column = i;
        while(row >= 0 && column < cell.length) {
            if(cell[row][column]) return false;
            row--;
            column++;
        }
        return true;
    }

    private boolean[][] copy(boolean[][] cell, int qNum) {
        boolean[][] rs = new boolean[cell.length][cell.length];

        for(int i = 0; i < qNum; i++) {
            for(int j = 0; j < cell.length; j++) {
                rs[i][j] = cell[i][j];
            }
        }

        return rs;
    }

}
