package com.textitout.chat.service.implementation;

import com.textitout.chat.model.GroupChat;
import com.textitout.chat.repository.GroupChatRepository;
import com.textitout.chat.service.GroupChatService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupChatServiceImplementation implements GroupChatService {

    private final GroupChatRepository groupChatRepository;

    public GroupChatServiceImplementation(GroupChatRepository groupChatRepository) {
        this.groupChatRepository = groupChatRepository;
    }

    @Override
    public List<GroupChat> getAllGroupChats() {
        return null;
    }
}
