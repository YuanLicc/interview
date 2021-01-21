package com.yl.learn.algorithm.r20210111;

import com.yl.learn.algorithm.TreeNode;

public class OneOneZero {
    
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return is;
    }
    
    private boolean is = true;
    
    private int dfs(TreeNode root) {
        if(root == null) return 0;
        
        int left = dfs(root.left);
        int right = dfs(root.right);
        
        if(Math.abs(left - right) > 1) is = false;
        
        return Math.max(left, right) + 1;
    }
    
}
