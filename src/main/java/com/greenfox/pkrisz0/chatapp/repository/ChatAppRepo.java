package com.greenfox.pkrisz0.chatapp.repository;

import com.greenfox.pkrisz0.chatapp.model.User;
import org.springframework.data.repository.CrudRepository;

public interface ChatAppRepo extends CrudRepository<User, Integer> {
}
