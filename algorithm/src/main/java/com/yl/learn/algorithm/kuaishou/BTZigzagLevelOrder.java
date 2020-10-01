package com.yl.learn.algorithm.kuaishou;

import com.yl.learn.algorithm.TreeNode;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）103
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BTZigzagLevelOrder extends TestCase {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>(1);

        List<List<Integer>> rs = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int levelSize = 1;
        boolean is = true;

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>(levelSize);
            if(is) {
                while (levelSize > 0) {
                    TreeNode node = queue.pollFirst();
                    level.add(node.val);
                    if(node.left != null) queue.addLast(node.left);
                    if(node.right != null) queue.addLast(node.right);
                    levelSize--;
                }
            }
            else {
                while (levelSize > 0) {
                    TreeNode node = queue.pollLast();
                    level.add(node.val);
                    if(node.right != null) queue.addFirst(node.right);
                    if(node.left != null) queue.addFirst(node.left);
                    levelSize--;
                }
            }
            is = !is;
            levelSize = queue.size();
            rs.add(level);
        }
        return rs;
    }
}
