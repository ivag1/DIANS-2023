package com.example.places.placesmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PlacesMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlacesMicroserviceApplication.class, args);
    }

}
