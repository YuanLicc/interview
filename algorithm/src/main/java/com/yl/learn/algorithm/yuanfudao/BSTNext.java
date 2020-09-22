package com.yl.learn.algorithm.yuanfudao;

import com.yl.learn.algorithm.TreeNode;
import junit.framework.TestCase;

/**
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 *
 * 04.06
 */
public class BSTNext extends TestCase {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null) return null;

        if(p.val >= root.val) return inorderSuccessor(root.right, p);

        TreeNode node = inorderSuccessor(root.left, p);

        return node == null ? root : node;
    }

    public void test() {
        inorderSuccessor(new BTCodec().deserialize("[0]"), new TreeNode(0));
    }
}
