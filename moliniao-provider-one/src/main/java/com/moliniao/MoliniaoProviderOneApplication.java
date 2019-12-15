package com.moliniao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.moliniao.mapper")
@EnableEurekaClient         // 本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient
public class MoliniaoProviderOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoliniaoProviderOneApplication.class, args);
    }

}
