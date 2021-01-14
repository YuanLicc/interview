package com.yl.learn.algorithm.r20210111;

import com.yl.learn.algorithm.TreeNode;

public class OfferTwoSeven {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return root;
        
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }
}
