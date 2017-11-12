package com.greenfox.pkrisz0.chatapp.repository;

import com.greenfox.pkrisz0.chatapp.model.ChatLog;
import org.springframework.data.repository.CrudRepository;

public interface ChatLogRepo extends CrudRepository<ChatLog, Integer> {
}
