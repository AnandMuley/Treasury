package com.treasury.services;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.treasury.beans.PaymentBean;
import com.treasury.beans.ResidentAmountBean;
import com.treasury.beans.ResidentBean;
import com.treasury.dtos.DashboardDto;
import com.treasury.dtos.ResidentDto;
import com.treasury.repositories.PaymentRepository;
import com.treasury.repositories.ResidentRepository;
import com.treasury.utils.DateConvertorUtil;

@Service
public class DashboardService {

	@Autowired
	private ResidentRepository residentRepository;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private DataExtractorService dataExtractorService;

	@Autowired
	private MonthCalculator monthCalculator;

	@Autowired
	private DateConvertorUtil dateConvertorUtil;

	public Double getAmountPaid(String residentId, String createdBy) {
		List<ResidentAmountBean> amountBeans = getPayments(createdBy);
		for (ResidentAmountBean residentAmountBean : amountBeans) {
			if (residentAmountBean.getResidentId().equalsIgnoreCase(residentId)) {
				return residentAmountBean.getAmount();
			}
		}
		return 0.0;
	}

	public DashboardDto getDashboardDetails(String createdBy)
			throws ParseException {
		List<ResidentAmountBean> amountBeans = getPayments(createdBy);
		DashboardDto dashboardDto = new DashboardDto();
		dashboardDto.setStartDt(monthCalculator.getStartDate());
		for (ResidentAmountBean residentAmountBean : amountBeans) {
			ResidentBean residentBean = residentRepository
					.findOne(residentAmountBean.getResidentId());
			ResidentDto residentDto = new ResidentDto();
			Double expectedAmount = paymentService.calculateAmountPayable(
					residentAmountBean.getResidentId(), createdBy);
			residentDto.setAmountDue(expectedAmount);
			residentDto.setContactNo(residentBean.getContactNo());
			residentDto.setFlatNo(residentBean.getFlatNo());
			residentDto.setId(residentBean.getId());
			residentDto.setName(residentBean.getName());
			dashboardDto.getResidentDtos().add(residentDto);
		}

		List<String> residentIds = dataExtractorService
				.getResidentIds(amountBeans);
		List<ResidentBean> residentBeans = residentRepository
				.findByCreatedBy(createdBy);
		for (ResidentBean residentBean : residentBeans) {
			if (!residentIds.contains(residentBean.getId())) {
				ResidentDto residentDto = new ResidentDto();
				residentDto.setAmountDue(paymentService.calculateAmountPayable(
						residentBean.getId(), createdBy));
				residentDto.setContactNo(residentBean.getContactNo());
				residentDto.setFlatNo(residentBean.getFlatNo());
				residentDto.setId(residentBean.getId());
				residentDto.setName(residentBean.getName());
				dashboardDto.getResidentDtos().add(residentDto);
			}
		}
		return dashboardDto;
	}

	private List<ResidentAmountBean> getPayments(String createdBy) {
		Aggregation aggregation = newAggregation(
				Aggregation.match(Criteria.where("createBy").is(createdBy)),
				group("residentId").sum("amount").as("amount"),
				project("amount").and("residentId").previousOperation());
		AggregationResults<ResidentAmountBean> residentAmtResults = mongoTemplate
				.aggregate(aggregation, PaymentBean.class,
						ResidentAmountBean.class);
		List<ResidentAmountBean> amountBeans = residentAmtResults
				.getMappedResults();
		return amountBeans;
	}

}
