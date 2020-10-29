package com.usian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

@EnableScheduling
@SpringBootApplication
@MapperScan("com.usian.dao")//注意MapperScan要导tk的包，不然会报NoSuchMethodException
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
