package com.yl.learn.algorithm.kuaishou;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 *
 * 来源：力扣（LeetCode）offer 12
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoDArrayExists {

    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    is = false;
                    dfs(board, word, 0, i , j, new boolean[board.length][board[i].length]);
                    if(is) return true;
                }
            }
        }
        return false;
    }
    boolean is = false;
    private boolean dfs(char[][] board, String word, int index, int i, int j, boolean[][] cache) {
        if(index >= word.length()) {is = true; return true;}
        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || (cache[i][j])) return false;
        if(board[i][j] == word.charAt(index)) cache[i][j] = true;
        else return false;
        if(dfs(board, word, index + 1, i - 1, j, copy(cache))) return true;
        if(dfs(board, word, index + 1, i + 1, j, copy(cache))) return true;
        if(dfs(board, word, index + 1, i, j - 1, copy(cache))) return true;
        return dfs(board, word, index + 1, i, j + 1, copy(cache));
    }

    private boolean[][] copy(boolean[][] cache) {
        boolean[][] copied = new boolean[cache.length][cache[0].length];
        for(int i = 0; i < cache.length; i++) {
            for(int j = 0; j < cache[i].length; j++) {
                if(cache[i][j]) copied[i][j] = true;
            }
        }
        return copied;
    }
}
