package com.greenfox.pkrisz0.chatapp.model;

import javax.persistence.*;

@Entity
@Table(name="chatusers")
public class ChatUser {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int id;

    String userName;

    public ChatUser() {
     int id;
    }

    public ChatUser(String userName) {
        this.userName = userName;
        int id;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
