package com.moliniao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MoliniaoConsumerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoliniaoConsumerFeignApplication.class, args);
    }

}
