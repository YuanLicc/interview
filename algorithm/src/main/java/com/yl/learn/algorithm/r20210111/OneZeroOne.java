package com.yl.learn.algorithm.r20210111;

import com.yl.learn.algorithm.TreeNode;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *      1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *      1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *
 *  进阶：
 *
 *  你可以运用递归和迭代两种方法解决这个问题吗？
 *  Related Topics 树 深度优先搜索 广度优先搜索
 *
 */
public class OneZeroOne {
    
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return is(root.left, root.right);
    }
    
    private boolean is(TreeNode one, TreeNode two) {
        if(one == null && two == null) return true;
        else if(one == null || two == null) return false;
        return is(one.left, two.right) && is(one.right, two.left) && one.val == two.val;
    }
}
