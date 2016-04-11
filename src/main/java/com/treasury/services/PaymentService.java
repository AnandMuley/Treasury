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
import com.treasury.exceptions.InvalidPaymentModeException;
import com.treasury.repositories.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	private String DDMMYYYY = "dd-MM-yyyy";

	public void create(PaymentDto paymentDto)
			throws InvalidPaymentModeException, ParseException {
		if (StringUtils.isEmpty(paymentDto.getMode())) {
			throw new InvalidPaymentModeException(
					"Please select a payment mode");
		}
		PaymentBean paymentBean = new PaymentBean();
		paymentBean.setMode(paymentDto.getMode());
		paymentBean.setUserId(paymentDto.getUserId());
		paymentBean.setAmount(paymentDto.getAmount());
		paymentBean.setPaymentDt(getDate(paymentDto.getPaymentDt(), DDMMYYYY));
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
			chequeBean.setSubmittedDt(getDate(paymentDto.getChequeDto()
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

}
