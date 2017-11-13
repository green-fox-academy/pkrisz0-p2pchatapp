package com.greenfox.pkrisz0.chatapp.controller;

import com.greenfox.pkrisz0.chatapp.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ChatRestCotroller {


    @Autowired
    ChatService chatService;

    @GetMapping(value="/index")
    public void index(HttpServletRequest request){
        chatService.checkEnvironment(request);
    }
}
