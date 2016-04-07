package com.treasury.repositories;

import java.util.Map;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.treasury.beans.PaymentBean;

public interface PaymentRepository extends MongoRepository<PaymentBean, String> {

	@Query(value = "{'$group':{_id:'$userId',total:{'$sum':'$cashBean.amount'}}}")
	Map<String, Double> getTotalAmount();

}
