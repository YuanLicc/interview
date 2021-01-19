package com.yl.learn.concurrent;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest extends TestCase {
    public void testCyclicBarrier() {
        int count = 3;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(count);

        for(int i = 0; i < count; i++) {
            new Thread(() -> {
                try {
                    cyclicBarrier.await();
                    PrintUtil.println(Thread.currentThread().getName());
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            },"thread " + i).start();
        }
    }
}
