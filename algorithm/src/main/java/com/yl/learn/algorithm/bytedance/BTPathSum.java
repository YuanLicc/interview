package com.yl.learn.algorithm.bytedance;

import com.yl.learn.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 来源：力扣（LeetCode）113
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BTPathSum {
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return new ArrayList<>(1);
        List<List<Integer>> rs = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        dfs(root, 0, rs, sum, item);
        return rs;
    }
    
    private void dfs(TreeNode root, int sum, List<List<Integer>> rs, int target, List<Integer> item) {
        if(root.left == null && root.right == null) {
            if(sum + root.val == target) {
                item.add(root.val);
                rs.add(copy(item));
                item.remove(item.size() - 1);
            }
            return;
        }
        item.add(root.val);
        if(root.left != null) dfs(root.left, sum + root.val, rs, target, item);
        if(root.right != null) dfs(root.right, sum + root.val, rs, target, item);
        item.remove(item.size() - 1);
    }
    
    private List<Integer> copy(List<Integer> copied) {
        List<Integer> rs = new ArrayList<>(copied.size());
        for(int i = 0; i < copied.size(); i++) rs.add(copied.get(i));
        return rs;
    }
}
