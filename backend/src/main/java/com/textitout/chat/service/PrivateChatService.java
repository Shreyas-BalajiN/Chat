package com.textitout.chat.service;

import com.textitout.chat.model.PrivateChat;

import java.util.List;

public interface PrivateChatService {

    PrivateChat getPrivateChatFromCache(String chatName);

    void evictPrivateChatCache(String chatName);

    PrivateChat getOrCreatePrivateChat(String chatName);
    List<PrivateChat> getAllUserPrivateChats(String userEmail);

    PrivateChat savePrivateChatCache(String chatName, PrivateChat privateChat);



}
