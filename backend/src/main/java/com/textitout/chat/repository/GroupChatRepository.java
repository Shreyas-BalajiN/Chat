package com.textitout.chat.repository;

import com.textitout.chat.model.GroupChat;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GroupChatRepository extends MongoRepository<GroupChat, String> {
}
