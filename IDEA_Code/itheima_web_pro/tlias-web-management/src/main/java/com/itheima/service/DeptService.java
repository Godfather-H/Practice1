package com.itheima.service;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Updater;

import java.util.List;

public interface DeptService {
    //查询全部部门信息
    List<Dept> list();

    //根据Id删除部门
    void delete(Integer id);

    //新增部门
    void insert(Dept dept);

    Dept select(Integer id);

    void alter(Updater updater);
}
