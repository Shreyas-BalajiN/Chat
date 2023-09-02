package com.textitout.chat.constants;

public enum MessageType {

    MEDIA("media"),
    TEXT("text");

    private final String messageType;

    MessageType(String messageType){
        this.messageType = messageType;
    }
    public String getMessageType(){
        return messageType;
    }

}
