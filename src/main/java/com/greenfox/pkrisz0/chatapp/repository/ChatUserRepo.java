package com.greenfox.pkrisz0.chatapp.repository;

import com.greenfox.pkrisz0.chatapp.model.ChatUser;
import org.springframework.data.repository.CrudRepository;

public interface ChatUserRepo extends CrudRepository<ChatUser, Integer> {
}
