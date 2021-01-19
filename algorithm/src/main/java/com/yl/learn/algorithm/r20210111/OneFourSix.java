package com.yl.learn.algorithm.r20210111;

import java.util.*;

public class OneFourSix {
    
    private Map<Integer, Integer> cache;
    
    private Node head;
    
    private Node tail;
    
    private Map<Integer, Node> keyNode;
    
    private int size;
    
    private int cap;
    
    class Node {
        public Node pre, next;
        public int val;
        public Node(int val) {
            this.val = val;
        }
        public Node(int val, Node pre, Node next) {
            this(val);
            this.pre = pre;
            this.next = next;
        }
    }
    
    private void remove(int key) {
        Node node = keyNode.get(key);
        if(node == null) return;
        if(size == 1) {
            head = null;
            tail = null;
        }
        else if(node.pre == null) {
            head = head.next;
            head.pre = null;
        }
        else if(node.next == null) {
            tail = tail.pre;
            tail.next = null;
        }
        else {
            Node pre = node.pre;
            Node next = node.next;
            pre.next = next;
            next.pre = pre;
        }
        cache.remove(key);
        keyNode.remove(key);
        size--;
    }
    
    private void addFirst(int key, int value) {
        Node node = new Node(key);
        if(size == 0) {
            head = node;
            tail = node;
        }
        else {
            node.next = head;
            head.pre = node;
            head = node;
        }
        
        cache.put(key, value);
        keyNode.put(key, node);
        size++;
    }
    
    public void LRUCache(int capacity) {
        this.cap = capacity;
        cache = new HashMap<>(capacity);
        keyNode = new HashMap<>(capacity);
    }
    
    public int get(int key) {
        if(cache.isEmpty()) return -1;
        Integer get = cache.get(key);
        if (get == null) return -1;
        remove(key);
        addFirst(key, get);
        return get;
    }
    
    public void put(int key, int value) {
        Integer get = cache.get(key);
        if(get == null) {
            if(size == cap) {
                remove(tail.val);
            }
            addFirst(key, value);
        }
        else {
            remove(key);
            addFirst(key, value);
        }
    }
    
}
