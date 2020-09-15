package com.yl.learn.algorithm.yuanfudao;

import com.yl.learn.algorithm.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 *
 * 来源：力扣（LeetCode）143
 * 链接：https://leetcode-cn.com/problems/reorder-list
 */
public class ReOrderList {
    
    public void reorderList(ListNode head) {
        List<ListNode> lis = new ArrayList<>();
        
        ListNode temp = head;
        
        while (temp != null) {
            lis.add(temp);
            temp = temp.next;
        }
        
        temp = head;
        int index = lis.size() - 1;
        
        while (temp != null && index >= lis.size() / 2) {
            ListNode right = lis.get(index);
            right.next = null;
            
            ListNode leftNext = temp.next;
            temp.next = right;
            right.next = leftNext;
            temp = leftNext;
            index--;
        }
        if(temp != null) temp.next = null;
    }
}
