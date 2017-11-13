package com.greenfox.pkrisz0.chatapp.controller;

import com.greenfox.pkrisz0.chatapp.model.ChatUser;
import com.greenfox.pkrisz0.chatapp.repository.ChatUserRepo;
import com.greenfox.pkrisz0.chatapp.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @Autowired
    ChatUserRepo chatUserRepo;

    @Autowired
    ChatService chatService;

    @GetMapping({"", "/"})
    public String index(HttpServletRequest request){
        chatService.checkEnvironment(request);
        return "main";
    }

    @GetMapping("/enter")
    public String enter(HttpServletRequest request, Model model){
        chatService.checkEnvironment(request);
        model.addAttribute("chatuser", new ChatUser());
        return "enter";
    }


    @PostMapping("/save")
    public String save(HttpServletRequest request, @ModelAttribute ChatUser chatuser, Model model){
        chatService.checkEnvironment(request);
        model.addAttribute("chatuser", new ChatUser());
        if (chatUserRepo.findChatUserByUserName(chatuser.getUserName()).size() > 0){
            model.addAttribute("error","User with this name already exists.");
            return "enter";
        } else {
            chatUserRepo.save(chatuser);
            return "redirect:/";
        }
    }
}
