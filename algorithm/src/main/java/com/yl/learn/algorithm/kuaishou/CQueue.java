package com.yl.learn.algorithm.kuaishou;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 *
 * 来源：力扣（LeetCode）offer 09
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CQueue {
    Stack<Integer> stack, help;
    public CQueue() {}
    public void appendTail(int value) {
        if(stack == null) {
            stack = new Stack<>();
        }
        else {
            if(help != null) {
                while (!help.isEmpty()) {
                    stack.push(help.pop());
                }
            }
        }
        stack.push(value);
    }

    public int deleteHead() {
        if(help == null) help = new Stack<>();
        if(stack != null ) {
            while (!stack.isEmpty()) {
                help.push(stack.pop());
            }
        }
        if(help.isEmpty()) return -1;
        return help.pop();
    }
}
