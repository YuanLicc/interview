package com.yl.learn.algorithm.kuaishou;

import com.yl.learn.algorithm.ListNode;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * 来源：力扣（LeetCode）92
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseBetween {
    
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head.next == null || m == n) return head;
        // 输入: 1->2->3->4->5->NULL, m = 2, n = 4
        // 输出: 1->4->3->2->5->NULL
        ListNode pre = null;
        ListNode mLN = head;
        int len = 1;
        while (mLN != null && len < m) {
            len++;
            pre = mLN;
            mLN = mLN.next;
        }
        
        reverse(mLN, n - m);
        if(pre == null) {
            tail.next = ne;
            return h;
        }
        pre.next = h;
        tail.next = ne;
        return head;
    }
    
    ListNode h = null;
    ListNode tail = null;
    ListNode ne = null;
    private ListNode reverse(ListNode mLN, int i) {
        if(i == 0) {
            h = mLN;
            ne = mLN.next;
            return mLN;
        }
        tail = tail == null ? mLN : tail;
        ListNode hh = reverse(mLN.next, i - 1);
        mLN.next = null;
        hh.next = mLN;
        return mLN;
    }
    
}
