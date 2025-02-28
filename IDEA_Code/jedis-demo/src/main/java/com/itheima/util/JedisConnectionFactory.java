package com.itheima.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisConnectionFactory {
    private static final JedisPool jedispool;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(8);
        config.setMaxIdle(8);
        config.setMinIdle(2);
        config.setMaxWaitMillis(1000);
        jedispool = new JedisPool(config, "192.168.0.101", 6379, 100, "123456");
    }

    public static Jedis getJedis() {
        return jedispool.getResource();
    }
}
