package com.moliniao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer        // EurekaServer服务端启动类，接受其他服务注册进来
public class MoliniaoEurekaServerThreeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoliniaoEurekaServerThreeApplication.class, args);
    }

}
