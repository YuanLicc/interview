package com.yl.learn.algorithm.bytedance;

import junit.framework.TestCase;

import java.util.Arrays;

/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * 示例 1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 * 示例 2:
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 * 来源：力扣（LeetCode）offer 61
 * 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PokeIsStraight extends TestCase {
    
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zerCnt = 0;
        int nCnt = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                zerCnt++;
                continue;
            }
            if(nCnt != 0) {
                if(nums[i] == nums[i - 1]) return false;
                if(nums[i] - nums[i - 1] != 1) {
                    if(zerCnt <= 0) return false;
                    zerCnt -= nums[i] - nums[i - 1] - 1;
                }
            }
            nCnt++;
        }
        return zerCnt >= 0;
    }
    
    public void test() {
        isStraight(new int[]{4, 7, 5, 9, 2});
    }
}
