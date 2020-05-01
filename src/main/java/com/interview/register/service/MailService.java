package com.interview.register.service;

import com.sun.mail.smtp.SMTPTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class MailService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String SMTP_SERVER = "smtp server ";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";

    private static final String EMAIL_FROM = "From@gmail.com";

    private SMTPTransport smtpTransport;

    private Session session;

    private MailService() {
        Properties prop = System.getProperties();
        prop.put("mail.smtp.host", SMTP_SERVER); //optional, defined in SMTPTransport
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.port", "25"); // default port 25
        session = Session.getInstance(prop, null);
    }

    public void sendRegisterSuccess(String mailAddress) {
        this.sendMail(mailAddress, "Register success", "Register success");
        logger.info("send register success");
    }

    public void sendCoupon(String mailAddress) {
        this.sendMail(mailAddress, "send coupon", "send coupon");
        logger.info("send coupon");
    }

    private void sendMail(String mailAddress, String content, String subject) {
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(EMAIL_FROM));

            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(mailAddress, false));
            msg.setSubject(subject);
            msg.setText(content);
            smtpTransport = (SMTPTransport) session.getTransport("smtp");
            smtpTransport.connect(SMTP_SERVER, USERNAME, PASSWORD);
            smtpTransport.sendMessage(msg, msg.getAllRecipients());
        } catch (Exception e) {
            logger.info(e.toString());
        } finally {
            try {
                smtpTransport.close();
            } catch (Exception e) {
            }
        }
    }
}
