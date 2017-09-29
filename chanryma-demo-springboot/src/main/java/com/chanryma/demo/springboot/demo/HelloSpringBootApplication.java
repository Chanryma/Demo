package com.chanryma.demo.springboot.demo;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
@Configuration
public class HelloSpringBootApplication {

    @RequestMapping("hello")
    @ResponseBody
    public String sayHello() {
        return "Hello.";
    }

    @RequestMapping("bye")
    @ResponseBody
    public String sayBye() {
        return "Bye.";
    }

    public static void main(String[] args) {
//        SpringApplication.run(HelloSpringBootApplication.class, args);
        SpringApplication application = new SpringApplication(HelloSpringBootApplication.class);
        application.setBannerMode(Mode.OFF);
        application.run(args);
    }
}
