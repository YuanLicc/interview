package com.yl.learn.algorithm.r20210111;

import com.yl.learn.algorithm.ListNode;

public class OfferFiveTwo {
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        
        while (a != b) {
            a = a != null ? a.next : headB;
            b = b != null ? b.next : headA;
        }
        
        return a;
    }
}
