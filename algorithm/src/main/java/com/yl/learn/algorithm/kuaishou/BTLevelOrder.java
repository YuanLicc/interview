package com.yl.learn.algorithm.kuaishou;

import com.yl.learn.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 *
 * [3,9,20,15,7]
 *
 * 来源：力扣（LeetCode）offer 32
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BTLevelOrder {

    public int[] levelOrder(TreeNode root) {
        if(root == null) return new int[0];
        List<Integer> rs = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            TreeNode cNode = queue.pollFirst();
            rs.add(cNode.val);
            if(cNode.left != null) queue.addLast(cNode.left);
            if(cNode.right != null) queue.addLast(cNode.right);
        }
        return toArray(rs);
    }

    private int[] toArray(List<Integer> rs) {
        int[] rr = new int[rs.size()];
        for(int i = 0; i < rs.size(); i++) rr[i] = rs.get(i);
        return rr;
    }
}
