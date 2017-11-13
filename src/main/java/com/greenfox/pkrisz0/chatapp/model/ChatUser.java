package com.greenfox.pkrisz0.chatapp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="chatusers")
public class ChatUser {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
