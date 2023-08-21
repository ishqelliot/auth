package com.ishqelliot.auth.service;

import com.ishqelliot.auth.config.UserInfoUserDetails;
import com.ishqelliot.auth.entity.UserInfo;
import com.ishqelliot.auth.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private JwtService jwtService;

    @Override
    public String signUp(UserInfo userInfoRequest) {
        userInfoRequest.setPassword(passwordEncoder.encode(userInfoRequest.getPassword()));
        userInfoRepository.save(userInfoRequest);
        UserInfoUserDetails userInfoUserDetails = new UserInfoUserDetails(userInfoRequest);
        return jwtService.generateToken(userInfoUserDetails);
    }
}
