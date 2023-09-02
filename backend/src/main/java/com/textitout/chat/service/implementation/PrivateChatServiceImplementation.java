package com.textitout.chat.service.implementation;


import com.textitout.chat.model.PrivateChat;
import com.textitout.chat.repository.PrivateChatRepository;
import com.textitout.chat.service.PrivateChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrivateChatServiceImplementation implements PrivateChatService {

    private final PrivateChatRepository privateChatRepository;

    @Autowired
    public PrivateChatServiceImplementation(PrivateChatRepository privateChatRepository) {
        this.privateChatRepository = privateChatRepository;

    }

    @Override
    @CachePut(value = "privateChats", key = "#chatName")
    public PrivateChat savePrivateChatCache(String chatName, PrivateChat privateChat) {
        privateChat.setChatName(chatName);
       // privateChatRepository.save(privateChat);
        return privateChat;
    }

    @Override
    @Cacheable(value = "privateChats", key = "#chatName")
    public PrivateChat getPrivateChatFromCache(String chatName) {
        return privateChatRepository.findByChatName(chatName);
    }

    @Override
    @CacheEvict(value = "privateChats", key = "#chatName")
    public void evictPrivateChatCache(String chatName) {
        // Evict the PrivateChat from the cache
    }


    @CacheEvict(value = "privateChats")
    public void evictCache() {
        // Evicts all cached data
    }

    // Save chat history every 3 minutes
    // maybe change this later to use celery
    //@Scheduled(fixedRate = 180000) // Maybe this should be done once a day
    public void savePrivateChatHistory() {
        List<PrivateChat> userChats = getAllPrivateChatsFromCache();
        privateChatRepository.saveAll(userChats);
        evictCache();
    }

    private List<PrivateChat> getAllPrivateChatsFromCache() {
        // retrieve data from the Redis cache or mongodb
        return null;
    }


    @Override
    @Cacheable(value = "privateChats", key = "#chatName")
    public PrivateChat getOrCreatePrivateChat(String chatName) {
        // find an existing chat in MongoDB or redis cache
        PrivateChat existingChat = privateChatRepository.findByChatName(chatName);

        if (existingChat != null) {
            // If the chat already exists, return it
            return existingChat;
        } else {
            // If the chat doesn't exist, create a new one
            PrivateChat newChat = new PrivateChat();
            newChat.setChatName(chatName);

            // Save the new chat to MongoDB
            privateChatRepository.save(newChat);

            return newChat;
        }
    }

    @Override
    public List<PrivateChat> getAllUserPrivateChats(String userEmail) {
        // return all chats from mongodb using userEmail
        // find the logic where either user1 or user2 is the provided email
        return privateChatRepository.findAllByUser1(userEmail);
    }


}
