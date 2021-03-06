package com.yl.learn.algorithm.kuaishou;

import com.yl.learn.algorithm.TreeNode;

/**
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）55
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BTDepth {

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        dfs(root, 0);
        return max;
    }

    int max = Integer.MIN_VALUE;
    private void dfs(TreeNode root, int high) {
        if(root == null) {
            max = max > high ? max : high;
            return;
        }
        dfs(root.left, high + 1);
        dfs(root.right, high + 1);
    }
}
