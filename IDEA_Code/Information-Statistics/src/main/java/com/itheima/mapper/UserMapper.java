package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    void insertUser(User user);

    @Select("select * from user")
    List<User> selectAll();

    List<User> list(String sex, String degree, String area);
}
