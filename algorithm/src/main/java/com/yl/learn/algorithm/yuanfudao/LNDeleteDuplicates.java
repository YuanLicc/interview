package com.yl.learn.algorithm.yuanfudao;

import com.yl.learn.algorithm.ListNode;
import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 示例 1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * 来源：力扣（LeetCode）82
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LNDeleteDuplicates extends TestCase {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode rs = null;
        ListNode pre = null;
        while(head != null) {
            int cnt = 1;
            int val = head.val;
            while(head.next != null && head.next.val == val) {
                cnt++;
                head = head.next;
            }
            if(cnt == 1) {
                ListNode next = head.next;
                head.next = null;
                if(pre == null) {
                    rs = head;
                    pre = head;
                }
                else {
                    pre.next = head;
                    pre = pre.next;
                }
                head = next;
            }
            else head = head.next;
        }
        return rs;
    }

    public void test() {
        PrintUtil.println(deleteDuplicates(ListNode.Builder.build(new int[]{1, 2, 2})).toString1());
    }
}
