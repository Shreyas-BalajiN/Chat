package com.textitout.chat.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "privateChat")
public class PrivateChat {

    @Id
    private String chatId;
    private String user1;
    private String user2;
    private List<PrivateMessage> messages;

    public PrivateChat(String chatId, String user1, String user2, List<PrivateMessage> messages) {
        this.chatId = chatId;
        this.user1 = user1;
        this.user2 = user2;
        this.messages = messages;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getUser1() {
        return user1;
    }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    public String getUser2() {
        return user2;
    }

    public void setUser2(String user2) {
        this.user2 = user2;
    }

    public List<PrivateMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<PrivateMessage> messages) {
        this.messages = messages;
    }
}
