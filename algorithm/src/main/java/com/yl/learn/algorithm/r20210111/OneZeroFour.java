package com.yl.learn.algorithm.r20210111;

import com.yl.learn.algorithm.TreeNode;

public class OneZeroFour {
    
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        dfs(root, 0);
        return max;
    }
    
    private int max = Integer.MIN_VALUE;
    private void dfs(TreeNode node, int nums) {
        if(node == null) {
            max = max > nums ? max : nums;
            return;
        }
        dfs(node.left, nums + 1);
        dfs(node.right, nums + 1);
    }
    
}
