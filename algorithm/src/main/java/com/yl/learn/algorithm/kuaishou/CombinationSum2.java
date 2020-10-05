package com.yl.learn.algorithm.kuaishou;

import junit.framework.TestCase;

import java.util.*;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 *
 * 来源：力扣（LeetCode）40
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum2 extends TestCase {

    public void test() {
        combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<>(), 0, "");
        return rs;
    }

    List<List<Integer>> rs = new ArrayList<>();
    Map<String, Integer> cache = new HashMap<>();

    private void dfs(int[] candidates, int i, int target, List<Integer> integers, int sum, String s) {
        if(sum > target) return;
        if(sum == target) {
            if(cache.get(s) == null) rs.add(integers);
            cache.put(s, 1);
            return;
        }
        if(i >= candidates.length) return;

        // 不选
        dfs(candidates, i + 1, target, integers, sum, s);
        List<Integer> copied = copy(integers);
        copied.add(candidates[i]);
        dfs(candidates, i + 1, target, copied, sum + candidates[i], s + "," + candidates[i]);
    }

    private List<Integer> copy(List<Integer> copied) {
        List<Integer> copy = new ArrayList<>(copied.size());
        for(int i = 0; i < copied.size(); i++) {
            copy.add(copied.get(i));
        }
        return copy;
    }
}
