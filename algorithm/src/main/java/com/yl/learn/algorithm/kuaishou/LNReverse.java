package com.yl.learn.algorithm.kuaishou;

import com.yl.learn.algorithm.ListNode;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）206
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LNReverse {
    
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode pre = head;
        ListNode cur = head.next;
        pre.next = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    
    ListNode h = null;
    public ListNode reverseListRe(ListNode head) {
        if(head.next == null) {
            h = head;
            return head;
        }
        ListNode n = reverseListRe(head.next);
        n.next = head;
        head.next = null;
        return head;
    }
}
