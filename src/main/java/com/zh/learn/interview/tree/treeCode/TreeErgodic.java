package com.zh.learn.interview.tree.treeCode;

import com.zh.learn.interview.tree.treeUtil.BinaryTree;

import java.util.Stack;

/**
 * Created by hong on 2018/8/1.
 * 关于树的遍历方法
 */
public class TreeErgodic {

    /**
     * 先序遍历递归算法
     */
    public static void preRecursion(BinaryTree root) {
        if(root == null) {
            return;
        }
        root.visit();
        preRecursion(root.lChild);
        preRecursion(root.rChild);
    }

    /**
     * 先序遍历非递归算法
     * @param root
     */
    public static void preNonRecursion(BinaryTree root) {
        Stack<BinaryTree> stack = new Stack<>();
        stack.push(root);
        BinaryTree node;

        while(!stack.isEmpty()) {
            node = stack.pop();
            node.visit();

            // 由于是先序遍历，所以是先访问左节点再访问右节点，此处数据结构为栈要想先访问左节点就需要先对右节点进行进栈判断，这样才能满足先进后出之后首先遍历左节点
            if(node.rChild != null) {
                stack.push(node.rChild);
            }

            if(node.lChild != null) {
                stack.push(node.lChild);
            }
        }
    }

    /**
     * 中序遍历递归算法
     */
    public static void midRecursion(BinaryTree root) {
        if(root == null) {
            return;
        }

        if(root.lChild != null) {
            midRecursion(root.lChild);
        }

        root.visit();

        if(root.rChild != null) {
            midRecursion(root.rChild);
        }
    }

    /**
     * 中序遍历非递归算法
     * @param root
     */
    public static void midNonRecursion(BinaryTree root) {
        Stack<BinaryTree> stack = new Stack<>();
        stack.push(root);
        BinaryTree node = root;

        while(!stack.isEmpty() || node != null) {
            if(node != null) {
                stack.push(node);
                node = node.lChild;
            } else {
                node = stack.pop();
                node.visit();
                node = node.rChild;
            }
        }
    }
}
