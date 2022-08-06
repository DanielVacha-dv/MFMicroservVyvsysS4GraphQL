package com.example.vyvsyss4graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class VyvsysS4GraphQlApplication {

    public static void main(String[] args) {
        SpringApplication.run(VyvsysS4GraphQlApplication.class, args);
    }

}
