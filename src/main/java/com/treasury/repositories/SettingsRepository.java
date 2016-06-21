package com.treasury.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.treasury.beans.SettingsBean;

@Repository
public interface SettingsRepository extends
		MongoRepository<SettingsBean, String> {

	SettingsBean findByCreatedBy(String createdBy);

}
