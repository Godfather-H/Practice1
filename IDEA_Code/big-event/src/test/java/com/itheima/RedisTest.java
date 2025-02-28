package com.itheima;

import com.itheima.mapper.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testSet(){
        stringRedisTemplate.opsForValue().set("hello","world");
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.set("username", "张三疯");
    }
}
