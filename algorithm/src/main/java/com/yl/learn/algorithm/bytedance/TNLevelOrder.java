package com.yl.learn.algorithm.bytedance;

import com.yl.learn.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * 来源：力扣（LeetCode）102
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TNLevelOrder {
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>(1);
        List<List<Integer>> rs = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int levelSize = 1;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            while (levelSize > 0) {
                TreeNode cNode = queue.pollFirst();
                level.add(cNode.val);
                if(cNode.left != null) queue.addLast(cNode.left);
                if(cNode.right != null) queue.addLast(cNode.right);
                levelSize--;
            }
            rs.add(level);
            levelSize = queue.size();
        }
        return rs;
    }
    
}
