package com.itheima;

import com.itheima.util.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

public class JedisTest {
    private Jedis jedis;

    @BeforeEach
    void setUp() {
       /* jedis = new Jedis("192.168.0.101",6379);*/
        jedis = JedisConnectionFactory.getJedis();
        jedis.auth("123456");
        jedis.select(0);
    }

    @Test
    void testString(){
        String set = jedis.set("name", "刀哥");
        System.out.println(set);

        String name = jedis.get("name");
        System.out.println(name);
    }

    @AfterEach
    void tearDown() {
        if (jedis != null) {
            jedis.close();
        }
    }
}
