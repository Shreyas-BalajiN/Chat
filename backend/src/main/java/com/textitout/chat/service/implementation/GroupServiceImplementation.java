package com.textitout.chat.service.implementation;

import com.textitout.chat.model.Group;
import com.textitout.chat.repository.GroupRepository;
import com.textitout.chat.service.GroupService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImplementation implements GroupService {

    private final GroupRepository groupRepository;

    public GroupServiceImplementation(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public List<Group> getAllGroups() {
        return null;
    }
}
