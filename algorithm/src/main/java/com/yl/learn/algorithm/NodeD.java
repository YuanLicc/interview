package com.yl.learn.algorithm;

public class NodeD {
    public int val;
    public NodeD left;
    public NodeD right;
    
    public NodeD() {}
    
    public NodeD(int _val) {
        val = _val;
    }
    
    public NodeD(int _val,NodeD _left,NodeD _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
