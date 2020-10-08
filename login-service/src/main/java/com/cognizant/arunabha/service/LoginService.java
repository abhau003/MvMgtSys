package com.cognizant.arunabha.service;

import com.cognizant.arunabha.dao.LoginDao;
import com.cognizant.arunabha.model.LoginResponse;
import com.cognizant.arunabha.model.UserCreds;
import com.cognizant.arunabha.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private AppUserDetailsService appUserDetailsService;

    @Autowired
    private LoginDao loginDao;

    @Autowired
    private JwtUtil jwtUtil;

    public LoginResponse validateLoginCredentials(UserCreds userCredential) {

        System.out.println("LoginService.validateLoginCredentials,userCredential: " +userCredential);
        Boolean validResponse = loginDao.login(userCredential);
        LoginResponse loginResponse = new LoginResponse();
        if (validResponse) {
            appUserDetailsService.setUserCredentials(userCredential);
            final UserDetails userDetails = appUserDetailsService.loadUserByUsername(userCredential.getUsername());
            final String jwtToken = jwtUtil.generateToken(userDetails);
            loginResponse.setJwt(jwtToken);
            loginResponse.setStatus("success");
            loginResponse.setUserName(userCredential.getUsername());
            loginResponse.setRole(userCredential.getRole());
            loginResponse.setMessage("Welcome to Movie Booking : " +userCredential.getUsername());
        } else
            loginResponse.setStatus("failure");

        return loginResponse;
    }
}
