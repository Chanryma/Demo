package com.chanryma.demo.springboot.chanryma_demo_springboot;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean(UserService.class);
        List<User> users = userService.getUserList();
        for (User user : users) {
            System.out.println(user.getUserId() + "--" + user.getUserName());
        }

        context.close();
        context.destroy();
    }
}
