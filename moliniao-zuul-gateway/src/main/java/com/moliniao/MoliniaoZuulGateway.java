package com.moliniao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author: created by limingzhou
 * @date: 2019/12/30
 * @description: com.moliniao
 */
@EnableZuulProxy
@SpringBootApplication
public class MoliniaoZuulGateway {
    public static void main(String[] args) {
        SpringApplication.run(MoliniaoZuulGateway.class, args);
    }
}
