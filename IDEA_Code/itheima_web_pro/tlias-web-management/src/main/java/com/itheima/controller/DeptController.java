package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.pojo.Updater;
import com.itheima.service.DeptService;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private EmpService empService;

    @GetMapping
    public Result list(){
        List<Dept> data = deptService.list();
        log.info("正在查询全部部门信息...");
        return Result.success(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public Result delete(@PathVariable Integer id){
        log.info("正在删除所选部门...");
        deptService.delete(id);
        return Result.success();
    }

    @PostMapping
    public Result insert(@RequestBody Dept dept){
        log.info("正在增加新的部门...");
        deptService.insert(dept);
        return Result.success();
    }

   @GetMapping("/{id}")
    public Result select(@PathVariable Integer id){
        log.info("正在根据id查询部门信息...");
        Dept select = deptService.select(id);
        return Result.success(select);
    }

    @PutMapping
    public Result alter(@RequestBody Updater updater){
        log.info("正在修改部门信息...");
        deptService.alter(updater);
        return Result.success();
    }
}
