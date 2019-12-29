package com.moliniao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.moliniao.mapper")
@EnableEurekaClient
@EnableCircuitBreaker
public class MoliniaoProviderHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoliniaoProviderHystrixApplication.class, args);
    }

}
