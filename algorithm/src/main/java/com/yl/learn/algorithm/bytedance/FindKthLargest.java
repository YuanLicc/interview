package com.yl.learn.algorithm.bytedance;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

/**
 * 在未排序的数组中找到第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * 来源：力扣（LeetCode）215
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindKthLargest extends TestCase {
    
    public int findKthLargest(int[] nums, int k) {
        
        int pIndex = 0;
        int endI = nums.length - 1;
        while (true) {
            int index = partition(nums, pIndex, endI);
            if(index + 1 == k) return nums[index];
            if(index + 1 > k) {
                endI = index - 1;
            }
            else {
                pIndex = index + 1;
            }
        }
    }
    
    private int partition(int[] nums, int pIndex, int endI) {
        int pTmp = nums[pIndex];
        
        while (pIndex < endI) {
            while (endI > pIndex && nums[endI] < pTmp){
                endI--;
            }
            if(endI > pIndex) {
                nums[pIndex++] = nums[endI];
            }
            while (pIndex < endI && nums[pIndex] >= pTmp) {
                pIndex++;
            }
            if(pIndex < endI) nums[endI--] = nums[pIndex];
        }
        nums[pIndex] = pTmp;
        return pIndex;
    }
    
    public void test() {
        PrintUtil.println(findKthLargest(new int[]{1, 2, 3, 4}, 2));
    }
    
}
