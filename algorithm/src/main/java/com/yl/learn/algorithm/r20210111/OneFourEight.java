package com.yl.learn.algorithm.r20210111;

import com.yl.learn.algorithm.ListNode;
import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

public class OneFourEight extends TestCase {
    
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode quick = head.next;
        
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        ListNode rightHead = slow.next;
        slow.next = null;
        
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        return merge(left, right);
    }
    
    private ListNode merge(ListNode left, ListNode right) {
        if(left == null && right == null) return null;
        if(left == null || right == null) {
            return left == null ? right : left;
        }
        
        if(left.val <= right.val) {
            left.next = merge(left.next, right);
            return left;
        }
        else {
            right.next = merge(left, right.next);
            return right;
        }
    }
    
    public void test() {
        PrintUtil.println(sortList(ListNode.Builder.build(new int[]{-10,1,2,34,5,6})));
    }
}
