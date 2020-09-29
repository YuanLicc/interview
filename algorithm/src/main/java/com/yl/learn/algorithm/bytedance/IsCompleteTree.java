package com.yl.learn.algorithm.bytedance;

import com.yl.learn.algorithm.TreeNode;

/**
 * 给定一个二叉树，确定它是否是一个完全二叉树。
 * 百度百科中对完全二叉树的定义如下：
 * 若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。（注：第 h 层可能包含 1~ 2h 个节点。）
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,5,6]
 * 输出：true
 * 解释：最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地向左。
 *
 * 来源：力扣（LeetCode）958
 * 链接：https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsCompleteTree {

    public boolean isCompleteTree(TreeNode root) {
        if(root == null) return true;
        dfs(root, 0);
        return is;
    }

    boolean is = true;
    boolean isStart = false;
    Integer max = null;
    private void dfs(TreeNode root, int high) {
        if(root == null) {
            max = max == null ? high : max;
            int minus = max - high;
            if(minus < 0 || minus > 1) is = false;
            if(minus == 0 && isStart) is = false;
            isStart = true;
        }
        dfs(root.left, high + 1);
        dfs(root.right, high + 1);
    }

}
