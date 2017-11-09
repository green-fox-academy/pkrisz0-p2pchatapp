package com.greenfox.pkrisz0.chatapp.controller;

import com.greenfox.pkrisz0.chatapp.model.User;
import com.greenfox.pkrisz0.chatapp.repository.ChatAppRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    ChatAppRepo chatAppRepo;

    @GetMapping({"", "/"})
    public String index(Model model){
        chatAppRepo.save(new User("krisz","12345"));
        model.addAttribute("user", chatAppRepo.findOne(1));
        return "main";
    }
}
