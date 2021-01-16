package com.yl.learn.algorithm.r20210111;

import com.yl.learn.algorithm.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 *  例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *
 *  返回锯齿形层序遍历如下：
 *
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 */
public class OneZeroThree {
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return Collections.emptyList();
        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> list = new LinkedList<>();
        deque.addLast(root);
        int level = 1;
        boolean isJ = true;
        while (!deque.isEmpty()) {
            List<Integer> levelList = new ArrayList<>(level);
            while (level > 0) {
                level--;
                if(!isJ) {
                    TreeNode node = deque.pollFirst();
                    if(node.right != null) deque.addLast(node.right);
                    if(node.left != null) deque.addLast(node.left);
                    levelList.add(node.val);
                }
                else {
                    TreeNode node = deque.pollLast();
                    if(node.left != null) deque.addFirst(node.left);
                    if(node.right != null) deque.addFirst(node.right);
                    levelList.add(node.val);
                }
            }
            isJ = !isJ;
            list.add(levelList);
            level = deque.size();
        }
        return list;
    }
}
