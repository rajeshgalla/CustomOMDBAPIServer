package com.rajesh.galla.entity;

public class SignUpResponse {

    private String token;

    @Override
    public String toString() {

        return token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
