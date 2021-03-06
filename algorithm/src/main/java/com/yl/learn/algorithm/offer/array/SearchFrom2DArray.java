package com.yl.learn.algorithm.offer.array;

/**
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 例如下面的二维数组就是每行、每列都递增排序。如果在这个数组中查找数字 7，则返回true；
 * 如果查找数字5，由于数组不含有该数字，则返回false。
 *
 * 1 2 8 9
 * 2 4 9 12
 * 4 7 10 13
 * 6 8 11 15
 *
 */
public class SearchFrom2DArray {

    public static boolean search(int[][] cell, int aim) {

        if(cell == null || cell.length == 0 || cell[0].length == 0) {
            return false;
        }

        int startRow = cell.length - 1;
        int startColumn = 0;

        while(startRow >= 0 && startColumn < cell[0].length) {

            int current = cell[startRow][startColumn];

            if(current == aim) {
                return true;
            }
            else if(current > aim) {
                startRow = startRow - 1;
            }
            else {
                startColumn = startColumn + 1;
            }
        }

        return false;
    }

}
