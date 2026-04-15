package com.chatapp.chat_backend.service;

import com.chatapp.chat_backend.entity.Message;
import com.chatapp.chat_backend.entity.User;
import com.chatapp.chat_backend.repository.MessageRepository;
import com.chatapp.chat_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    public MessageService(MessageRepository messageRepository, UserRepository userRepository){
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    public Message sendMessage(String username, String content){
        User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));

        Message message = new Message();
        message.setSender(user);
        message.setContent(content);
        message.setTimestamp(LocalDateTime.now());

        return messageRepository.save(message);
    }
    public List<Message> getAllMessages(){
        return messageRepository.findAllByOrderByTimestampAsc();
    }
}