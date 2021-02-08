package com.wyq.cloud.gatewayhand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.oas.annotations.EnableOpenApi;

/*
 * @Author:wuyongqiang
 * @Date:2021-02-05 17:01:17:01
 */
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableOpenApi
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class,args);
    }
}
