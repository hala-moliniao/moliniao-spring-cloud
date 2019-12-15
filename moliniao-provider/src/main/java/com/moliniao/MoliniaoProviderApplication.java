package com.moliniao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.moliniao.mapper")
public class MoliniaoProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoliniaoProviderApplication.class, args);
    }

}
