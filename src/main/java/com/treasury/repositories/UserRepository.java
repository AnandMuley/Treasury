package com.treasury.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.treasury.beans.UserBean;

public interface UserRepository extends MongoRepository<UserBean, String>{

}
