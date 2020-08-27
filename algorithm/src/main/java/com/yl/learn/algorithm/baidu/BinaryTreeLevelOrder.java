package com.yl.learn.algorithm.baidu;

import com.yl.learn.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrder {

    public List<List<Integer>> levelOrder(TreeNode<Integer> node) {
        
        List<List<Integer>> rs = new ArrayList<>();
        if(node == null) return rs;
    
        LinkedList<TreeNode<Integer>> queue = new LinkedList<>();
        queue.addLast(node);
        queue.addLast(null);
        
        while(!queue.isEmpty() && queue.getFirst() != null) {
            
            ArrayList<Integer> level = new ArrayList<>();
            
            while(queue.getFirst() != null) {
                TreeNode<Integer> levelNode = queue.removeFirst();
                level.add(levelNode.value);
                if(levelNode.left != null) queue.addLast(levelNode.left);
                if(levelNode.right != null) queue.addLast(levelNode.right);
            }
            rs.add(level);
            queue.removeFirst();
            queue.addLast(null);
        }
        
        return rs;
    }

}
