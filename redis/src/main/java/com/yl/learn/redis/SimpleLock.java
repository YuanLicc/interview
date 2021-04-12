package com.yl.learn.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class SimpleLock extends AbstractQueuedSynchronizer {
    
    private static JedisPool jedis = RedisUtil.jedisPool("127.0.0.1", 6379);
    
    private static String lockPrefix = "yl:learn:simple:lock:";
    
    public boolean tryAcquire(int lockName) {
        Long rs = jedis.getResource().setnx(lockPrefix + lockName, String.valueOf(Thread.currentThread().getId()));
        return rs == 1;
    }
    
    public boolean tryRelease(int lockName) {
        Long rs = jedis.getResource().del(lockPrefix + lockName);
        return rs == 1;
    }
    
    public void lock(int lockName) {
        acquire(lockName);
    }
    
    public boolean unlock(int lockName) {
        return release(lockName);
    }
}
