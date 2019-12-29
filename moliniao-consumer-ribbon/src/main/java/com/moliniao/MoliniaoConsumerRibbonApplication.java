package com.moliniao;

import LoadBalance.config.CustomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@EnableEurekaClient
@SpringBootApplication
@RibbonClient(name = "moliniao-provider-ribbon",configuration = CustomRule.class)
public class MoliniaoConsumerRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoliniaoConsumerRibbonApplication.class, args);
    }

}
