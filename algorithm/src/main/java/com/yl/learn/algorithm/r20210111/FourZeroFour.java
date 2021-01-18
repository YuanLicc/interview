package com.yl.learn.algorithm.r20210111;

import com.yl.learn.algorithm.TreeNode;

import java.util.Stack;

/**
 * 计算给定二叉树的所有左叶子之和。
 *
 *  示例：
 *
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */
public class FourZeroFour {
    
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
    
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        boolean curLeft = false;
        
        while (cur != null || !stack.isEmpty()) {
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
                if(cur != null) curLeft = true;
            }
            else {
                cur = stack.pop();
                if(curLeft && cur.right == null) sum += cur.val;
                cur = cur.right;
                curLeft = false;
            }
        }
        return sum;
    }
    
}
