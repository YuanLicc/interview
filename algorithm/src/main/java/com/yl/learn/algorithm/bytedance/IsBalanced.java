package com.yl.learn.algorithm.bytedance;

import com.yl.learn.algorithm.TreeNode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 来源：力扣（LeetCode）110
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsBalanced {
    boolean is = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return false;
        dfs(root);
        return is;
    }
    private int dfs(TreeNode root) {
        if(root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        is = !is ? is : (Math.abs(left - right) <= 1);
        return Math.max(left, right) + 1;
    }

}
