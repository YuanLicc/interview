package com.yl.learn.algorithm.kuaishou;

import com.yl.learn.algorithm.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode）24
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        // 给定 1->2->3->4, 你应该返回 2->1->4->3.
        if(head == null || head.next == null) return head;

        ListNode h = null;
        ListNode t = null;
        ListNode p = head;
        while (p != null && p.next != null) {
            ListNode n = p.next;
            ListNode nn = n.next;
            p.next = null;
            n.next = p;
            if(h == null) {
                h = n;
            }
            else {
                t.next = n;
            }
            t = p;
            p = nn;
        }
        if(p != null) t.next = p;
        return h;
    }
}
