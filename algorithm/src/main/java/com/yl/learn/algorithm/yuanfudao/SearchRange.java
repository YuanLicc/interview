package com.yl.learn.algorithm.yuanfudao;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 *
 * 来源：力扣（LeetCode）34
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchRange extends TestCase {
    
    public int[] searchRange(int[] nums, int target) {
        return new int[]{find(nums, target, 0, nums.length - 1, true), find(nums, target, 0, nums.length - 1, false)};
    }
    
    private int find(int[] nums, int target, int start, int end, boolean min) {
        while(start <= end) {
            int middle = (start + end) / 2;
            if(min && nums[middle] == target && (middle == 0 || (middle > 0 && nums[middle - 1] != target))) return middle;
            if(!min && nums[middle] == target && (middle == nums.length - 1 || (middle < nums.length - 1 && nums[middle + 1] != target))) return middle;
            if(min) {
                if(nums[middle] >= target) {
                    end--;
                }
                else {
                    start++;
                }
            }
            else {
                if(nums[middle] <= target) {
                    start++;
                }
                else {
                    end--;
                }
            }
        }
        return -1;
    }
    
    public void test() {
        int[] a = new int[]{1, 2, 3, 4, 4, 4, 5, 5, 10};
        PrintUtil.printlnArray(searchRange(a, 0));
        PrintUtil.printlnArray(searchRange(a, 4));
        PrintUtil.printlnArray(searchRange(a, 5));
        PrintUtil.printlnArray(searchRange(a, 9));
        PrintUtil.printlnArray(searchRange(a, 11));
        PrintUtil.printlnArray(searchRange(new int[]{1}, 1));
    }
}
