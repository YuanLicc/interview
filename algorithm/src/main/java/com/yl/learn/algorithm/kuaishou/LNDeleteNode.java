package com.yl.learn.algorithm.kuaishou;

import com.yl.learn.algorithm.ListNode;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * 注意：此题对比原题有改动
 * 示例 1:
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 *
 * 来源：力扣（LeetCode）18
 * 链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LNDeleteNode {

    public ListNode deleteNode(ListNode head, int val) {
        if(head == null) return head;
        if(head.val == val) return head.next;
        ListNode pre = head;
        ListNode p = head.next;
        while (p != null) {
            if(p.val == val) {
                ListNode next = p.next;
                pre.next = next;
                break;
            }
            pre = p;
            p = p.next;
        }
        return head;
    }

}
