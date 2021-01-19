package com.yl.learn.concurrent.cnt;

import com.yl.learn.util.util.PrintUtil;

import java.util.concurrent.CountDownLatch;

public class Counter implements Runnable {
    
    CountDownLatch countDownLatch;
    WordCountWorker[] workers;
    
    public Counter(CountDownLatch countDownLatch, WordCountWorker[] workers) {
        this.countDownLatch = countDownLatch;
        this.workers = workers;
    }
    
    @Override
    public void run() {
        try {
            while (countDownLatch.getCount() != 0) {
                PrintUtil.println(System.currentTimeMillis() + ":" + sum());
                Thread.sleep(100);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            PrintUtil.println(System.nanoTime() + ":" + sum());
        }
    }
    
    private int sum() {
        int sum = 0;
        for (WordCountWorker worker : workers) {
            sum += worker.getCnt();
        }
        return sum;
    }
}
