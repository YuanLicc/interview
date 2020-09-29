package com.yl.learn.algorithm.bytedance;

import com.yl.learn.algorithm.ListNode;
import junit.framework.TestCase;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * 来源：力扣（LeetCode）143
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReorderList extends TestCase {

    public void reorderList(ListNode head) {
        ListNode p = head;
        ListNode pre = null;
        while (p != null) {
            ListNode n = dfs(p, p.next);
            ListNode next = p.next;
            p.next = n;
            if(pre == null) pre = n;
            else {
                pre.next = p;
                pre = n;
            }
            p = next;
        }
    }

    private ListNode dfs(ListNode pre, ListNode cur) {
        if(cur == null) return null;
        if(cur.next == null) {
            pre.next = null;
            return cur;
        }
        return dfs(pre.next, cur.next);
    }

    public void test() {
        reorderList(ListNode.Builder.build(new int[]{1,2,3,4}));
    }
}
