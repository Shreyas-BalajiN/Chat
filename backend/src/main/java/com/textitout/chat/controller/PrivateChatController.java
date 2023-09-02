package com.textitout.chat.controller;

import com.textitout.chat.model.PrivateChat;
import com.textitout.chat.model.PrivateMessage;
import com.textitout.chat.service.PrivateChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/private")
public class PrivateChatController {

    private final PrivateChatService privateChatService;
    @Autowired
    public PrivateChatController(PrivateChatService privateChatService) {
        this.privateChatService = privateChatService;
    }

    @PostMapping("/send-message")
    public PrivateChat sendMessage(@RequestParam String chatName, @RequestBody PrivateMessage privateMessage) {
        PrivateChat privateChat = privateChatService.getOrCreatePrivateChat(chatName);
        privateChat.addMessage(privateMessage);
        privateChatService.savePrivateChatCache(chatName, privateChat);
        return privateChat;
    }

    @GetMapping("/chat-history")
    public PrivateChat getChatHistory(@RequestParam String chatName) {
        System.out.println("PRINTING CHAT HISTORY");
        return privateChatService.getOrCreatePrivateChat(chatName);
    }

    @GetMapping("/get-private-chat")
    public PrivateChat getPrivateChat(@RequestParam String chatName) {
        return privateChatService.getPrivateChatFromCache(chatName);
    }

}
