package com.greenfox.pkrisz0.chatapp.repository;

import com.greenfox.pkrisz0.chatapp.model.Log;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<Log, Integer> {
}
