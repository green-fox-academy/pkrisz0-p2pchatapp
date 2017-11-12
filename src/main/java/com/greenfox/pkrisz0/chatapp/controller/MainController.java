package com.greenfox.pkrisz0.chatapp.controller;

import com.greenfox.pkrisz0.chatapp.model.Log;
import com.greenfox.pkrisz0.chatapp.model.User;
import com.greenfox.pkrisz0.chatapp.repository.ChatAppRepo;
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

    @GetMapping({"", "/"})
    public String index(Model model, HttpServletRequest request){
        chatAppRepo.save(new User("krisz","12345"));
        model.addAttribute("user", chatAppRepo.findOne(1));
        chatService.checkEnvironment(request);
        return "main";
    }
}
