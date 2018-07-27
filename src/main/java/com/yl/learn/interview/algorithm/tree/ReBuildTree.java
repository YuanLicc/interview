package com.yl.learn.interview.algorithm.tree;

import com.yl.learn.interview.tree.TreeNode;

public class ReBuildTree {

    public static TreeNode reConstructBinaryTree(int [] pre, int [] in) {

        return  reConstructBinaryTree(pre, 0, pre.length - 1
                , in, 0, in.length - 1);
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int subtreeRootStart, int subtreeRootEnd
            , int[] in, int subTreeStart, int subTreeEnd) {

        if(subtreeRootStart > subtreeRootEnd) {
            return null;
        }
        int subtreeRootValue = pre[subtreeRootStart];
        TreeNode subtreeRoot = new TreeNode(subtreeRootValue);

        int count = 0;
        for(int i = subTreeStart; i <= subTreeEnd; i++) {
            count++;
            if(subtreeRootValue == in[i]) {
                subtreeRoot.left = reConstructBinaryTree(pre, subtreeRootStart + 1
                        , subtreeRootStart + count - 1, in, subTreeStart, i - 1);

                subtreeRoot.right = reConstructBinaryTree(pre, subtreeRootStart + count
                        , subtreeRootEnd, in, i + 1, subTreeEnd);
                break;
            }
        }
        return subtreeRoot;
    }

}
