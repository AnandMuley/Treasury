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
import org.springframework.stereotype.Service;

import com.treasury.beans.PaymentBean;
import com.treasury.beans.UserAmountBean;
import com.treasury.beans.UserBean;
import com.treasury.dtos.DashboardDto;
import com.treasury.dtos.UserDto;
import com.treasury.repositories.PaymentRepository;
import com.treasury.repositories.UserRepository;
import com.treasury.utils.DateConvertorUtil;

@Service
public class DashboardService {

	@Autowired
	private UserRepository userRepository;

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

	public Double getAmountPaid(String userId) {
		List<UserAmountBean> amountBeans = getPayments();
		for (UserAmountBean userAmountBean : amountBeans) {
			if (userAmountBean.getUserId().equalsIgnoreCase(userId)) {
				return userAmountBean.getAmount();
			}
		}
		return 0.0;
	}

	public DashboardDto getDashboardDetails() throws ParseException {
		List<UserAmountBean> amountBeans = getPayments();
		DashboardDto dashboardDto = new DashboardDto();
		dashboardDto.setStartDt(monthCalculator.getStartDate());
		for (UserAmountBean userAmountBean : amountBeans) {
			UserBean userBean = userRepository.findOne(userAmountBean
					.getUserId());
			UserDto userDto = new UserDto();
			Double expectedAmount = paymentService
					.calculateAmountPayable(userAmountBean.getUserId());
			userDto.setAmountDue(expectedAmount);
			userDto.setContactNo(userBean.getContactNo());
			userDto.setFlatNo(userBean.getFlatNo());
			userDto.setId(userBean.getId());
			userDto.setName(userBean.getName());
			dashboardDto.getUserDtos().add(userDto);
		}

		List<String> userIds = dataExtractorService.getUserIds(amountBeans);
		List<UserBean> userBeans = userRepository.findAll();
		for (UserBean userBean : userBeans) {
			if (!userIds.contains(userBean.getId())) {
				UserDto userDto = new UserDto();
				userDto.setAmountDue(paymentService
						.calculateAmountPayable(userBean.getId()));
				userDto.setContactNo(userBean.getContactNo());
				userDto.setFlatNo(userBean.getFlatNo());
				userDto.setId(userBean.getId());
				userDto.setName(userBean.getName());
				dashboardDto.getUserDtos().add(userDto);
			}
		}
		return dashboardDto;
	}

	private List<UserAmountBean> getPayments() {
		Aggregation aggregation = newAggregation(group("userId").sum("amount")
				.as("amount"), project("amount").and("userId")
				.previousOperation());
		AggregationResults<UserAmountBean> userAmtResults = mongoTemplate
				.aggregate(aggregation, PaymentBean.class, UserAmountBean.class);
		List<UserAmountBean> amountBeans = userAmtResults.getMappedResults();
		return amountBeans;
	}

}
