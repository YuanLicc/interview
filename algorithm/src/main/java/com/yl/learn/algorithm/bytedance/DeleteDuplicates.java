package com.yl.learn.algorithm.bytedance;

import com.yl.learn.algorithm.ListNode;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 *
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * 来源：力扣（LeetCode）83
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DeleteDuplicates {
    
    public ListNode deleteDuplicates(ListNode head) {
        dfs(head);
        return head;
    }
    
    private void dfs(ListNode head) {
        if(head == null || head.next == null) return;
        
        if(head.val == head.next.val) {
            ListNode next = head.next.next;
            head.next = next;
            dfs(head);
        }
        else {
            dfs(head.next);
        }
    }
    
}
