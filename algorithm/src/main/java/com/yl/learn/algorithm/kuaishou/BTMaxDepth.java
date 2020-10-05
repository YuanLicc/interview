package com.yl.learn.algorithm.kuaishou;

import com.yl.learn.algorithm.TreeNode;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）104
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BTMaxDepth {

    int max = 0;
    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return max;
    }

    private void dfs(TreeNode root, int i) {
        if(root == null) {
            max = max > i ? max : i;
            return;
        }
        dfs(root.left, i + 1);
        dfs(root.right, i + 1);
    }
}
