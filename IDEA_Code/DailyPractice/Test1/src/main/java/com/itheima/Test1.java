package com.itheima;

import java.util.Optional;

class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

class UserService {
    //模拟数据库中的用户
    private static User[] users = {
            new User("Alice", "alice@gmail.com"),
            new User("Bob", "bob@example.com")
    };

    public static Optional<User> findUserByName(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return Optional.of(user); //找到用户，返回Optional
            }
        }
        return Optional.empty(); //未找到用户，返回空的Optional
    }
}

public class Test1 {
    public static void main(String[] args) {
        //String userNameToFind = "Charlie";
        String userNameToFind = "Bob";
        Optional<User> userOptional = UserService.findUserByName(userNameToFind);

        //使用 ifPresent() 方法处理可能存在的用户
        userOptional.ifPresent(user -> System.out.println("Found user: " + user.getName() + ", Email: " + user.getEmail()));

        //使用 orElse() 方法提供默认方法
        User defaultUser = userOptional.orElse(new User("Default User", "default@example.com"));
        System.out.println("User email: " + defaultUser.getEmail());
    }
}