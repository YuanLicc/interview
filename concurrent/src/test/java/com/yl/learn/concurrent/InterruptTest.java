package com.yl.learn.concurrent;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

public class InterruptTest extends TestCase {

    public void testStop() {
        Thread t1 = new Thread(() -> {
            while(true) {
                PrintUtil.println(1);
            }
        });
        t1.start();
        t1.stop();
    }

    class ThreadNew extends Thread {

        private volatile boolean isStop = false;

        public void run() {
            while(isStop) {
                PrintUtil.println(1);
            }
        }

        public void stop1() {
            isStop = true;
        }
    }

    public void testStop1() throws Exception {
        ThreadNew t1 = new ThreadNew();
        t1.start();
        Thread.sleep(1000);
        t1.stop1();
    }

}
