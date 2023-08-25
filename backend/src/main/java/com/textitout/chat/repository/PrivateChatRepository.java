package com.textitout.chat.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.textitout.chat.model.PrivateChat;

public interface PrivateChatRepository extends MongoRepository<PrivateChat, String> {
}
