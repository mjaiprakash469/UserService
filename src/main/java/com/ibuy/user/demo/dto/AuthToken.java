package com.ibuy.user.demo.dto;

public class AuthToken {

    private String token;
    private String email;

    public AuthToken(){

    }

    public AuthToken(String token, String email){
        this.token = token;
        this.email = email;
    }

    public AuthToken(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String email) {
        this.email = email;
    }
}
