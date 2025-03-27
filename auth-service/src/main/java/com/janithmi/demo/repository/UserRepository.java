package com.janithmi.demo.repository;

import com.janithmi.demo.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Integer> {
    User findByUsername(String username);

}
