package com.cognizant.arunabha.service;

import com.cognizant.arunabha.model.UserCreds;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class AppUserDetailsService implements UserDetailsService {

    private UserCreds userCredential;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User.UserBuilder builder = null;
        if(null != userCredential){
            builder = User.withUsername(userCredential.getUsername());
            builder.password(userCredential.getPassword().toString());
            builder.roles(userCredential.getRole());
        }
        else{
            throw new UsernameNotFoundException("User not found");
        }
        return builder.build();
    }

    public void setUserCredentials(UserCreds userCredential){
        this.userCredential = userCredential;
    }
}
