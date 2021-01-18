package com.yl.learn.algorithm.r20210111;

import com.yl.learn.algorithm.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 *  假设一个二叉搜索树具有如下特征：
 *
 *
 *  节点的左子树只包含小于当前节点的数。
 *  节点的右子树只包含大于当前节点的数。
 *  所有左子树和右子树自身必须也是二叉搜索树。
 *
 *
 *  示例 1:
 *
 *  输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 *
 *
 *  示例 2:
 *
 *  输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 *  Related Topics 树 深度优先搜索 递归
 *
 */
public class NineEight {
    
    public boolean isValidBST(TreeNode root) {
        Integer[] order = order(root);
    
        for (int i = 1; i < order.length; i++) {
            if(order[i] < order[i - 1]) return false;
        }
        return true;
    }
    
    private Integer[] order(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode cur = root;
        List<Integer> rs = new LinkedList<>();
        
        while (cur != null || !stack.isEmpty()) {
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            else {
                cur = stack.pop();
                rs.add(cur.val);
                cur = cur.right;
            }
        }
        
        Integer[] integers = new Integer[rs.size()];
        return rs.toArray(integers);
    }
    
}
