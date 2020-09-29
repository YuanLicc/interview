package com.yl.learn.algorithm.bytedance;

import com.yl.learn.algorithm.TreeNode;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 示例:
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 * 来源：力扣（LeetCode）199
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BTRightSideView extends TestCase {
    
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>(1);
        List<Integer> rs = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int levelSize = 1;
        while (!queue.isEmpty()) {
            rs.add(queue.peekLast().val);
            while (levelSize > 0) {
                TreeNode cNode = queue.pollLast();
                if(cNode.right != null) queue.addFirst(cNode.right);
                if(cNode.left != null) queue.addFirst(cNode.left);
                levelSize--;
            }
            levelSize = queue.size();
        }
        return rs;
    }
}
