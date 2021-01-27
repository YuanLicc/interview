package com.yl.learn.source;

import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;

public class HashSetTest extends TestCase {
    
    private static Logger logger = LoggerFactory.getLogger(HashSetTest.class);
    
    public void testAdd() {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1);
        
        set.forEach(k -> logger.info(k.toString()));
    }
    
    // 思考：
    // 1) HashSet 利用 hashmap 实现，访问速度快，但是却浪费内存，
    // 因为 hashmap 中 value 部分虽说为 null，但是作为引用类型本身是要占位的
}
