package com.textitout.chat.model;

import java.time.LocalDateTime;

public class GroupMessage {

    private String message;
    private String sender;
    private LocalDateTime timestamp;
    private String messageId;

    public GroupMessage(String message, String sender, LocalDateTime timestamp, String messageId) {
        this.message = message;
        this.sender = sender;
        this.timestamp = timestamp;
        this.messageId = messageId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
