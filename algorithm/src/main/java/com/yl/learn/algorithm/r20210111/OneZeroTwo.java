package com.yl.learn.algorithm.r20210111;

import com.yl.learn.algorithm.TreeNode;

import java.util.*;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *
 *
 *  示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *
 *  返回其层序遍历结果：
 *
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 *  Related Topics 树 广度优先搜索
 */
public class OneZeroTwo {
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return Collections.emptyList();
        List<List<Integer>> rs = new ArrayList<>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        int levelSize = 1;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>(levelSize);
            while (levelSize > 0 && !queue.isEmpty()) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                levelSize--;
            }
            levelSize = queue.size();
            rs.add(level);
        }
        return rs;
    }
}
