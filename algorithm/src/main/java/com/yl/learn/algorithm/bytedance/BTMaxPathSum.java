package com.yl.learn.algorithm.bytedance;

import com.yl.learn.algorithm.TreeNode;
import com.yl.learn.algorithm.yuanfudao.BTCodec;
import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1：
 * 输入：[1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出：6
 * 示例 2：
 *
 * 输入：[-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出：42
 *
 * 来源：力扣（LeetCode）124
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BTMaxPathSum extends TestCase {
    
    int maxRs = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return maxRs;
    }
    
    private int dfs(TreeNode root) {
        if(root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int max = Math.max(root.val, root.val + left);
        max = Math.max(max, root.val + right);
        int reMax = max;
        max = Math.max(max, root.val + left + right);
        maxRs = max > maxRs ? max : maxRs;
        return reMax;
    }
    
    public void test() {
        PrintUtil.println(maxPathSum(new BTCodec().deserialize("[-10,9,20,null,null,15,7]")));
    }
}
