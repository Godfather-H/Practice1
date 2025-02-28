package com.itheima;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class RedisStringTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void testString() {
        stringRedisTemplate.opsForValue().set("name", "龙傲甜");
        Object name = stringRedisTemplate.opsForValue().get("name");
        System.out.println(name);
    }

    private static final ObjectMapper objectMapper = new ObjectMapper();
    @Test
    void testSaveUser() throws JsonProcessingException {
        User user = new User("甜甜", 24);
        String json = objectMapper.writeValueAsString(user);
        stringRedisTemplate.opsForValue().set("user:200", json);

        String jsonUser = stringRedisTemplate.opsForValue().get("user:200");
        User user1 = objectMapper.readValue(jsonUser, User.class);
        System.out.println(user1);
    }

}
