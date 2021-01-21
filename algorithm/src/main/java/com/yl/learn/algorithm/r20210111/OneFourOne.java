package com.yl.learn.algorithm.r20210111;

import com.yl.learn.algorithm.ListNode;

public class OneFourOne {
    
    public boolean hasCycle(ListNode head) {
        ListNode quick = head, slow = head;
        
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
            if(quick == slow) return true;
        }
        return false;
    }
    
}
