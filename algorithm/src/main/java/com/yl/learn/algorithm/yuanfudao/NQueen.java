package com.yl.learn.algorithm.yuanfudao;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    
    public List<List<String>> solveNQueens(int n) {
        if(n <= 2) return null;
        
        int[][] cell = new int[n][n];
        
        List<List<String>> rs = new ArrayList<>();
        
        dfs(cell, rs, 1, n);
        
        return rs;
    }
    
    private void dfs(int[][] cell, List<List<String>> rs, int queen, int n) {
        
        if(queen > n) {
            //
        }
        
        for(int i = 0; i < n; i++) {
            if(queen == 1) {
                cell[queen - 1][i] = 1;
                dfs(cell, rs, queen + 1, n);
            }
            else {
                if(check(cell, queen - 1, i)) {
                    cell[queen - 1][i] = 1;
                    dfs(cell, rs, queen + 1, n);
                }
            }
        }
    }
    
    private boolean check(int[][] cell, int i, int j) {
        boolean is = false;
        if(i > 0 && j > 0) {
            is = cell[i - 1][j - 1] != 1;
        }
        if(i < cell.length - 1 && j > 0) {
            is = is && cell[i + 1][j - 1] != 1;
        }
        if(j > 0) {
            is = is && cell[i][j - 1] != 1;
        }
        
        return is;
    }
}
