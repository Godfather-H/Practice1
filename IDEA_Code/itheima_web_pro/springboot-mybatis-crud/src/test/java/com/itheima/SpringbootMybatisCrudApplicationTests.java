package com.itheima;

import com.itheima.mapper.mapperDemo;
import com.itheima.pojo.user;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

@SpringBootTest
class SpringbootMybatisCrudApplicationTests {
    @Autowired
    private mapperDemo mapper;

    @Test
    public void test(){
        mapper.delete(17);
    }

    @Test
    public void testInsert(){
        user emp = new user();
        emp.setUsername("Tom");
        emp.setName("汤姆");
        emp.setImage("1.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);
        emp.setEntrydate(LocalDate.of(2000,1,1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        mapper.insert(emp);
    }

    @Test
    public void testUpdate(){
        user emp = new user();
        emp.setId(18);
        emp.setUsername("Tomi");
        emp.setName("汤米");
        emp.setImage("1.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);
        emp.setEntrydate(LocalDate.of(2000,1,1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        mapper.update(emp);
    }

    @Test
    public void testSelect(){
        Integer id = 18;
        user select = mapper.select(id);
        System.out.println(select);
    }

    @Test
    public void testList(){
        List<user> list = mapper.list(null,(short)1,LocalDate.of(2010,1,1),LocalDate.of(2020,1,1));
        System.out.println(list);
    }

    @Test
    public void testupdateDynamically(){
        mapper.updateDynamically("张有忌",null,null,null,null,null,null,null,2);
        user select = mapper.select(2);
        System.out.println(select);
    }
}
