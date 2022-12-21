package com.pet.petmanagement.business.login;

import com.pet.petmanagement.domain.user.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginController {

@Resource
    private LoginService loginService;

    @GetMapping("/login")
    public User login (@RequestParam String username, @RequestParam String password) {
        User user = loginService.login(username, password);
        return user;


    }

}
