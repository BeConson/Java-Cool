package com.conson.stealing;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("com.conson.stealing.dao")
class StealingApplicationTests {

    @Test
    void contextLoads() {
    }

}
