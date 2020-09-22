package com.yl.learn.algorithm.yuanfudao;

import com.yl.learn.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 * 示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 * 输出: [3,2,1]
 *
 * 来源：力扣（LeetCode）145
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 */
public class PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        dfs(root, list);

        return list;
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        if(root == null) return new ArrayList<>(1);

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cNode = root;

        while (cNode != null || !stack.isEmpty()) {
            if(cNode != null) {
                stack.push(cNode);
                cNode = cNode.left;
            }
            else if(!stack.isEmpty() && stack.peek() == null) {
                stack.pop();
                list.add(stack.pop().val);
            }
            else {
                cNode = stack.peek().right;
                stack.push(null);
            }
        }

        return list;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if(root == null) return;

        dfs(root.left, list);
        dfs(root.right, list);

        list.add(root.val);
    }


}
