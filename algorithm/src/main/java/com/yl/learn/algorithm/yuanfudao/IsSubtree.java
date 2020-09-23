package com.yl.learn.algorithm.yuanfudao;

import com.yl.learn.algorithm.TreeNode;

import java.util.Stack;

/**
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * 示例 1:
 * 给定的树 s:
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 *
 * 来源：力扣（LeetCode）572
 * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree
 */
public class IsSubtree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null || t == null) return false;

        TreeNode cNode = s;
        Stack<TreeNode> stack = new Stack<>();
        while(cNode != null || !stack.isEmpty()) {
            if(cNode != null) {
                stack.push(cNode);
                cNode = cNode.left;
            }
            else {
                TreeNode cur = stack.pop();
                if(cur.val == t.val) {
                    boolean is = dfs(cur, t);
                    if(is) return false;
                }
                cNode = cur.right;
            }
        }
        return false;
    }

    private boolean dfs(TreeNode cur, TreeNode t) {
        if((cur == null && t != null) || (cur != null && t == null)) return false;
        if(cur == null && t == null) return true;
        if(cur.val == t.val) {
            return dfs(cur.left, t.left) && dfs(cur.right, t.right);
        }
        return false;
    }
}
