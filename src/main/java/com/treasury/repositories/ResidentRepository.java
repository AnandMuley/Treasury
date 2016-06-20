package com.treasury.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.treasury.beans.ResidentBean;

public interface ResidentRepository extends
		MongoRepository<ResidentBean, String> {

	List<ResidentBean> findByCreatedBy(String createdBy);

}
