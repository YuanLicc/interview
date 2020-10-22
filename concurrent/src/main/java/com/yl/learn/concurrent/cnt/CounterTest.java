package com.yl.learn.concurrent.cnt;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CounterTest {
    
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 10, 1000, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10));
        CountDownLatch countDownLatch = new CountDownLatch(4);
        WordCountWorker[] workers = new WordCountWorker[4];
        for(int i = 0; i < 4; i++) {
            WordCountWorker worker = new WordCountWorker("word.txt", countDownLatch);
            workers[i] = worker;
            pool.execute(worker);
        }
        pool.execute(new Counter(countDownLatch, workers));
        pool.shutdown();
    }
}
