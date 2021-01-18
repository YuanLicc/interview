package com.yl.learn.algorithm.r20210111;

import com.yl.learn.algorithm.ListNode;

public class TwoZeroSix {
    
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode p = head.next;
        ListNode pre = head;
        pre.next = null;
        
        while (p != null) {
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }
    
}
