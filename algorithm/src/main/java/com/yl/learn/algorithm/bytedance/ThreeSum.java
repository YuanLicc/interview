package com.yl.learn.algorithm.bytedance;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

import java.util.*;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）15
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSum extends TestCase {
    
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3) return new ArrayList<>(1);
        Arrays.sort(nums);
        List<List<Integer>> rs = new ArrayList<>();
        
        for(int i = 0; i < nums.length - 2;) {
            int curNum = nums[i];
            int leftIndex = i + 1;
            int rightIndex = nums.length - 1;
            
            while(leftIndex < rightIndex) {
                int sum = curNum + nums[leftIndex] + nums[rightIndex];
                if(sum == 0) {
                    List<Integer> item = new ArrayList<>(3);
                    item.add(nums[i]);
                    item.add(nums[leftIndex]);
                    item.add(nums[rightIndex]);
                    int leftNum = nums[leftIndex];
                    while(leftIndex <= rightIndex && leftNum == nums[leftIndex]) leftIndex++;
                    int rightNum = nums[rightIndex];
                    while(rightIndex >= leftIndex && rightNum == nums[rightIndex]) rightIndex--;
                    rs.add(item);
                }
                else if(sum > 0) {
                    rightIndex--;
                }
                else {
                    leftIndex++;
                }
            }
            while (i < nums.length && curNum == nums[i]) i++;
        }
        
        return rs;
    }
    
    public void test() {
        PrintUtil.printlnArray(threeSum(new int[]{0,0,0,0}).toArray());
    }

}
