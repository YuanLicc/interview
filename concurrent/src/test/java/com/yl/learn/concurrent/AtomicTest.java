package com.yl.learn.concurrent;

import junit.framework.TestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest extends TestCase {
    AtomicInteger cnt = new AtomicInteger();

    public void test() throws InterruptedException{
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for(int i = 0; i < 10; i++) {
            new Thread() {
                public void run() {
                    for(int i = 0; i < 10; i++) {
                        cnt.incrementAndGet();
                    }
                    countDownLatch.countDown();
                }
            }.start();
        }
        countDownLatch.await();
        System.out.println(cnt.get());
    }
}
