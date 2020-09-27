package com.yl.learn.algorithm.bytedance;

import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * 来源：力扣（LeetCode）155
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> min;

    public MinStack() {
        //
    }

    public void push(int x) {
        if(stack == null) {
            stack = new Stack<>();
            min = new Stack<>();
        }
        stack.push(x);
        if(!min.isEmpty()) min.push(min.peek() < x ? min.peek() : x);
        else min.push(x);
    }

    public void pop() {
        if(stack == null || stack.isEmpty()) return;
        stack.pop();
        min.pop();
    }

    public int top() {
        if(stack == null || stack.isEmpty()) return -1;
        return stack.peek();
    }

    public int getMin() {
        if(min.isEmpty()) return -1;
        return min.peek();
    }
}
