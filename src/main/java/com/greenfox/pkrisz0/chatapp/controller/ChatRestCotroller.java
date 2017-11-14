package com.greenfox.pkrisz0.chatapp.controller;

import com.greenfox.pkrisz0.chatapp.model.Status;
import com.greenfox.pkrisz0.chatapp.model.ToBeRecieved;
import com.greenfox.pkrisz0.chatapp.repository.ChatUserRepo;
import com.greenfox.pkrisz0.chatapp.repository.MessageRepo;
import com.greenfox.pkrisz0.chatapp.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Holder;

@RestController
public class ChatRestCotroller {


    @Autowired
    ChatUserRepo chatUserRepo;

    @Autowired
    ChatService chatService;

    @Autowired
    MessageRepo messageRepo;

    @GetMapping(value="/index")
    public void index(HttpServletRequest request){
        chatService.checkEnvironment(request);
    }

    @CrossOrigin("*")
    @PostMapping(value = "/api/message/receive")
    public Object getsMessage(@RequestBody ToBeRecieved toBeRecieved, HttpServletRequest request){
        chatService.checkEnvironment(request);
        if (chatService.checkFields(toBeRecieved).equals("")){
            messageRepo.save(toBeRecieved.getMessage());
            return "status : ok";
        }
        else {
            return new ResponseEntity(new Status("error", "Missing field(s):" + chatService.checkFields(toBeRecieved)), HttpStatus.BAD_REQUEST);
        }
    }
}
