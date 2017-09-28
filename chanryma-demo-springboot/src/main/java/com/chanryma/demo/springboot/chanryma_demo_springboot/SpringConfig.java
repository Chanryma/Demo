package com.chanryma.demo.springboot.chanryma_demo_springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.chanryma.demo.springboot.chanryma_demo_springboot")
public class SpringConfig {

    @Bean
    public UserDAO getUserDAO() {
        return new UserDAO();
    }
}
