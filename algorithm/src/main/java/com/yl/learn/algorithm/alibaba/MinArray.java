package com.yl.learn.algorithm.alibaba;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 * 来源：力扣（LeetCode）offer 11
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinArray {
    // 输入：[3,4,5,1,2]
    // 输出：1
    public int minArray(int[] numbers) {
        if(numbers.length == 1) return numbers[0];
        int start = 0;
        int end = numbers.length - 1;
        int min = Integer.MAX_VALUE;

        while (start <= end) {
            int middle = (start + end) / 2;
            if(numbers[middle] > numbers[start]) {
                min = min < numbers[start] ? min : numbers[start];
                start = middle + 1;
            }
            else if(numbers[middle] < numbers[end]) {
                min = min > numbers[middle] ? numbers[middle] : min;
                end = middle - 1;
            }
            else {
                min = min < numbers[start] ? min : numbers[start];
                min = min < numbers[end] ? min : numbers[end];
                start++;
                end--;
            }
        }
        return min;
    }
}
