package com.yl.learn.algorithm.r20210111;

import com.yl.learn.algorithm.ListNode;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 *  示例 1:
 *
 *  输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 *
 *
 *  示例 2:
 *  输入: 1->1->1->2->3
 * 输出: 2->3
 *  Related Topics 链表
 *
 *
 *
 * eetcode submit region begin(Prohibit modification and deletion)
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
 */
public class EightTwo {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
    
        ListNode rs = null;
        ListNode pre = null;
        ListNode p = head;
    
        while (p != null) {
            ListNode next = p.next;
            int cnt = 0;
            while (next != null && p.val == next.val) {
                next = next.next;
                cnt++;
            }
        
            if(cnt == 0) {
                if(rs == null) {
                    rs = p;
                    pre = p;
                }
                else {
                    pre.next = p;
                    pre = p;
                }
                p = p.next;
            }
            p = next;
        }
    
        if(pre != null) {
            pre.next = null;
        }
    
        return rs;
    }
}
