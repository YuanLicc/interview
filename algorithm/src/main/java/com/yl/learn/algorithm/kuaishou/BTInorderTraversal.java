package com.yl.learn.algorithm.kuaishou;

import com.yl.learn.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）94
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BTInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>(1);
        List<Integer> rs = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cNode = root;
        while (cNode != null || !stack.isEmpty()) {
            if(cNode != null) {
                stack.push(cNode);
                cNode = cNode.left;
            }
            else {
                TreeNode node = stack.pop();
                rs.add(node.val);
                cNode = node.right;
            }
        }
        return rs;
    }
}
