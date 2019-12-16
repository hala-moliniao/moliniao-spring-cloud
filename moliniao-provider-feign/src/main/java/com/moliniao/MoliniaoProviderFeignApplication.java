package com.moliniao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MoliniaoProviderFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoliniaoProviderFeignApplication.class, args);
    }

}
