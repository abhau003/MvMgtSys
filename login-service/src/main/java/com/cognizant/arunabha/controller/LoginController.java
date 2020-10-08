package com.cognizant.arunabha.controller;

import com.cognizant.arunabha.model.LoginResponse;
import com.cognizant.arunabha.model.UserCreds;
import com.cognizant.arunabha.service.LoginService;
import com.cognizant.arunabha.service.TokenValidationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;


@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private TokenValidationService tokenValidationService;

    @RequestMapping(method= RequestMethod.POST,value="/login")
    public ResponseEntity<?> login(@RequestBody UserCreds userCredential) {
        System.out.println("UserCreds : " +userCredential);
        LoginResponse loginResponse = loginService.validateLoginCredentials(userCredential);
        if (loginResponse.getStatus().equalsIgnoreCase("success"))
            return ResponseEntity.ok().body(loginResponse);
        else
            return ResponseEntity.badRequest().body(loginResponse);
    }

    @RequestMapping(method= RequestMethod.GET, value = "/validate")
    String validateToken(HttpServletRequest request){
        return tokenValidationService.validateToken(request.getHeader("Authorization"));
    }
}
