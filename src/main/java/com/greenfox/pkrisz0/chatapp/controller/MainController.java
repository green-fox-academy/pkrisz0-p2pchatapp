package com.greenfox.pkrisz0.chatapp.controller;

import com.greenfox.pkrisz0.chatapp.repository.ChatAppRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    ChatAppRepo chatAppRepo;

    @GetMapping({"", "/"})
    public String index(){
        return "main";
    }
}
