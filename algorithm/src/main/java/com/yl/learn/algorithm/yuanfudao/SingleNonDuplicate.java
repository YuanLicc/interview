package com.yl.learn.algorithm.yuanfudao;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

/**
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,3,7,7,10,11,11]
 * 输出: 10
 * 注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。
 *
 * 来源：力扣（LeetCode）540
 * 链接：https://leetcode-cn.com/problems/single-element-in-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SingleNonDuplicate extends TestCase {
    public int singleNonDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            if(start < nums.length - 1 && nums[start] != nums[start + 1]) return nums[start];
            if(end > 0 && nums[end - 1] != nums[end]) return nums[end];
        
            int middle = (start + end) / 2;
            if(middle == 0 || middle == nums.length - 1) return nums[middle];
        
            if(nums[middle] == nums[middle - 1]) {
                if((middle - start + 1) % 2 == 1) {
                    end = middle - 2;
                }
                else {
                    start = middle + 1;
                }
            }
            else if(nums[middle] == nums[middle + 1]) {
                if((end - middle + 1) % 2 == 1) {
                    start = middle + 2;
                }
                else {
                    end = middle - 1;
                }
            }
            else return nums[middle];
        }
    
        return -1;
    }
    
    public void test() {
        PrintUtil.println(singleNonDuplicate(new int[]{1, 2, 2}));
        PrintUtil.println(singleNonDuplicate(new int[]{1, 1, 2}));
        PrintUtil.println(singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
        PrintUtil.println(singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
    }
}
