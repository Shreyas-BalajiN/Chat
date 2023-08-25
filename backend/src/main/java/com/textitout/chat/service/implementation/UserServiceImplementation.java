package com.textitout.chat.service.implementation;

import com.textitout.chat.model.User;
import com.textitout.chat.repository.UserRepository;
import com.textitout.chat.service.UserService;

import java.util.List;

public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
