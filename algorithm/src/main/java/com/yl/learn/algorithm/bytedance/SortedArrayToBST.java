package com.yl.learn.algorithm.bytedance;

import com.yl.learn.algorithm.TreeNode;
import junit.framework.TestCase;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortedArrayToBST extends TestCase {
    // -10,-3,0,5,9
    public TreeNode sortedArrayToBST(int[] nums) {
        return toBST(nums, 0, nums.length - 1);
    }
    
    private TreeNode toBST(int[] nums, int start, int end) {
        if(start > end) return null;
        if(start == end) return new TreeNode(nums[start]);
        int middle = (start + end) / 2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = toBST(nums, start, middle - 1);
        node.right = toBST(nums, middle + 1, end);
        return node;
    }
    
    
}
