package com.yl.learn.map;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

public class MapTest extends TestCase {
    public void testMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);

        Integer c = map.computeIfAbsent("c", (key) -> key.hashCode() * -1);
        PrintUtil.println(c);

        Integer d = map.compute("a", (key, value) -> key.hashCode() + value);
        PrintUtil.println(d);

        map.forEach(
                (key, value) -> {
                    PrintUtil.println(key + ":" + value);
                }
        );
    }
}
