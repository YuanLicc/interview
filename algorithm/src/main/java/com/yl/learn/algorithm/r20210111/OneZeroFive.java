package com.yl.learn.algorithm.r20210111;

import com.yl.learn.algorithm.TreeNode;
import junit.framework.TestCase;

/**
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 *
 *  返回如下的二叉树：
 *
 *      3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class OneZeroFive extends TestCase {
    //[3,9,20,15,7]
    //[9,3,15,20,7]
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, 0, inorder.length - 1);
    }
    
    private int preIndex = 0;
    
    private TreeNode dfs(int[] preorder, int[] inorder, int inStart, int inEnd) {
        if(preIndex >= preorder.length) return null;
        
        if(inStart == inEnd) return new TreeNode(inorder[inStart]);
        
        TreeNode root = new TreeNode(preorder[preIndex]);
        int index = find(inorder, inStart, inEnd, preorder[preIndex]);
        if(index > inStart) {
            preIndex++;
            root.left = dfs(preorder, inorder, inStart, index - 1);
        }
        if(index < inEnd) {
            preIndex++;
            root.right = dfs(preorder, inorder, index + 1, inEnd);
        }
        return root;
    }
    
    private int find(int[] in, int inStart, int inEnd, int aim) {
        for (int i = inStart; i <= inEnd; i++) if(aim == in[i]) return i;
        return -1;
    }
    
    public void test() {
        buildTree(new int[]{1,2}, new int[]{1,2});
    }
    
}
