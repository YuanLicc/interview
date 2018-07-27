package com.zh.learn.interview.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hong on 2018/7/26.
 * 对map的test
 */
public class MapTest {
    public static void main(String[] args) {
        hashMapTest();
    }

    /**
     * 测试方法
     */
    public static void hashMapTest() {
        Map<String, String> map = new HashMap<Strigng, String>();

        map.put("first", "this is the first word");
        map.put("second", "this is the second");

        System.out.println(map.get("first"));
    }

    /**
     * hashmap为空测试
     */
    @Test
    public void hashMapNullTest() {
        Map<String, String> map = new HashMap<>();
        String value = map.put(null, "This is a null value");
        String value2 = map.put("value2Key", "value2Value");
        System.out.println("判断成功则出现passed");
        org.junit.Assert.assertTrue(value == null);
    }
}
