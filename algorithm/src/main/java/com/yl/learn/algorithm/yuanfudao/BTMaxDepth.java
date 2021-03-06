package com.yl.learn.algorithm.yuanfudao;

import com.yl.learn.util.tree.TreeNode;

/**
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * leetcode 104
 */
public class BTMaxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        return Math.max(left, right);
    }
}
