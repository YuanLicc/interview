package com.yl.learn.algorithm.bytedance;

import com.yl.learn.algorithm.ListNode;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 示例 1：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）23
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeKLists {
    
    public ListNode mergeKLists(ListNode[] lists) {
        int min = -1;
        for(int i = 0; i < lists.length; i++) {
            ListNode cNode = lists[i];
            if(min == -1 && cNode != null) {
                min = i;
                continue;
            }
            if(min != -1 && cNode != null) {
                min = lists[min].val < lists[i].val ? min : i;
            }
        }
        if(min == -1) return null;
        ListNode cNode = new ListNode(lists[min].val);
        lists[min] = lists[min].next;
        cNode.next = mergeKLists(lists);
        return cNode;
    }
}
