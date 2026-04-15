package com.chatapp.chat_backend.dto;

public class MessageRequest {

    private String content;

    public MessageRequest(){}
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}