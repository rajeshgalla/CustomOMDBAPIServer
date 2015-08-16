package com.rajesh.galla.bo.impl;

import com.rajesh.galla.bo.UserDetailsBO;
import com.rajesh.galla.dao.UserDetailsDAO;
import com.rajesh.galla.entity.SignUpResponse;
import com.rajesh.galla.entity.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;

@Component
public class UserDetailsBOImplementation implements UserDetailsBO {

    @Autowired
    private UserDetailsDAO userDetailsDAO;
    private SignUpResponse signUpResponse = new SignUpResponse();
    private SecureRandom random = new SecureRandom();

    public SignUpResponse saveUser(final UserDetails userDetails) {

        String token = getUUID();
        userDetails.setToken(token);
        signUpResponse.setToken(token);
        System.out.println("Token is " + token);
        userDetailsDAO.saveUser(userDetails);
        return signUpResponse;
    }

    public String getUUID() {
        return new BigInteger(130, random).toString(32);
    }
    public UserDetailsDAO getUserDetailsDAO() {
        return userDetailsDAO;
    }

    public void setUserDetailsDAO(UserDetailsDAO userDetailsDAO) {
        this.userDetailsDAO = userDetailsDAO;
    }
}
