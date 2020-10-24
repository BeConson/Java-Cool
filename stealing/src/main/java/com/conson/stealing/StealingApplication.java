package com.conson.stealing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 康森
 */
@SpringBootApplication
@MapperScan("com.conson.stealing.dao")
public class StealingApplication {

    public static void main(String[] args) {
        SpringApplication.run(StealingApplication.class, args);
    }

}
