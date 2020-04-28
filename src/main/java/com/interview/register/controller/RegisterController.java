package com.interview.register.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import com.interview.register.entity.User;

@RestController
public class RegisterController {

//    @GetMapping("/amazing-talker/register")
    @PostMapping("/amazing-talker/register")
//    @PathVariable User registerUser
    public User findById() {

        System.out.println(" hello ~~ ");

        return null;
//
//        return this.userFeignClient.findById(id);
//        return this.restTemplate.getForObject("http://localhost:8000/users/{id}", User.class, id);
    }

}
