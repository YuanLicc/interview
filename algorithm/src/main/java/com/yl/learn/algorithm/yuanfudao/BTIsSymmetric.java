package com.yl.learn.algorithm.yuanfudao;

import com.yl.learn.algorithm.TreeNode;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 来源：力扣（LeetCode）101
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 */
public class BTIsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        return dfs(root, root);
    }

    private boolean dfs(TreeNode left, TreeNode right) {

        if(left == null && right == null) return true;
        if(left == null || right == null) return false;

        if(left.val != right.val) return false;
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
