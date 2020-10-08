package com.cognizant.arunabha.dao;

import com.cognizant.arunabha.model.UserCreds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao {

    private final String VALIDATE_LOGIN = "select password from login where user_id=?";
    private final String GETROLE_LOGIN = "select role from authorities where user_id=?";

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public LoginDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Boolean login(UserCreds userCredential) {
        String password = jdbcTemplate.queryForObject(VALIDATE_LOGIN, new Object[]{userCredential.getUsername()}, String.class);
        System.out.println("LoginDao.login, password: " +password);
        System.out.println("userCredential.getPassword() " +userCredential.getPassword());
        if (password.matches(userCredential.getPassword())) {
            System.out.println("LoginDao.login, password matched");
            String role = jdbcTemplate.queryForObject(GETROLE_LOGIN, new Object[]{userCredential.getUsername()}, String.class);
            userCredential.setRole(role);
            return true;
        }
        else
        return false;
    }

}
