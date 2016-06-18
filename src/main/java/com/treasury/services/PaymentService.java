package com.treasury.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.treasury.beans.ChequeBean;
import com.treasury.beans.NetBankingBean;
import com.treasury.beans.PaymentBean;
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
	private MonthCalculator monthCalculator;

	@Autowired
	private DashboardService dashboardService;

	public Double calculateAmountPayable(String residentId) throws ParseException {
		ResidentDto residentDto = residentService.findById(residentId);
		Double amountPayable = paymentCalculator
				.calculateAmountPayable(residentDto.getArea());
		int noOfMonths = monthCalculator.getNoOfMonths();
		Double totalAmount = amountPayable * noOfMonths;
		Double amountPaid = dashboardService.getAmountPaid(residentId);
		return totalAmount - amountPaid;
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
		paymentBean.setPaymentDt(getDate(paymentDto.getPaymentDt(), DDMMYYYY));
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

	public Date getDate(String dateStr, String pattern) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.parse(dateStr);
	}

	public String getDate(Date dateStr, String pattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.format(dateStr);
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
			chequeBean.setChequeDt(getDate(paymentDto.getChequeDto()
					.getChequeDt(), DDMMYYYY));
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
		paymentRepository.removeByResidentId(residentId);
	}

}
