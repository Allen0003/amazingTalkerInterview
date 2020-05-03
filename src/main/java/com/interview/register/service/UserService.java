package com.interview.register.service;

import com.interview.register.entity.User;

public interface UserService {
    User save(User user);

    boolean checkEmail(User user);

    boolean isRegister(User user);


}
