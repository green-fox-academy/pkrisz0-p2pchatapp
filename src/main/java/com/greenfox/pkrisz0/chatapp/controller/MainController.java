package com.greenfox.pkrisz0.chatapp.controller;

import com.greenfox.pkrisz0.chatapp.model.*;
import com.greenfox.pkrisz0.chatapp.repository.ChatUserRepo;
import com.greenfox.pkrisz0.chatapp.repository.MessageRepo;
import com.greenfox.pkrisz0.chatapp.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.size;

@Controller
public class MainController {

    @Autowired
    ChatUserRepo chatUserRepo;

    @Autowired
    ChatService chatService;

    @Autowired
    MessageRepo messageRepo;

    @GetMapping({"", "/"})
    public String index(HttpServletRequest request, Model model){
        chatService.checkEnvironment(request);
        model.addAttribute("message", new Message());
        if (size(messageRepo.findAll())>0){
            model.addAttribute("messages", messageRepo.findAll());
        }
        if (chatUserRepo.findAllByIdIsGreaterThan(0).size() > 0){
            model.addAttribute("current", chatUserRepo.findOne(chatUserRepo.smallest()));
            return "main";
        } return "redirect:/enter";
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
        } else if (chatuser.getUserName().equals("")){
            model.addAttribute("errorTwo","Please enter a name for the user.");
            return "enter";
        } else {
            chatUserRepo.save(chatuser);
            return "redirect:/";
        }
    }

    @PostMapping("/update")
    public String saveNewName(HttpServletRequest request, @ModelAttribute ChatUser current, Model model){
        chatService.checkEnvironment(request);
        model.addAttribute("current", chatUserRepo.findOne(chatUserRepo.smallest()));

        if (current.getUserName().equals("")){
            model.addAttribute("error","Please enter a name for the user.");
            return "main";
        }
        chatUserRepo.save(current);
        return "redirect:/";
    }

//    @PostMapping(value="/savemessage")
//    public String saveNewMessage(HttpServletRequest request, @ModelAttribute Message message, Model model, @RequestBody ToBeRecieved toBeRecieved){
//        chatService.checkEnvironment(request);
//        model.addAttribute("message", new Message());
//        message.setUsername(System.getenv("CHATAPP_UNIQUE_ID"));
//        message.setId(message.randomId());
//        message.setTimestamp(new Timestamp(System.currentTimeMillis()));
//        chatService.sendMessage(new ToBeRecieved(new Client(System.getenv("CHATAPP_UNIQUE_ID")),message));
//        return "redirect:/";
//    }

    @PostMapping("/savemessage")
    public String saveNewMessage(HttpServletRequest request, @ModelAttribute Message message, Model model){
        chatService.checkEnvironment(request);
        model.addAttribute("message", new Message());
        message.setUsername(chatUserRepo.findOne(chatUserRepo.smallest()).getUserName());
        message.setId(message.randomId());
        message.setTimestamp(new Timestamp(System.currentTimeMillis()));
        messageRepo.save(message);
        return "redirect:/";
    }
}
