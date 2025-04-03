package com.hello.neighbors.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/*
@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @GetMapping("/messages/{userId}")
    public List<ChatMessage> getMessages(@PathVariable String userId) {
        return chatMessageRepository.findBySenderIdOrReceiverId(userId, userId);
    }
}
*/