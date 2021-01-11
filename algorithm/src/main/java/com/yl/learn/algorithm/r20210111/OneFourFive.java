package com.yl.learn.algorithm.r20210111;

import com.yl.learn.algorithm.NodeUtils;
import com.yl.learn.algorithm.TreeNode;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 *  示例:
 *  输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 *  进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *  Related Topics 栈 树
 */
public class OneFourFive extends TestCase {
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return Collections.emptyList();
        
        return pos(root);
    }
    
    private List<Integer> pos(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Boolean> booleanStack = new Stack<>();
        
        List<Integer> rs = new ArrayList<>();
        TreeNode cur = root;
        
        while (cur != null || !stack.isEmpty()) {
            if(cur != null) {
                stack.push(cur);
                booleanStack.push(false);
                cur = cur.left;
            }
            else {
                cur = stack.peek();
                if (cur.right != null && !booleanStack.peek()) {
                    cur = cur.right;
                    booleanStack.pop();
                    booleanStack.push(true);
                }
                else {
                    cur = null; // 注意，赋值为空
                    rs.add(stack.pop().val);
                    booleanStack.pop();
                }
            }
        }
        
        return rs;
    }
    
    public void test() {
        TreeNode roo = new TreeNode(1);
        TreeNode ri = new TreeNode(2);
        ri.left = new TreeNode(3);
        roo.right = ri;
        
        pos(roo);
    }
}

