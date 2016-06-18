package com.treasury.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.treasury.beans.ResidentBean;

public interface ResidentRepository extends
		MongoRepository<ResidentBean, String> {

}
