package com.yl.learn.algorithm.bytedance;

import com.yl.learn.algorithm.ListNode;
import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例：
 * 给你这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 来源：力扣（LeetCode）25
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseKGroup extends TestCase {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1 || head == null) return head;
        ListNode p = head;
        ListNode rsH = null;
        ListNode rsT = null;
        while (p != null) {
            ListNode[] ht = new ListNode[2];
            if(reverse(p, k, ht) > 1) {
                reverse(ht[0], k, ht);
                if(rsH == null) return ht[0];
                else {
                    rsT.next = ht[0];
                    return rsH;
                }
            }
            if(rsH == null) {
                rsH = ht[0];
                rsT = ht[1];
            }
            else {
                rsT.next = ht[0];
                rsT = ht[1];
            }
            p = ht[1].next;
        }
        return rsH;
    }

    private int reverse(ListNode node, int k, ListNode[] ht) {
        ListNode next = node.next;
        node.next = null;
        ListNode h = node;
        ListNode t = node;
        node = next;
        while (node != null && k > 1) {
            next = node.next;
            node.next = h;
            h = node;
            node = next;
            k--;
        }
        t.next = node;
        ht[0] = h;
        ht[1] = t;
        return k;
    }

    private boolean isK(ListNode node, int n) {
        if(node == null) return false;
        int k = 0;
        while(node != null && k < n) {
            k++;
            node = node.next;
        }
        return k == n;
    }

    public void test() {
        PrintUtil.println(reverseKGroup(ListNode.Builder.build(new int[]{1, 2, 3, 4, 5}), 3).toString1());
    }

}
