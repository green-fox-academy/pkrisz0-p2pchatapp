package com.greenfox.pkrisz0.chatapp;

import com.greenfox.pkrisz0.chatapp.repository.ChatAppRepo;
import com.greenfox.pkrisz0.chatapp.repository.ChatLogRepo;
import com.greenfox.pkrisz0.chatapp.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatappApplication implements CommandLineRunner {

	@Autowired
	ChatAppRepo chatAppRepo;

	@Autowired
	ChatService chatService;

	@Autowired
	ChatLogRepo chatLogRepo;

	public static void main(String[] args) {
		SpringApplication.run(ChatappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
