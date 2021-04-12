package com.yl.learn.concurrent;

import junit.framework.TestCase;

import java.util.concurrent.atomic.AtomicMarkableReference;

public class ABATests extends TestCase {

    public void test() {
        AtomicMarkableReference<Integer> atomicInteger = new AtomicMarkableReference<>(10, true);
        atomicInteger.compareAndSet(10, 20, true, false);
        System.out.println(atomicInteger.get(new boolean[] {false}));
    }

}
