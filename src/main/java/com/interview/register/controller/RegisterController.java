package com.interview.register.controller;

import com.google.gson.JsonObject;
//import com.interview.register.entity.RegisterUser;
import com.interview.register.entity.User;
//import com.interview.register.repository.RegisterRepository;
import com.interview.register.service.MailService;
import com.interview.register.service.RegisterService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RegisterController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RegisterService registerService;

    @Autowired
    private MailService mailService;

//    @Autowired
////    private RegisterRepository registerRepository;

    @PostMapping("/amazing-talker/register")
    public Object register(@RequestBody User user) {



        System.out.println(user.getEmail());

        JsonObject response = new JsonObject();

        if (!registerService.checkEmail(user)) { // return error message
            return this.returnErrorObject(response);
        }

        //sending mail
        mailService.sendRegisterSuccess(user.getEmail());
        mailService.sendCoupon(user.getEmail());


//        RegisterUser registerUser = new RegisterUser();
//
//        registerUser.setEmail(user.getEmail());
//        registerUser.setName(user.getName());
//        registerUser.setPassword(user.getPassword());


        // set email as unique column here
//        try {
////            response.addProperty("token", registerRepository.save(registerUser).getId());
//        } catch (Exception e) {
//            logger.debug(e.toString());
//            return this.returnErrorObject(response);
//        }
        return response;
    }


    private Object returnErrorObject(JsonObject response) {
        response.addProperty("error", "error message");
        return response;
    }

}
