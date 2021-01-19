package com.yl.learn.algorithm.r20210111;

import com.yl.learn.algorithm.ListNode;

public class OneNine {
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int nn = remove(head, n);
        if(nn == n) {
            return head.next;
        }
        return head;
    }
    
    private int remove(ListNode root, int n) {
        if(root == null) return 0;
        int nextN = remove(root.next, n);
        
        if(nextN == n) {
            ListNode next = root.next;
            root.next = next.next;
        }
        return nextN + 1;
    }
    
}
