package com.greenfox.pkrisz0.chatapp.controller;

import com.greenfox.pkrisz0.chatapp.model.ChatLog;
import com.greenfox.pkrisz0.chatapp.model.ChatUser;
import com.greenfox.pkrisz0.chatapp.repository.ChatAppRepo;
import com.greenfox.pkrisz0.chatapp.repository.ChatLogRepo;
import com.greenfox.pkrisz0.chatapp.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @Autowired
    ChatAppRepo chatAppRepo;

    @Autowired
    ChatService chatService;

    @Autowired
    ChatLogRepo chatLogRepo;

    @GetMapping({"", "/"})
    public String index(HttpServletRequest request){
        chatService.checkEnvironment(request);
        chatLogRepo.save(new ChatLog(request));
        return "main";
    }
}
