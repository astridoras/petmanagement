package com.pet.petmanagement.business.login;

import com.pet.petmanagement.domain.user.User;
import com.pet.petmanagement.domain.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginService {

@Resource
    private UserService userService;


    public User login(String username, String password) {
        User existingUser = userService.getExistingUser(username, password);
        return existingUser;
    }
}
