package com.yl.learn.algorithm.yuanfudao;

import com.yl.learn.algorithm.ListNode;
import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * 来源：力扣（LeetCode）86
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LNPartition extends TestCase {

    public ListNode partition(ListNode head, int x) {
        if(head == null) return head;
        ListNode minHead = null;
        ListNode min = null;
        ListNode pPre = null;
        ListNode p = head;
        while(p != null && p.val < x) {
            pPre = p;
            p = p.next;
        }
        if(p == null) return head;
        ListNode maxHead = p;
        ListNode maxPre = p;
        p = p.next;
        maxHead.next = null;
        maxPre.next = null;
        while(p != null) {
            ListNode next = p.next;
            p.next = null;
            if(p.val < x) {
                if(minHead == null) {
                    minHead = p;
                    min = p;
                }
                else {
                    min.next = p;
                    min = p;
                }
            }
            else {
                maxPre.next = p;
                maxPre = p;
            }
            p = next;
        }
        if(minHead == null) return head;
        else min.next = maxHead;
        if(pPre == null) return minHead;
        pPre.next = minHead;
        return head;
    }

    public void test() {
        PrintUtil.println(partition(ListNode.Builder.build(new int[]{1, 2, 3, 3, 4}), 3).toString());
        PrintUtil.println(partition(ListNode.Builder.build(new int[]{1, 2, 3, 3, 4, 1}), 3).toString());
        PrintUtil.println(partition(ListNode.Builder.build(new int[]{1}), 3).toString());
        PrintUtil.println(partition(ListNode.Builder.build(new int[]{3, 2, 1, 0}), 2).toString());
    }

}
