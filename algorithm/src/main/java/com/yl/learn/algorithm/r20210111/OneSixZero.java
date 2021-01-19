package com.yl.learn.algorithm.r20210111;

import com.yl.learn.algorithm.ListNode;

public class OneSixZero {
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
            
        }
        return a;
    }
    
}
