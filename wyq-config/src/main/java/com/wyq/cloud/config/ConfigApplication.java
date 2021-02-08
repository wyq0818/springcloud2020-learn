package com.wyq.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
 * @Author:wuyongqiang
 * @Date:2021-02-07 11:09:11:09
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer //启用配置中心
@EnableFeignClients
public class ConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class,args);
    }
}
