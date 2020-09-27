package com.yl.learn.algorithm.bytedance;

import com.yl.learn.algorithm.TreeNode;
import junit.framework.TestCase;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）105
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuildBT extends TestCase {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1);
    }

    int i = 0;
    private TreeNode buildTree(int[] preorder, int[] inorder, int start, int end) {
        if(start > end) return null;
        TreeNode node = new TreeNode(preorder[i]);
        if(start == end) return node;
        int index = index(inorder, preorder[i], start, end);
        if(index - start >= 1) {
            i++;
            node.left = buildTree(preorder, inorder, start, index - 1);
        }
        if(end - index >= 1) {
            i++;
            node.right = buildTree(preorder, inorder, index + 1, end);
        }
        return node;
    }

    private int index(int[] arr, int target, int start, int end) {
        for(int i = start; i <= end; i++) {
            if(target == arr[i]) return i;
        }
        return -1;
    }

    public void test() {
        buildTree(new int[]{3,1,2,4}, new int[]{1,2,3,4});
    }
}
