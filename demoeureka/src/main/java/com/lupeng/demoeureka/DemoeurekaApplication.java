package com.lupeng.demoeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DemoeurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoeurekaApplication.class, args);
    }

}
