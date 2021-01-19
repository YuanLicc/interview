package com.yl.learn.concurrent;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest extends TestCase {
    public void testCountDownLatch() throws Exception{
        CountDownLatch countDownLatch = new CountDownLatch(20);

        for(int i = 0; i < 20; i++) {
            new Thread(new CountdownRunnable(countDownLatch), i +" thread").start();
        }
        countDownLatch.await();
        PrintUtil.println("OK");
    }

    static class CountdownRunnable implements Runnable {

        private CountDownLatch countDownLatch;

        CountdownRunnable(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            PrintUtil.println(Thread.currentThread().getName());
            this.countDownLatch.countDown();
        }
    }
}
