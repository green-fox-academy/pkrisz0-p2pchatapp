package com.greenfox.pkrisz0.chatapp.model;

import javax.persistence.*;

@Entity
@Table(name="chatusers")
public class ChatUser {
    String userName;
    String password;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int userId;

    public ChatUser() {

    }

    public ChatUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
        int userId;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return userId;
    }

    public void setId(int id) {
        this.userId = id;
    }
}
