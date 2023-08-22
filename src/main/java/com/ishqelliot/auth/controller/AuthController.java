package com.ishqelliot.auth.controller;

import com.ishqelliot.auth.entity.UserInfo;
import com.ishqelliot.auth.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/signup")
    public String addNewUser(@RequestBody UserInfo userInfo){
        return authenticationService.signUp(userInfo);
    }


}
