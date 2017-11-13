package com.greenfox.pkrisz0.chatapp.model;

import com.greenfox.pkrisz0.chatapp.repository.ChatUserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "messages")
public class Message {
    String userName;
    String text;
    Timestamp timestamp;

    @Id
    int messageId;

    public Message() {
        this.userName = "Anonymous";
        this.messageId = randomId();
    }

    public Message(String text) {
        this.userName = "Anonymous";
        this.text = text;
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.messageId = randomId();
    }

    public int randomId(){
        return (int)(Math.random() * 9999999 + 1000000);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }
}
