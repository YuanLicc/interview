package com.yl.learn.algorithm.r20210111;

import com.yl.learn.algorithm.TreeNode;
import junit.framework.TestCase;

public class TwoThreeSix extends TestCase {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p == q) return p;
        dfs(root, p, q);
        return rs == null ? root : rs;
    }
    
    private TreeNode rs;
    
    private int dfs(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return 0;
        if(p == q) return 2;
        
        int left = dfs(root.left, p, q);
        
        if(left == 2) {
            rs = rs == null ? root.left : rs;
            return 2;
        }
        
        int right = dfs(root.right, p, q);
        if(right == 2) {
            rs = rs == null ? root.right : rs;
            return 2;
        }
        
        return left + right + (root == p || root == q ? 1 : 0);
    }
    
    public void test() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(3);
        node.right = new TreeNode(4);
        
        lowestCommonAncestor(node, node.left, node.right);
    }
    
}
