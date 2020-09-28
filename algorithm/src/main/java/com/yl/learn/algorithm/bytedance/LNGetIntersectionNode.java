package com.yl.learn.algorithm.bytedance;

import com.yl.learn.algorithm.ListNode;

import java.util.Stack;

public class LNGetIntersectionNode {
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> a = dfs(headA);
        Stack<ListNode> b = dfs(headB);
        ListNode rs = null;
        while(!a.isEmpty() && b.isEmpty() && a.peek() == b.peek()) {
            rs = a.pop();
            b.pop();
        }
        return rs;
    }
    
    private Stack<ListNode> dfs(ListNode node) {
        Stack<ListNode> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        return stack;
    }
    
}
