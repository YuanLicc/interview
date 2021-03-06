package com.yl.learn.array;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class ArrayTest extends TestCase {
    public void testArray() {
        int[] array = new int[20];
        Arrays.parallelSetAll(array, i -> i);
        PrintUtil.println(array);

        IntStream.range(0, array.length).parallel().forEach(i -> array[i] = i);


        Arrays.parallelPrefix(array, Integer::sum);
        PrintUtil.println(array);
    
    }
    
    public void test() {
        Map<String, Integer> map = new HashMap<>();
    }
}
