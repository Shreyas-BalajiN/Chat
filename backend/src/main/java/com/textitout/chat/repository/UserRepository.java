package com.textitout.chat.repository;

import com.textitout.chat.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
