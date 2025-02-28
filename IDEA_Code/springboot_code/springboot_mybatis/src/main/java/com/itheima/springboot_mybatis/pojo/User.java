package com.itheima.springboot_mybatis.pojo;

import lombok.*;

@Getter
@Setter
@ToString
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private Integer gender;
    private String phone;
}
