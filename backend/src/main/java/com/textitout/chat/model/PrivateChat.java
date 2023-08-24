package com.textitout.chat.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "privateChat")
public class PrivateChat {
    @Id
    private String chatId;

    private String per1;
    private String per2;

    private List<PrivateMessage> messages = new ArrayList<PrivateMessage>();

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getPer1() {
        return per1;
    }

    public void setPer1(String per1) {
        this.per1 = per1;
    }

    public String getPer2() {
        return per2;
    }

    public void setPer2(String per2) {
        this.per2 = per2;
    }

    public List<PrivateMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<PrivateMessage> messages) {
        this.messages = messages;
    }

    public PrivateChat(String chatId, String per1, String per2, List<PrivateMessage> messages) {
        this.chatId = chatId;
        this.per1 = per1;
        this.per2 = per2;
        this.messages = messages;
    }
}
