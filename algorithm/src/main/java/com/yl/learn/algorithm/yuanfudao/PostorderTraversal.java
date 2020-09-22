package com.yl.learn.algorithm.yuanfudao;

import com.yl.learn.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 * 示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 * 输出: [3,2,1]
 *
 * 来源：力扣（LeetCode）145
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 */
public class PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        dfs(root, list);

        return list;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if(root == null) return;

        dfs(root.left, list);
        dfs(root.right, list);

        list.add(root.val);
    }


}
