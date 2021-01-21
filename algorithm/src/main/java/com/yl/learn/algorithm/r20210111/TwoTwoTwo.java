package com.yl.learn.algorithm.r20210111;

import com.yl.learn.algorithm.TreeNode;

public class TwoTwoTwo {
    
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
    
    private int size = 0;
    
    private int dfs(TreeNode root) {
        if(root == null) return 0;
        return dfs(root.left) + 1;
    }
}
