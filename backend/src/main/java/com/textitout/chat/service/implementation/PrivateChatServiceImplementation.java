package com.textitout.chat.service.implementation;

import com.textitout.chat.model.PrivateChat;
import com.textitout.chat.repository.PrivateChatRepository;
import com.textitout.chat.service.PrivateChatService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrivateChatServiceImplementation implements PrivateChatService {

    private final PrivateChatRepository privateChatRepository;

    public PrivateChatServiceImplementation(PrivateChatRepository privateChatRepository) {
        this.privateChatRepository = privateChatRepository;
    }

    @Override
    public List<PrivateChat> getAllPrivateChats() {
        return null;
    }
}
