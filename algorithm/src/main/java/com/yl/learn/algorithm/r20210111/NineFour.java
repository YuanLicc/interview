package com.yl.learn.algorithm.r20210111;

import com.yl.learn.algorithm.TreeNode;
import junit.framework.TestCase;

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
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 *
 *
 *  示例 1：
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
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
 * 输出：[2,1]
 *
 *
 *  示例 5：
 *
 *
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *
 *  提示：
 *  树中节点数目在范围 [0, 100] 内
 *  -100 <= Node.val <= 100
 *
 *
 *  进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *  Related Topics 栈 树 哈希表
 */
public class NineFour extends TestCase {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> rs = new ArrayList<>();
        
        TreeNode cur = root;
        
        while (cur != null || !stack.isEmpty()) {
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            else {
                cur = stack.pop();
                if(cur != null) {
                    rs.add(cur.val);
                }
                cur = cur.right;
            }
        }
        return rs;
    }
}
