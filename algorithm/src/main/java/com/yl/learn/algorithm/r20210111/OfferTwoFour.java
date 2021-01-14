package com.yl.learn.algorithm.r20210111;

import com.yl.learn.algorithm.ListNode;

public class OfferTwoFour {
    
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        
        ListNode pre = head;
        ListNode p = head.next;
        pre.next = null;
        
        while (p != null) {
            ListNode n = p.next;
            p.next = pre;
            pre = p;
            p = n;
        }
        
        return pre;
    }
}
