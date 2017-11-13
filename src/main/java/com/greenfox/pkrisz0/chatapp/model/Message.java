package com.greenfox.pkrisz0.chatapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    }

    public Message(String userName, String text) {
        this.userName = userName;
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
