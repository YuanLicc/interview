package com.yl.learn.redis.test;

import com.yl.learn.redis.RedisUtil;
import com.yl.learn.redis.SimpleLock;
import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;
import redis.clients.jedis.Jedis;

import java.util.concurrent.CountDownLatch;

public class RedisTests extends TestCase {
    
    public void testGetJedis() {
        Jedis jedis = RedisUtil.jedis("127.0.0.1", 6379);
        
        String key = "yl:learn:test:get";
        assert jedis.setnx(key, "1") != 0;
        jedis.del(key);
        jedis.close();
    }
    
    public void testSimpleLock() throws InterruptedException {
        int lock = 3;
        SimpleLock simpleLock = new SimpleLock();
        CountDownLatch latch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            new Thread(new SimpleLockRun(lock, simpleLock, latch)).start();
        }
        latch.await();
    }
    
    
    class SimpleLockRun implements Runnable {
    
        private int lock;
        
        private SimpleLock simpleLock;
        
        CountDownLatch latch;
        SimpleLockRun(int lock, SimpleLock simpleLock, CountDownLatch latch) {
            this.lock = lock;
            this.simpleLock = simpleLock;
            this.latch = latch;
        }
        
        @Override
        public void run() {
            PrintUtil.println(Thread.currentThread().toString() + " start get lock");
            simpleLock.lock(lock);
            PrintUtil.println(Thread.currentThread().toString() + " got lock");
            PrintUtil.println(simpleLock.unlock(lock));
            latch.countDown();
            
        }
    }
}
