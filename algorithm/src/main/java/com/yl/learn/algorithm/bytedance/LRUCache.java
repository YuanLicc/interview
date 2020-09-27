package com.yl.learn.algorithm.bytedance;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。
 * 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；
 * 如果关键字不存在，则插入该组「关键字/值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 * 进阶:
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * 来源：力扣（LeetCode）146
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LRUCache extends TestCase {
    
    int capacity;
    Map<Integer, Node> cache;
    Node head;
    Node tail;
    
    public LRUCache() {}
    
    public LRUCache(int capacity) {
        this.capacity = capacity <= 0 ? 10 : capacity;
    }
    
    public int get(int key) {
        if(cache == null) return -1;
        Node node = cache.get(key);
        if(node == null) return -1;
        else {
            toHead(node);
            return node.val;
        }
    }
    
    public void put(int key, int value) {
        if(cache == null) cache = new HashMap<>(capacity);
        Node node = cache.get(key);
        if(node != null) {
            node.val = value;
            toHead(node);
        }
        else {
            node = new Node(key, value);
            if(cache.size() == capacity) {
                removeTail();
            }
            cache.put(key, node);
            add(node);
        }
    }
    
    private void add(Node node) {
        if(head == null) {
            head = node;
            tail = node;
        }
        else if(head == tail) {
            node.next = tail;
            tail.pre = node;
            head = node;
        }
        else {
            node.next = head;
            head.pre = node;
            head = node;
        }
    }
    
    private void removeTail() {
        if(tail == null) return;
        cache.remove(tail.key);
        if(head == tail) {
            head = null;
            tail = null;
        }
        else {
            Node pre = tail.pre;
            pre.next = null;
            tail = pre;
        }
    }
    
    private void toHead(Node node) {
        if(head == tail) return;
        if(node == head) return;
        if(node == tail) {
            Node tPre = tail.pre;
            tail.pre = null;
            tail.next = head;
            head.pre = tail;
            head = tail;
            tail = tPre;
        }
        else {
            Node nPre = node.pre;
            Node nNext = node.next;
            nPre.next = nNext;
            nNext.pre = nPre;
            node.pre = null;
            node.next = head;
            head.pre = node;
            head = node;
        }
    }
    
    public class Node {
        int key;
        int val;
        Node pre;
        Node next;
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    public void test1() {
        capacity = 1;
        put(2, 1);
        get(2);
        put(3, 2);
        get(2);
        get(3);
    }
    
    public void test() {
        capacity = 2;
        this.put(1, 1);
        this.put(2, 2);
        this.get(1);
        this.put(3, 3);
        this.get(2);
        this.put(4, 4);
        this.get(1);
        this.get(3);
        this.get(4);
    }
}
