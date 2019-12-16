package com.moliniao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.moliniao.mapper")
public class MoliniaoProviderFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoliniaoProviderFeignApplication.class, args);
    }

}
