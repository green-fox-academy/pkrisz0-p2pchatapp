package com.greenfox.pkrisz0.chatapp.controller;


import com.greenfox.pkrisz0.chatapp.repository.ChatAppRepo;
import com.greenfox.pkrisz0.chatapp.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    ChatAppRepo chatAppRepo;

    @Autowired
    ChatService chatService;

}
