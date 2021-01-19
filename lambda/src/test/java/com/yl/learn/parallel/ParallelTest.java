package com.yl.learn.parallel;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelTest extends TestCase {
    public void testParallel() {
        Stream.of(1,2,3,4).parallel().map((item) -> item + 1).forEach(
                item -> {
                    PrintUtil.println(item);
                }
        );

        List<Integer> items = Arrays.asList(new Integer[]{1,2,3,4});
        items.parallelStream().forEach(
                item -> {
                    PrintUtil.println(item);
                }
        );
    }

    public void testTime() {
        int count = 10000;
        List<Double> items = randomInteger(count);
        long start = System.nanoTime();
        PrintUtil.println("serial time: " + timeSerial(items));
        PrintUtil.println("parallel time: " + timeParallel(items));
        PrintUtil.println(System.nanoTime() - start);
    }

    public long timeParallel(List<Double> items) {
        long start = System.nanoTime();
        items.parallelStream().forEach(
                item -> {
                    item = item - 1;
                }
        );
        long end = System.nanoTime();
        return end - start;
    }

    public long timeSerial(List<Double> items) {
        long start = System.nanoTime();
        items.stream().forEach(
                item -> {
                    item = item - 1;
                }
        );
        long end = System.nanoTime();
        return end - start;
    }

    public List<Double> randomInteger(int count) {
        List<Double> re = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            re.add(Math.random() * 1000000);
        }
        return re;
    }

    public void testRand() {
        int count = 100000;
        IntStream.range(0, count)
                .parallel()
                .mapToObj(
                    item -> {
                        int integer = (int)(Math.random() * 6 + 1) ;
                        int integer1 = (int)(Math.random() * 6 + 1);
                        return integer + integer1;
                    }
                ).collect(Collectors.groupingBy(item -> item))
                .forEach(
                        (key, value) -> {
                            PrintUtil.println(key + "  :  " + value.size() / (double)count);
                        }
                );
    }
}
