package com.fred.authshiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fred.authshiro.mapper")
public class AuthShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthShiroApplication.class, args);
    }
}
