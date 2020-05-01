package com.interview.register.service;

import com.interview.register.entity.User;
import org.springframework.stereotype.Component;

@Component
public class RegisterService {
    public boolean checkEmail(User user) {
        return user != null && user.getEmail() != null && user.getReEnterPassword() != null &&
                isValidEmailAddress(user.getEmail()) && user.getEmail().length() < 8 && user.getEmail().equals(user.getReEnterPassword());
    }

    private boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }


}
