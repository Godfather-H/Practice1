package com.itheima.controller;

import com.itheima.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
public class RequestController {
    /*@RequestMapping("/simpleParam")*/
   /* public String simpleParam(HttpServletRequest request) {
        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");
        Integer age = Integer.valueOf(ageStr);
        System.out.println(name + " " + age);
        return "OK";
    }*/

   /* public String simpleParam(String name, Integer age) {
        System.out.println(name + " " + age);
        return "OK";
    }*/

    /*public String simpleParam(String username, Integer age) {
        System.out.println(username + " " + age);
        return "OK";
    }*/

    /*@RequestMapping("/complexPojo")
    public String complexPojo(User user) {
        System.out.println(user);
        return "OK";
    }*/

   /* @RequestMapping("/arrayParam")
    public String complexPojo(String[] hobby) {
        System.out.println(Arrays.toString(hobby));
        return "OK";
    }*/

    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby) {
        System.out.println(hobby);
        return "OK";
    }

    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime) {
        System.out.println(updateTime);
        return "OK";
    }

    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user) {
        System.out.println(user);
        return "OK";
    }

    @RequestMapping("/path/{id}")
    public String pathParam(@PathVariable Integer id){
        System.out.println(id);
        return "OK";
    }

    @RequestMapping("path/{id}/{name}")
    public String pathParam2(@PathVariable Integer id, @PathVariable String name){
        System.out.println(name + ":" + id);
        return "OK";
    }
}
