package com.chatapp.chat_backend.dto;

public class RegisterRequest{
    private String username;
    private  String password;

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }
}