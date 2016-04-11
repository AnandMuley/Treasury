package com.treasury.services;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;

import java.util.Calendar;
import java.util.List;

import org.joda.time.LocalDate;
import org.joda.time.Months;
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

	public DashboardDto getDashboardDetails() {
		Aggregation aggregation = newAggregation(group("userId").sum("amount")
				.as("amount"), project("amount").and("userId")
				.previousOperation());

		AggregationResults<UserAmountBean> userAmtResults = mongoTemplate
				.aggregate(aggregation, PaymentBean.class, UserAmountBean.class);

		List<UserAmountBean> amountBeans = userAmtResults.getMappedResults();
		Calendar calendar = Calendar.getInstance();
		DashboardDto dashboardDto = new DashboardDto();
		dashboardDto.setStartDt(paymentService.getDate(calendar.getTime(),
				"dd-MMM-yyyy"));
		int noOfMonths = getNoOfMonths(calendar);
		double expectedAmount = 1500.0 * noOfMonths;
		dashboardDto.setExpectedAmount(expectedAmount);

		for (UserAmountBean userAmountBean : amountBeans) {
			UserBean userBean = userRepository.findOne(userAmountBean
					.getUserId());
			UserDto userDto = new UserDto();
			userDto.setAmountDue(expectedAmount - userAmountBean.getAmount());
			userDto.setContactNo(userBean.getContactNo());
			userDto.setFlatNo(userBean.getFlatNo());
			userDto.setId(userBean.getId());
			userDto.setName(userBean.getName());
			dashboardDto.getUserDtos().add(userDto);
		}

		return dashboardDto;
	}

	private int getNoOfMonths(Calendar calendar) {
		LocalDate fromDate = new LocalDate(calendar.getTimeInMillis());
		calendar.set(2016, 1, 1);
		LocalDate toDate = new LocalDate(calendar.getTimeInMillis());
		return Months.monthsBetween(toDate, fromDate).getMonths();
	}

}
