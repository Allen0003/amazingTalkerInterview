package com.interview.register.controller;

import com.google.gson.JsonObject;
import com.interview.register.entity.User;
import com.interview.register.enums.SourceEnum;
import com.interview.register.service.MailService;
import com.interview.register.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RegisterController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private MailService mailService;


    @PostMapping("/amazing-talker/register")
    public Object register(@RequestBody User user) {
        if (user.getSource().equals(SourceEnum.None)) {
            return this.doRegister(user);
        }

        if (user.getSource().equals(SourceEnum.Facebook) || user.getSource().equals(SourceEnum.Google)) {
            return this.doThirdPartyRegister(user);
        }

        return null;
    }

    private Object doThirdPartyRegister(User user) {

        // some questions here
        // 1. Who will give me authorize code
        // 2. do I need to connect to third party myself, or that is the issue for front end


        JsonObject response = new JsonObject();

        if (!userServiceImpl.isRegister(user)) {
            return this.returnErrorObject(response);
        }

        return null;

    }


    private Object doRegister(User user) {
        JsonObject response = new JsonObject();

        if (!userServiceImpl.checkEmail(user)) { // return error message
            return this.returnErrorObject(response);
        }

        //sending mail
        mailService.sendRegisterSuccess(user.getEmail());
        mailService.sendCoupon(user.getEmail());


        // set email as unique column here
        try {
            response.addProperty("token", userServiceImpl.save(user).getId());
        } catch (Exception e) {
            logger.debug(e.toString());
            return this.returnErrorObject(response);
        }
        return response;
    }


    private Object returnErrorObject(JsonObject response) {
        response.addProperty("error", "error message");
        return response;
    }

}
