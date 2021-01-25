package com.yl.learn.algorithm.r20210111;

import com.yl.learn.algorithm.ListNode;

import java.util.Stack;

public class OneFourEight {
    
    public ListNode sortList(ListNode head) {
        if(head == null) return head;
        
        Stack<ListNode> maxStack = new Stack<>();
        Stack<ListNode> help = new Stack<>();
        
        ListNode p = head;
        
        while (p != null) {
            while (!maxStack.isEmpty() && maxStack.peek().val < p.val) {
                help.push(maxStack.pop());
            }
            maxStack.push(p);
            while (!help.isEmpty()) {
                maxStack.push(help.pop());
            }
            p = p.next;
        }
        ListNode rs = null;
        ListNode pre = null;
        
        while (!maxStack.isEmpty()) {
            if(rs == null) {
                rs = maxStack.pop();
                pre = rs;
            }
            else {
                pre.next = maxStack.pop();
                pre = pre.next;
            }
        }
        pre.next = null;
        
        return rs;
    }
    
}
