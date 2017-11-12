package com.greenfox.pkrisz0.chatapp.controller;

import com.greenfox.pkrisz0.chatapp.repository.ChatUserRepo;
import com.greenfox.pkrisz0.chatapp.repository.ChatLogRepo;
import com.greenfox.pkrisz0.chatapp.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    ChatUserRepo chatAppRepo;

    @Autowired
    ChatService chatService;

    @Autowired
    ChatLogRepo chatLogRepo;

    @GetMapping({"", "/"})
    public String index(){
        return "main";
    }
}
