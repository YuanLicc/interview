package com.yl.learn.algorithm.kuaishou;

import java.util.HashMap;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 *  
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * 来源：力扣（LeetCode）146
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LRUCache {
    
    int capacity;
    Map<Integer, Node> cache;
    Node head;
    Node tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity > 0 ? capacity : 10;
    }
    
    public int get(int key) {
        if(cache == null) return -1;
        Node rs = cache.get(key);
        if(rs == null) return -1;
        toHead(rs);
        return rs.val;
    }
    
    public void put(int key, int value) {
        if(cache == null) cache = new HashMap<>(this.capacity);
        Node get = cache.get(key);
        if(get != null) {
            get.val = value;
            toHead(get);
            return;
        }
        if(cache.size() == this.capacity) {
            removeTail();
        }
        addNode(key, value);
    }
    
    private void toHead(Node get) {
        if(get == head) return;
        if(head == tail) return;
        if(get == tail) {
            Node left = tail.left;
            left.right = null;
            tail.left = null;
            tail.right = head;
            head.left = tail;
            head = tail;
            tail = left;
        }
        else {
            Node left = get.left;
            Node right = get.right;
            left.right = right;
            right.left = left;
            get.left = null;
            get.right = head;
            head.left = get;
            head = get;
        }
    }
    
    private void removeTail() {
        cache.remove(tail.key);
        if(head == tail) {
            head = null;
            tail = null;
        }
        else if(tail.left == head){
            head.right = null;
            tail = head;
        }
        else {
            Node left = tail.left;
            left.right = null;
            tail = left;
        }
    }
    
    private void addNode(int key, int value) {
        Node cNode = new Node(key, value);
        cache.put(key, cNode);
        if(head == null) {
            head = cNode;
            tail = cNode;
        }
        else if(head == tail) {
            cNode.right = tail;
            tail.left = cNode;
            head = cNode;
        }
        else {
            cNode.right = head;
            head.left = cNode;
            head = cNode;
        }
    }
    
    class Node {
        int key;
        int val;
        Node left;
        Node right;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);
        lruCache.put(2, 1);
        lruCache.get(2);
        lruCache.put(3, 2);
        lruCache.get(2);
        lruCache.get(3);
    }
}
