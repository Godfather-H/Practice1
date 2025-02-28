package com.itheima.service;

import com.itheima.pojo.PageBean;
import com.itheima.pojo.User;

public interface UserService {
    PageBean<User> selectAll();

    PageBean<User> list(Integer pageNum, Integer pageSize, String sex, String degree, String area);
}
