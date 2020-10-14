package com.yl.learn.algorithm.alibaba;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * 示例 1:
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 *
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 *
 * 来源：力扣（LeetCode）268
 * 链接：https://leetcode-cn.com/problems/missing-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MissingNumber {
    
    public int missingNumberMap(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>(nums.length);
        for(int i = 0; i < nums.length; i++) map.put(nums[i], false);
        for(int i = 0; i <= nums.length; i++) {
            if(map.get(i) == null) return i;
        }
        return -1;
    }
    // 3,0,1
    public int missingNumber(int[] nums) {
        int zeroIndex = -1;
        for(int i = 0; i < nums.length; i++) {
            if(i + 1 == nums[i]) continue;
            if(nums[i] == 0) zeroIndex = i;
            else {
                while (i + 1 != nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[nums[i] - 1];
                    nums[temp - 1] = temp;
                    if(nums[i] == 0) {
                        zeroIndex = i;
                        break;
                    }
                }
            }
        }
        if(zeroIndex == -1) return 0;
        return zeroIndex + 1;
    }
    
}
