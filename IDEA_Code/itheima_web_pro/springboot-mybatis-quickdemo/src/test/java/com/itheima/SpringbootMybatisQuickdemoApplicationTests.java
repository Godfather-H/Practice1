package com.itheima;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisQuickdemoApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testListener(){
        List<User> all = userMapper.findAll();
        all.stream().forEach(System.out::println);
    }
}
