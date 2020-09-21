package com.yl.learn.algorithm.yuanfudao;

import com.yl.learn.algorithm.ListNode;
import com.yl.learn.algorithm.TreeNode;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）109
 * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 */
public class LNToBBST extends TestCase {
    
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        
        List<Integer> list = toList(head);
        
        return toBST(list, 0, list.size() - 1);
    }
    
    private TreeNode toBST(List<Integer> list, int start, int end) {
        if(start > end) {
            return null;
        }
        if(start == end) {
            return new TreeNode(list.get(start));
        }
        
        int middleIndex = end - start == 1 ? end : (start + end) / 2;
        
        TreeNode root = new TreeNode(list.get(middleIndex));
        
        root.left = toBST(list, start, middleIndex - 1);
        root.right = toBST(list, middleIndex + 1, end);
        
        return root;
    }
    
    private List<Integer> toList(ListNode node) {
        List<Integer> list = new ArrayList<>();
        
        while(node != null) {
            list.add(node.val);
            node = node.next;
        }
        
        return list;
    }
    
    public void test() {
        sortedListToBST(ListNode.Builder.build(new int[]{-10,-3,0,5,9}));
    }
}
