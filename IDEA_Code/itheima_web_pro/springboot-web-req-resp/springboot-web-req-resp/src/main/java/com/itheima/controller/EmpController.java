package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import com.itheima.service.impl.EmpServiceA;
import com.itheima.utils.XmlParserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {
    @Autowired
    private EmpService empService;
    @RequestMapping("/listEmp")
    public Result listEmp() {
        List<Emp> empList = empService.listEmp();
        return Result.success(empList);
    }
   /* public Result listEmp() {
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);

        empList.stream().forEach(emp -> {
            String gender = emp.getGender();
            if("1".equals(gender)){
                emp.setGender("男");
            } else if("2".equals(gender)){
                emp.setGender("女");
            }
        });

        empList.stream().forEach(emp -> {
            String job = emp.getJob();
            if("1".equals(job)){
                emp.setJob("讲师");
            } else if("2".equals(job)){
                emp.setJob("班主任");
            } else if("3".equals(job)){
                emp.setJob("就业指导");
            }
        });

        return Result.success(empList);
    }*/
}
