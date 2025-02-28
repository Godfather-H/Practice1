package com.itheima.controller;

import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/allInformation")
    public Result<PageBean<User>> selectAll(){
        PageBean<User> pb = userService.selectAll();
        return Result.success(pb);
    }

    @GetMapping("/list")
    public Result<PageBean<User>> list(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) String sex,
            @RequestParam(required = false) String degree,
            @RequestParam(required = false) String area
    ){
        PageBean<User> pb = userService.list(pageNum,pageSize,sex,degree,area);
        return Result.success(pb);
    }
}
