package com.textitout.chat.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.textitout.chat.model.PrivateChat;

import java.util.List;

public interface PrivateChatRepository extends MongoRepository<PrivateChat, String> {
    List<PrivateChat> findAllByUser1(String userEmail);


    PrivateChat findByChatName(String chatName);
}
