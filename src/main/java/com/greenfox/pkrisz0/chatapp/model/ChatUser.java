package com.greenfox.pkrisz0.chatapp.model;

import javax.persistence.*;

@Entity
@Table(name="chatusers")
public class ChatUser {

    @Id
    String userName;

    public ChatUser() {

    }

    public ChatUser(String userName) {
        this.userName = userName;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
