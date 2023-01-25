package com.project.youtube.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.youtube.model.User;

public interface UserRepository extends MongoRepository<User, String>{

}
