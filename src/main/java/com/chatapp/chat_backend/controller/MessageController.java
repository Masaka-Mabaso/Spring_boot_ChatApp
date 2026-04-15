package com.chatapp.chat_backend.controller;

import com.chatapp.chat_backend.dto.MessageRequest;
import com.chatapp.chat_backend.entity.Message;
import com.chatapp.chat_backend.service.MessageService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService){
        this.messageService = messageService;
    }

    @PostMapping("/send")
    public Message sendMessage(@RequestBody MessageRequest request){
        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
        return messageService.sendMessage(username, request.getContent());
    }
}