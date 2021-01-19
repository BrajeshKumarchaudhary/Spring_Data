package com.app.repo;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.app.model.User;

@Repository
public interface UserRepo extends MongoRepository<User, String> {

}

