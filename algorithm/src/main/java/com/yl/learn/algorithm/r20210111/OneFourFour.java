package com.yl.learn.algorithm.r20210111;

import com.yl.learn.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 *
 *
 *  示例 1：
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 *
 *
 *  示例 2：
 *
 *
 * 输入：root = []
 * 输出：[]
 *
 *
 *  示例 3：
 *
 *
 * 输入：root = [1]
 * 输出：[1]
 *
 *
 *  示例 4：
 *
 *
 * 输入：root = [1,2]
 * 输出：[1,2]
 *
 *
 *  示例 5：
 *
 *
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *
 *
 *
 *
 *  提示：
 *
 *
 *  树中节点数目在范围 [0, 100] 内
 *  -100 <= Node.val <= 100
 *
 *
 *
 *
 *  进阶：递归算法很简单，你可以通过迭代算法完成吗？
 *  Related Topics 栈 树
 */
public class OneFourFour  {
    public List<Integer> preorderTraversal(TreeNode root) {
    
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> rs = new ArrayList<>();
        TreeNode cur = root;
        
        while (cur != null || !stack.isEmpty()) {
            if(cur != null) {
                rs.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            else {
                cur = stack.pop();
                if(cur != null) {
                    cur = cur.right;
                }
            }
        }
        return rs;
    }
    
}
