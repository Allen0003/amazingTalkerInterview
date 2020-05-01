package com.interview.register.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MailService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void sendRegisterSuccess(String mail) {

        String content = "Register success";
        //TODO send mail

        logger.info("send register success");

    }

    public void sendCoupon(String mail) {

        logger.info("send coupon");
    }

    private void sendMail(String mailAddress, String content) {


    }

}
