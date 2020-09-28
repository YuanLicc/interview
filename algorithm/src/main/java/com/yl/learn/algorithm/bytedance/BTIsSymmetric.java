package com.yl.learn.algorithm.bytedance;

import com.yl.learn.algorithm.TreeNode;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 来源：力扣（LeetCode）101
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BTIsSymmetric {

    boolean is = true;
    public boolean isSymmetric(TreeNode root) {
        dfs(root, root);
        return is;
    }

    private void dfs(TreeNode r1, TreeNode r2) {
        if(r1 == null && r2 == null) return;
        if((r1 == null || r2 == null) || r1.val != r2.val) {
            is = false;
            return;
        }
        dfs(r1.left, r2.right);
        dfs(r1.right, r2.left);
    }
}
