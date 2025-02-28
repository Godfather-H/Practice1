package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private String sex;
    private String height;
    private String weight;
    private String degree;
    private String job;
    private String area;
    private int income;
    private String hobby;

    public User(String name, int age, String sex, String height, String weight, String degree, String job, String area, int income, String hobby) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
        this.degree = degree;
        this.job = job;
        this.area = area;
        this.income = income;
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", degree='" + degree + '\'' +
                ", job='" + job + '\'' +
                ", area='" + area + '\'' +
                ", income=" + income +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
