package com.xgxz.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceProvider8081Application {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProvider8081Application.class, args);
    }

}
