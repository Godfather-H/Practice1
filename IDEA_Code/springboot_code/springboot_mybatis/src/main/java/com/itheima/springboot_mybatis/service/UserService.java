package com.itheima.springboot_mybatis.service;

import com.itheima.springboot_mybatis.pojo.User;

public interface UserService {

    public User findById(Integer id);
}
