package com.yl.learn.algorithm.yuanfudao;

import junit.framework.TestCase;

/**
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * 来源：力扣（LeetCode）130
 * 链接：https://leetcode-cn.com/problems/surrounded-regions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OXSolve extends TestCase {

    public void solve(char[][] board) {
        if(board == null || board.length <= 2) return;

        for(int i = 1; i < board.length - 1; i++) {
            for(int j = 1; j < board[i].length - 1; j++) {
                if(board[i][j] == 'O') {
                    boolean is = dfs(board, i, j, 'O', 'K');
                    if(is) dfs(board, i, j, 'K', 'X');
                    else dfs(board, i, j, 'K', 'O');
                }
            }
        }

        for(int i = 1; i < board.length - 1; i++) {
            for(int j = 1; j < board[i].length - 1; j++) {
                if(board[i][j] == 'K') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private boolean dfs(char[][] board, int i, int j, char aim, char set) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;

        if(board[i][j] == aim) {
            board[i][j] = set;
            return dfs(board, i, j - 1, aim, set) &&
                    dfs(board, i - 1, j, aim, set) &&
                    dfs(board, i, j + 1, aim, set) &&
                    dfs(board, i + 1, j, aim, set);
        }
        return true;
    }

    public void test() {
        solve(new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}});
    }

}
