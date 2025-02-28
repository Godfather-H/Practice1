package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.UserMapper;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.UnaryOperator;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageBean<User> selectAll() {
        //1.创建PageBean对象
        PageBean<User> pb = new PageBean<>();
        List<User> users = userMapper.selectAll();
        Long total = (long) users.size();
        pb.setItems(users);
        pb.setTotal(total);
        return pb;
    }

    @Override
    public PageBean<User> list(Integer pageNum, Integer pageSize, String sex, String degree, String area) {
        //1.创建PageBean对象
        PageBean<User> pb = new PageBean<>();

        //开启分页查询，PageHelper
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.list(sex, degree, area);
        Page<User> page = (Page<User>) users;
        pb.setTotal(page.getTotal());
        pb.setItems(page.getResult());
        //return pb;

        //统计各学历人数有多少
        Map<String, Integer> degrees = degreeCount(sex, degree, area);
        pb.setDegrees(degrees);
        return pb;
    }

    public Map<String,Integer> degreeCount(String sex, String degree, String area){
        List<User> users = userMapper.list(sex, degree, area);

        //统计各学历人数有多少
        Map<String,Integer> map = new HashMap<>();
        map.put("gaozhong",0);
        map.put("dazhuan",0);
        map.put("benke",0);
        map.put("shuoshi",0);
        map.put("boshi",0);
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getDegree().equals("高中")) {
                map.put("gaozhong",map.get("gaozhong")+1);
            } else if (users.get(i).getDegree().equals("大专")) {
                map.put("dazhuan",map.get("dazhuan")+1);
            } else if (users.get(i).getDegree().equals("本科")) {
                map.put("benke",map.get("benke")+1);
            } else if (users.get(i).getDegree().equals("硕士")) {
                map.put("shuoshi",map.get("shuoshi")+1);
            } else {
                map.put("boshi",map.get("boshi")+1); // 这个 else 可能需要根据需求调整
            }
        }
        System.out.println("本科:"+map.get("benke"));
        return map;
    }
}
