package com.textitout.chat.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "groups")
public class Groups {
    @Id
    private String group_Id;
    private String group_name;

    private List<String> users=new ArrayList<String>();

    public String getGroup_Id() {
        return group_Id;
    }

    public void setGroup_Id(String group_Id) {
        this.group_Id = group_Id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public Groups(String group_Id, String group_name, List<String> users) {
        this.group_Id = group_Id;
        this.group_name = group_name;
        this.users = users;
    }
}
