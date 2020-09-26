package com.yl.learn.algorithm.yuanfudao;

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
public class ZigzagLevelOrder extends TestCase {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>(1);
        List<List<Integer>> rs = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int levelSize = 1;
        boolean isJ = false;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>(queue.size());
            int newSize = 0;
            if(isJ) {
                for(int i = 0; i < levelSize; i++) {
                    TreeNode cNode = queue.pollFirst();
                    level.add(cNode.val);
                    if(cNode.left != null) {
                        queue.addLast(cNode.left);
                        newSize++;
                    }
                    if(cNode.right != null) {
                        queue.addLast(cNode.right);
                        newSize++;
                    }
                }
            }
            else {
                for(int i = 0; i < levelSize; i++) {
                    TreeNode cNode = queue.pollLast();
                    level.add(cNode.val);
                    if(cNode.right != null) {
                        queue.addFirst(cNode.right);
                        newSize++;
                    }
                    if(cNode.left != null) {
                        queue.addFirst(cNode.left);
                        newSize++;
                    }
                }
            }
            levelSize = newSize;
            rs.add(level);
        }

        return rs;
    }

}
