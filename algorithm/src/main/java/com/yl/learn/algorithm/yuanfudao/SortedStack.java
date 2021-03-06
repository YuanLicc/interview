package com.yl.learn.algorithm.yuanfudao;

import java.util.Stack;

/**
 * 栈排序。
 * 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，
 * 但不得将元素复制到别的数据结构（如数组）中。
 * 该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
 */
public class SortedStack {
    
    private Stack<Integer> cache;
    
    public SortedStack() {
        cache = new Stack<>();
    }
    
    public void push(int val) {
        Stack<Integer> fuzhu = new Stack<>();
        
        while (!cache.isEmpty() && cache.peek() < val) {
            fuzhu.push(cache.pop());
        }
        cache.push(val);
        
        while (!fuzhu.isEmpty()) {
            cache.push(fuzhu.pop());
        }
    }
    
    public void pop() {
        if(cache.isEmpty()) return;
        cache.pop();
    }
    
    public int peek() {
        if(cache.isEmpty()) return -1;
        return cache.peek();
    }
    
    public boolean isEmpty() {
        return cache.isEmpty();
    }
}
