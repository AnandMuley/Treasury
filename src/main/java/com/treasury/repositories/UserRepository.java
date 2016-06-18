package com.treasury.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.treasury.beans.UserBean;

@Repository
public interface UserRepository extends MongoRepository<UserBean, String> {

	UserBean findByUsernameAndPassword(String username, String password);

}
