package com.yl.learn.redis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisUtil {

    public static Jedis jedis(String host, int port) {
        HostAndPort hp = new HostAndPort(host, port);
        return new Jedis(hp);
    }
    
    public static JedisPool jedisPool(String host, int port) {
        return new JedisPool(host, port);
    }
    
    
}
