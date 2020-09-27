package com.yl.learn.algorithm.bytedance;

import com.yl.learn.algorithm.ListNode;
import junit.framework.TestCase;

public class LNReverse extends TestCase {
    
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode p = head.next;
        pre.next = null;
        while(p != null) {
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }
    
    ListNode rs = null;
    public ListNode reverse(ListNode head) {
        if(head == null) return null;
        ListNode next = reverse(head.next);
        if(next == null) {
            rs = head;
            return head;
        }
        else {
            head.next = null;
            next.next = head;
            return head;
        }
    }
}
