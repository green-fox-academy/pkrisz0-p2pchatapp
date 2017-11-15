package com.greenfox.pkrisz0.chatapp.service;

import com.greenfox.pkrisz0.chatapp.model.ChatLog;
import com.greenfox.pkrisz0.chatapp.model.Status;
import com.greenfox.pkrisz0.chatapp.model.ToBeRecieved;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Service
public class ChatService {

    public void checkEnvironment(HttpServletRequest request){
        if (System.getenv("CHAT_APP_LOGLEVEL").equals("INFO")){
            System.out.println(new ChatLog(request));
        } else if (System.getenv("CHAT_APP_LOGLEVEL").equals("ERROR")){
            System.err.println(new ChatLog(request));
        }
    }

    public String checkFields(ToBeRecieved toBeRecieved){
        StringBuilder sb = new StringBuilder();
        sb.append("");

        if (toBeRecieved.getMessage().getUsername() == null || toBeRecieved.getMessage().getUsername().isEmpty()){
            sb.append("message.userName");
        } if (toBeRecieved.getMessage().getText() == null || toBeRecieved.getMessage().getText().isEmpty()) {
            sb.append(", ");
            sb.append("message.text");
        } if (toBeRecieved.getMessage().getTimestamp() == null){
            sb.append(", ");
            sb.append("message.timestamp");
        } if (toBeRecieved.getMessage().getId() == null ||
                toBeRecieved.getMessage().getId() < 1000000 ||
                toBeRecieved.getMessage().getId() > 9999999){
            sb.append(", ");
            sb.append("message.messageId");
        }  if (toBeRecieved.getClient() == null || toBeRecieved.getClient().getId() == null  || toBeRecieved.getClient().getId().isEmpty()) {
            sb.append(", ");
            sb.append("client.id");
        }
        return sb.toString();
    }

    public void sendMessage(ToBeRecieved toBeRecieved){
        RestTemplate restTemplate = new RestTemplate();
        Status s = restTemplate.postForObject("http://localhost:8080/api/message/receive",toBeRecieved, Status.class);
    }
}
