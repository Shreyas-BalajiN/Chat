package com.textitout.chat.constants;

public enum UserStatus {

    ONLINE(true),
    OFFLINE(false);

    private final Boolean userStatus;

    UserStatus(Boolean userStatus){
        this.userStatus = userStatus;
    }

    public Boolean getUserStatus(){
        return userStatus;
    }
}
