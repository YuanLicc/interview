package com.yl.learn.algorithm.r20210111;

import com.yl.learn.algorithm.ListNode;
import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

public class TwoFive extends TestCase {
    
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;
        return head(head, k);
    }
    
    private ListNode head(ListNode start, int k) {
        if(start == null) return null;
        
        ListNode p = start;
        int num = 0;
        
        while (p != null) {
            num++;
            if(num == k) break;
            p = p.next;
        }
        
        if(k != num) {
            return start;
        }
        else {
            ListNode next = head(p.next, k);
            ListNode p1 = start.next;
            start.next = next;
            p.next = null;
            while (p1 != null) {
                ListNode ne = p1.next;
                p1.next = start;
                start = p1;
                p1 = ne;
            }
            return start;
        }
    }
    
    public void test() {
        PrintUtil.println(reverseKGroup(ListNode.Builder.build(new int[]{1,2,3,4,5}), 4));
    }
    
}
