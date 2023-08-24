package com.textitout.chat.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class PrivateMessage {
    @Id
    private String messageId;
    private String message_type;
    private LocalDateTime timestamp;
    private String message;
    private String sender;
    private boolean read;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessage_type() {
        return message_type;
    }

    public void setMessage_type(String message_type) {
        this.message_type = message_type;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
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

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public PrivateMessage(String messageId, String message_type, LocalDateTime timestamp, String message, String sender, boolean read) {
        this.messageId = messageId;
        this.message_type = message_type;
        this.timestamp = timestamp;
        this.message = message;
        this.sender = sender;
        this.read = read;
    }
}
