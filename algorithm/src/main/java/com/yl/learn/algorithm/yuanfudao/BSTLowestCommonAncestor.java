package com.yl.learn.algorithm.yuanfudao;

import com.yl.learn.algorithm.TreeNode;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 * 示例 1:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 *
 * 示例 2:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *
 * 来源：力扣（LeetCode）234
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BSTLowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null) return null;
        ll(root, p, q);
        return rs;
    }

    TreeNode rs = null;
    private int ll(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return 0;
        int num = ((root.val == p.val || root.val == q.val) ? 1 : 0) +
                ll(root.left, p, q) + ll(root.right, p, q);
        if(rs == null && num == 2) rs = root;
        return num;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null) return null;

        if(root.val > p.val && root.val > q.val) return lowestCommonAncestor1(root.left, p, q);
        if(root.val < q.val && root.val < p.val) return lowestCommonAncestor1(root.right, p, q);
        return root;
    }

}
