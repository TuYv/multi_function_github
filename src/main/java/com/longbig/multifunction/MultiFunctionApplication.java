package com.longbig.multifunction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.longbig.multifunction.up.mapper")
public class MultiFunctionApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiFunctionApplication.class, args);
    }

}
