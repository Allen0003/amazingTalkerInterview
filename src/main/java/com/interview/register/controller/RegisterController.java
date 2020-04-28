package com.interview.register.controller;

import com.interview.register.entity.User;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/amazing-talker/register")
    public User findById(@RequestBody User registerUser) {

        System.out.println(registerUser.getName());
        System.out.println(" hello ~~ ");

        return null;
//
//        return this.userFeignClient.findById(id);
//        return this.restTemplate.getForObject("http://localhost:8000/users/{id}", User.class, id);
    }

}
