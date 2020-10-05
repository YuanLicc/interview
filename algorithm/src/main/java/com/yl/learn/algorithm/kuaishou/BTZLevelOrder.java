package com.yl.learn.algorithm.kuaishou;

import com.yl.learn.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 *  
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）offer 32-3
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BTZLevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>(1);

        List<List<Integer>> rs = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        boolean is = true;
        int levelSize = 1;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            if(is) {
                while (levelSize > 0) {
                    TreeNode cNode = queue.pollFirst();
                    level.add(cNode.val);
                    if(cNode.left != null) queue.addLast(cNode.left);
                    if(cNode.right != null) queue.addLast(cNode.right);
                    levelSize--;
                }
            }
            else {
                while (levelSize > 0) {
                    TreeNode cNode = queue.pollLast();
                    level.add(cNode.val);
                    if(cNode.right != null) queue.addFirst(cNode.right);
                    if(cNode.left != null) queue.addFirst(cNode.left);
                    levelSize--;
                }
            }
            rs.add(level);
            is = !is;
            levelSize = queue.size();
        }
        return rs;
    }
}
