package com.yl.learn.algorithm.r20210111;

import com.yl.learn.algorithm.TreeNode;

import java.util.*;

public class OneNineNine {
    
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return Collections.emptyList();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> rs = new LinkedList<>();
        rs.add(root.val);
        int level = 1;
        while (!queue.isEmpty()) {
            while (level > 0) {
                TreeNode node = queue.poll();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                level--;
            }
            level = queue.size();
            if(!queue.isEmpty()) rs.add(queue.peekLast().val);
        }
        return rs;
    }
    
}
