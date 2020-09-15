package com.yl.learn.algorithm.yuanfudao;

import junit.framework.TestCase;

public class FindDiagonalOrder extends TestCase {

    public int[] findDiagonalOrder(int[][] matrix) {

        if(matrix == null || matrix.length == 0) return new int[0];

        int[] rs = new int[matrix.length * matrix[0].length];
        int index = 0;

        if(matrix.length == 1 || matrix[0].length == 1) {
            for(int i = 0; i < matrix.length; i++) {
                for(int j = 0; j < matrix[i].length; j++) {
                    rs[index++] = matrix[i][j];
                }
            }
            return rs;
        }
        int i = 0;
        int j = 0;
        rs[0] = matrix[0][0];
        index = 1;

        int cn = 1;
        while(index < rs.length) {
            if(j == 0 && i < matrix[0].length && cn % 2 == 1) {
                i++;
                while(i >= 0 && j < matrix.length) {
                    rs[index++] = matrix[j][i];
                    j++;
                    i--;
                }
                j--;
                i++;
                cn++;
            }
            else if(i == 0 && j < matrix.length - 1 && cn % 2 == 0) {
                j++;
                while(j >= 0 && i < matrix[0].length) {
                    rs[index++] = matrix[j][i];
                    j--;
                    i++;
                }
                j++;
                i--;
            }
            else if(i == matrix[0].length - 1) {
                j++;
                while(j < matrix.length && i >= 0) {
                    rs[index++] = matrix[j][i];
                    j++;
                    i--;
                }
                i++;
                j--;
            }
            else {
                i++;
                while(i < matrix[0].length && j > 0) {
                    rs[index++] = matrix[j][i];
                    i++;
                    j--;
                }
                i--;
                j++;
            }
        }
        return rs;
    }

    public void test() {
        int [][] a = new int[][]{
                { 1, 2, 1},
                { 3, 4, 2}
        };

        findDiagonalOrder(a);
    }
}
