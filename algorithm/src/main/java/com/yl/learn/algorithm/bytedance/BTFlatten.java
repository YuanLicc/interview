package com.yl.learn.algorithm.bytedance;

import com.yl.learn.algorithm.TreeNode;
import com.yl.learn.algorithm.yuanfudao.BTCodec;
import junit.framework.TestCase;

/**
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 * 例如，给定二叉树
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 来源：力扣（LeetCode）114
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BTFlatten extends TestCase {

    public void flatten(TreeNode root) {
        dfs(null, root);
    }

    TreeNode tail = null;
    private TreeNode dfs(TreeNode pre, TreeNode root) {
        if(root == null) {
            tail = pre;
            return null;
        }
        TreeNode leftHead = dfs(root, root.left);
        TreeNode leftTail = tail;
        tail = null;
        TreeNode rightHead = dfs(root, root.right);
        TreeNode rightTail = tail;
        tail = null;
        if(leftHead != null && leftHead != root && rightHead != null && rightHead != root) {
            root.right = leftHead;
            leftTail.right = rightHead;
            tail = rightTail;
        }
        else if(leftHead != null && leftHead != root) {
            root.right = leftHead;
            tail = leftTail;
        }
        else if(rightHead != null && rightHead != root) {
            root.right = rightHead;
            tail = rightTail;
        }
        else {
            tail = root;
        }
        root.left = null;
        return root;
    }

    public void test() {
        flatten(new BTCodec().deserialize("[1,2,5,3,4,null,6]"));
    }

}
