package com.yl.learn.algorithm.bytedance;

import com.yl.learn.algorithm.ListNode;
import junit.framework.TestCase;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）2
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LNAddTwoNumbers extends TestCase {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) return l1 == null ? l2 : l1;
        return dfs(l1, l2, false);
    }
    
    private ListNode dfs(ListNode l1, ListNode l2, boolean b) {
        if(l1 == null && l2 == null) {
            if(b) return new ListNode(1);
            else return null;
        }
        if(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + (b ? 1 : 0);
            l1.val = sum % 10;
            ListNode next = dfs(l1.next, l2.next, sum >= 10);
            l1.next = next;
            return l1;
        }
        else {
            ListNode c = l1 == null ? l2 : l1;
            int sum = c.val + (b ? 1 : 0);
            c.val = sum % 10;
            c.next = dfs(c.next, null, sum >= 10);
            return c;
        }
    }
}
