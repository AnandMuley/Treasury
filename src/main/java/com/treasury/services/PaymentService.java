package com.treasury.services;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.treasury.beans.ChequeBean;
import com.treasury.beans.NetBankingBean;
import com.treasury.beans.PaymentBean;
import com.treasury.beans.ResidentAmountBean;
import com.treasury.dtos.BalanceDto;
import com.treasury.dtos.PaymentDto;
import com.treasury.dtos.ResidentDto;
import com.treasury.exceptions.InvalidPaymentModeException;
import com.treasury.repositories.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	private String DDMMYYYY = "dd-MM-yyyy";

	@Autowired
	private ResidentService residentService;

	@Autowired
	private PaymentCalculator paymentCalculator;

	@Autowired
	private DateCalculator dateCalculator;

	@Autowired
	private MongoTemplate mongoTemplate;

	public BalanceDto getBalance(String residentId, String createdBy) {
		BalanceDto balanceDto = new BalanceDto();
		try {
			balanceDto.setResidentId(residentId);
			Double payable = calculateAmountPayable(residentId, createdBy);
			balanceDto.setPayable(payable);
			Double paid = getAmountPaid(residentId);
			balanceDto.setPaid(paid);
			// The operation can be move to client side by sending previous
			// details
			Double due = payable - paid;
			balanceDto.setDue(due);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return balanceDto;
	}

	public Double getAmountPaid(String residentId) {
		// TODO Optimize this to perform for specific residentId
		Aggregation aggregation = newAggregation(
				group("residentId").sum("amount").as("amount"),
				project("amount").and("residentId").previousOperation());
		AggregationResults<ResidentAmountBean> aggregationResults = mongoTemplate
				.aggregate(aggregation, PaymentBean.class,
						ResidentAmountBean.class);
		List<ResidentAmountBean> amountPaidLst = aggregationResults
				.getMappedResults();
		Double amountPaid = 0d;
		for (ResidentAmountBean residentAmountBean : amountPaidLst) {
			if (residentId.equals(residentAmountBean.getResidentId())) {
				amountPaid = residentAmountBean.getAmount();
				break;
			}
		}
		return amountPaid;
	}

	public Double getAmountPaid(String residentId, String createdBy) {
		List<ResidentAmountBean> amountBeans = getPayments(createdBy);
		for (ResidentAmountBean residentAmountBean : amountBeans) {
			if (residentAmountBean.getResidentId().equalsIgnoreCase(residentId)) {
				return residentAmountBean.getAmount();
			}
		}
		return 0.0;
	}

	public List<ResidentAmountBean> getPayments(String createdBy) {
		List<String> residentIds = residentService.getResidentIds(createdBy);
		Aggregation aggregation = newAggregation(
				group("residentId").sum("amount").as("amount"),
				project("amount").and("residentId").previousOperation());
		AggregationResults<ResidentAmountBean> residentAmtResults = mongoTemplate
				.aggregate(aggregation, PaymentBean.class,
						ResidentAmountBean.class);
		List<ResidentAmountBean> amountBeans = residentAmtResults
				.getMappedResults();
		List<ResidentAmountBean> filteredBeans = new ArrayList<ResidentAmountBean>();
		for (ResidentAmountBean residentAmountBean : amountBeans) {
			if (residentIds.contains(residentAmountBean.getResidentId())) {
				filteredBeans.add(residentAmountBean);
			}
		}
		return filteredBeans;
	}

	public Double calculateAmountPayable(String residentId, String createdBy)
			throws ParseException {
		ResidentDto residentDto = residentService.findById(residentId);
		Double amountPayable = paymentCalculator.calculateAmountPayable(
				residentDto.getArea(), createdBy);
		int noOfMonths = dateCalculator.getNoOfMonths();
		Double totalAmount = amountPayable * noOfMonths;
		return totalAmount;
	}

	public Double calculateAmountDue(String residentId, String createdBy)
			throws ParseException {
		Double amountPayable = calculateAmountPayable(residentId, createdBy);
		Double amountPaid = getAmountPaid(residentId, createdBy);
		return amountPayable - amountPaid;
	}

	public void create(PaymentDto paymentDto)
			throws InvalidPaymentModeException, ParseException {
		if (StringUtils.isEmpty(paymentDto.getMode())) {
			throw new InvalidPaymentModeException(
					"Please select a payment mode");
		}
		PaymentBean paymentBean = new PaymentBean();
		paymentBean.setMode(paymentDto.getMode());
		paymentBean.setResidentId(paymentDto.getResidentId());
		paymentBean.setAmount(paymentDto.getAmount());
		paymentBean.setPaymentDt(dateCalculator.getDate(
				paymentDto.getPaymentDt(), DDMMYYYY));
		paymentBean.getFromDate().setMonth(
				paymentDto.getFromDateDto().getMonth());
		paymentBean.getFromDate()
				.setYear(paymentDto.getFromDateDto().getYear());
		paymentBean.getToDate().setMonth(paymentDto.getToDateDto().getMonth());
		paymentBean.getToDate().setYear(paymentDto.getToDateDto().getYear());
		populateData(paymentDto, paymentBean);
		paymentRepository.save(paymentBean);
		paymentDto.setId(paymentBean.getId());
	}

	private void populateData(PaymentDto paymentDto, PaymentBean paymentBean)
			throws ParseException {
		switch (paymentDto.getMode()) {
		case "cash":
			break;
		case "cheque":
			ChequeBean chequeBean = new ChequeBean();
			chequeBean.setBankDetails(paymentDto.getChequeDto()
					.getBankDetails());
			chequeBean.setChequeNo(paymentDto.getChequeDto().getChequeNo());
			chequeBean.setChequeDt(dateCalculator.getDate(paymentDto
					.getChequeDto().getChequeDt(), DDMMYYYY));
			paymentBean.setChequeBean(chequeBean);
			break;
		case "netbanking":
			NetBankingBean netBankingBean = new NetBankingBean();
			netBankingBean.setAccountNo(paymentDto.getNetBankingDto()
					.getAccountNo());
			netBankingBean.setBankDetails(paymentDto.getNetBankingDto()
					.getBankDetails());
			netBankingBean.setReferenceNo(paymentDto.getNetBankingDto()
					.getReferenceNo());
			paymentBean.setNetBankingBean(netBankingBean);
			break;
		default:
			break;
		}
	}

	public void removeAll(String residentId) {
		// TODO Optimize this to delete based on resident id
		List<PaymentBean> paymentBeans = paymentRepository
				.findByResidentId(residentId);
		paymentRepository.delete(paymentBeans);
	}

}
