package com.itheima.service.impl;

import com.itheima.dao.EmpDao;
import com.itheima.dao.impl.EmpDaoA;
import com.itheima.pojo.Emp;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmpServiceA implements EmpService {
    @Autowired
    private EmpDao empDao;
    @Override
    public List<Emp> listEmp() {
        List<Emp> empList = empDao.listEmp();
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
    return empList;
    }
}
