package com.yl.learn.algorithm.kuaishou;

import com.yl.learn.algorithm.TreeNode;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）105
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BTBuildTree {
    // 前序遍历 preorder = [3,9,20,15,7]
    // 中序遍历 inorder = [9,3,15,20,7]
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, 0, inorder.length - 1);
    }
    int i = 0;
    private TreeNode dfs(int[] preorder, int[] inorder, int start, int end) {
        if(i >= inorder.length) return null;
        TreeNode root = new TreeNode(preorder[i]);
        int index = index(inorder, start, end, preorder[i]);
        if(index == start)  root.left = null;
        else {
            i++;
            root.left = dfs(preorder, inorder, start, index - 1);
        }
        if(index == end) root.right = null;
        else {
            i++;
            root.right = dfs(preorder, inorder, index + 1, end);
        }
        return root;
    }

    private int index(int[] inorder, int start, int end, int aim) {
        for(; start <= end; start++) {
            if(inorder[start] == aim) return start;
        }
        return -1;
    }

}
