package com.textitout.chat.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;


@Document("groupChat")
public class GroupChat {

    @Id
    private String groupId;
    private List<String> users;
    private List<GroupMessage> messages;

    public GroupChat(List<String> users, List<GroupMessage> messages, String groupId) {
        this.users = users;
        this.messages = messages;
        this.groupId = groupId;
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public List<GroupMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<GroupMessage> messages) {
        this.messages = messages;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
