package com.yl.learn.algorithm.r20210111;

/**
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 *  示例:
 *
 *  Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 *
 *  说明:
 *
 *
 *  你可以假设所有的输入都是由小写字母 a-z 构成的。
 *  保证所有输入均为非空字符串。
 *
 */
public class TwoZeroEight {
    
    class Node {
        public boolean wordEnd;
        public Node[] nextLevel;
        
        Node() {
            nextLevel = new Node[26];
        }
    }
    
    private Node root;
    
    /** Initialize your data structure here. */
    public TwoZeroEight() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        Node[] level = root.nextLevel;
        for (int i = 0; i < chars.length - 1; i++) {
            if(level[chars[i] - 'a'] == null) level[chars[i] - 'a'] = new Node();
            level = level[chars[i] - 'a'].nextLevel;
        }
        if(level[chars[chars.length - 1] - 'a'] == null) level[chars[chars.length - 1] - 'a'] = new Node();
        level[chars[chars.length - 1] - 'a'].wordEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        Node[] level = root.nextLevel;
        for (int i = 0; i < chars.length - 1; i++) {
            if(level[chars[i] - 'a'] == null) return false;
            level = level[chars[i] - 'a'].nextLevel;
        }
        if(level[chars[chars.length - 1] - 'a'] == null || !level[chars[chars.length - 1] - 'a'].wordEnd) return false;
        return true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        Node[] level = root.nextLevel;
        
        for (int i = 0; i < chars.length; i++) {
            if(level[chars[i] - 'a'] == null) return false;
            level = level[chars[i] - 'a'].nextLevel;
        }
        return true;
    }
    
}
