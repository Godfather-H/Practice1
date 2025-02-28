package com.itheima.springboot_mybatis.service.impl;

import com.itheima.springboot_mybatis.mapper.UserMapper;
import com.itheima.springboot_mybatis.pojo.User;
import com.itheima.springboot_mybatis.service.UserService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }
}
