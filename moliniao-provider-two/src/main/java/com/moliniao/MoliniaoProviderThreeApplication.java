package com.moliniao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.moliniao.mapper")
@EnableEurekaClient
public class MoliniaoProviderThreeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoliniaoProviderThreeApplication.class, args);
    }

}
