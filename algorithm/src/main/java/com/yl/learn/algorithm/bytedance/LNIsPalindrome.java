package com.yl.learn.algorithm.bytedance;

import com.yl.learn.algorithm.ListNode;

import java.util.Stack;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）234
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LNIsPalindrome {

    public boolean isPalindrome(ListNode head) {
        h = head;
        return dfs(head);
    }

    ListNode h = null;
    private boolean dfs(ListNode head) {
        if(head == null) return true;
        if(!dfs(head.next)) return false;
        if(head.val != h.val) return false;
        h = h.next;
        return true;
    }

    public boolean isPalindromeStack(ListNode head) {
        ListNode p = head;
        Stack<Integer> stack = new Stack<>();
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }
        p = head;
        while (p != null) {
            if(p.val != stack.pop()) return false;
        }
        return true;
    }
}
