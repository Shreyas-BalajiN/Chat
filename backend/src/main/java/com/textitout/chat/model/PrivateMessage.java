package com.textitout.chat.model;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDateTime;

public class PrivateMessage implements Serializable {

    private String messageId;
    private String messageType;
    private LocalDateTime timestamp;
    private String message;
    private String sender;
    private boolean read;

    public PrivateMessage(String messageId, String message_type, LocalDateTime timestamp, String message, String sender, boolean read) {
        this.messageId = messageId;
        this.messageType = message_type;
        this.timestamp = timestamp;
        this.message = message;
        this.sender = sender;
        this.read = read;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
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

}
