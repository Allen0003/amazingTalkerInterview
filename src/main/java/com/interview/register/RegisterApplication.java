package com.interview.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class RegisterApplication {


    public static void main(String[] args) {
        SpringApplication.run(RegisterApplication.class, args);
    }
}
