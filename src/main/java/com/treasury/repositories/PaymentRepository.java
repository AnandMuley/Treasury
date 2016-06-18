package com.treasury.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.treasury.beans.PaymentBean;

public interface PaymentRepository extends MongoRepository<PaymentBean, String> {

	@Query(value = "{'$group':{_id:'$residentId',total:{'$sum':'$cashBean.amount'}}}")
	Map<String, Double> getTotalAmount();

	List<PaymentBean> removeByResidentId(String residentId);

}
