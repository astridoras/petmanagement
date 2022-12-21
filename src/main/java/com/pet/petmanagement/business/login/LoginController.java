package com.pet.petmanagement.business.login;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginController {

@Resource
    private LoginService loginService;

    public void login (String username, String password) {

    }

}
