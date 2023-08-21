package com.ishqelliot.auth.service;

import com.ishqelliot.auth.entity.UserInfo;

public interface AuthenticationService {
    String signUp(UserInfo request);
}
