package com.yl.learn.algorithm.r20210111;

import com.yl.learn.algorithm.ListNode;

public class TwoThreeFour {
    
    private ListNode p;
    
    private boolean is = true;
    
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        p = head;
        dfs(head);
        return is;
    }
    
    private ListNode dfs(ListNode root) {
        if(root == null) return null;
        ListNode node = dfs(root.next);
        if(node != null && is) {
            is = node.val == p.val;
            p = p.next;
        }
        return root;
    }
    
}
