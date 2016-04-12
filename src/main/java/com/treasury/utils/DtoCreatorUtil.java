package com.treasury.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.treasury.beans.ChequeBean;
import com.treasury.beans.DateBean;
import com.treasury.beans.NetBankingBean;
import com.treasury.beans.PaymentBean;
import com.treasury.beans.UserBean;
import com.treasury.dtos.ChequeDto;
import com.treasury.dtos.DateDto;
import com.treasury.dtos.NetBankingDto;
import com.treasury.dtos.PaymentDto;

@Component
public class DtoCreatorUtil {

	@Autowired
	private DateConvertorUtil dateConvertorUtil;

	public PaymentDto createPaymentDto(PaymentBean paymentBean,
			UserBean userBean) {
		PaymentDto paymentDto = new PaymentDto();
		paymentDto.setAmount(paymentBean.getAmount());
		paymentDto.setChequeDto(createChequeDto(paymentBean.getChequeBean()));
		paymentDto.setFromDateDto(createDateDto(paymentBean.getFromDate()));
		paymentDto.setId(paymentBean.getId());
		paymentDto.setMode(paymentBean.getMode());
		paymentDto.setName(userBean.getName());
		paymentDto.setNetBankingDto(createNetBankingDto(paymentBean
				.getNetBankingBean()));
		paymentDto.setPaymentDt(dateConvertorUtil.toString(
				paymentBean.getPaymentDt(), DateConvertorUtil.DDMMMYYYY));
		paymentDto.setToDateDto(createDateDto(paymentBean.getToDate()));
		paymentDto.setUserId(paymentBean.getUserId());
		return paymentDto;
	}

	public DateDto createDateDto(DateBean dateBean) {
		DateDto dateDto = new DateDto();
		dateDto.setMonth(dateBean.getMonth());
		dateDto.setYear(dateBean.getYear());
		return dateDto;
	}

	public NetBankingDto createNetBankingDto(NetBankingBean netBankingBean) {
		NetBankingDto netBankingDto = new NetBankingDto();
		if (null != netBankingBean) {
			netBankingDto.setAccountNo(netBankingBean.getAccountNo());
			netBankingDto.setBankDetails(netBankingBean.getBankDetails());
			netBankingDto.setReferenceNo(netBankingBean.getReferenceNo());
		}
		return netBankingDto;
	}

	public ChequeDto createChequeDto(ChequeBean chequeBean) {
		ChequeDto chequeDto = new ChequeDto();
		if (null != chequeBean) {
			chequeDto.setBankDetails(chequeBean.getBankDetails());
			chequeDto.setChequeDt(dateConvertorUtil.toString(
					chequeBean.getChequeDt(), DateConvertorUtil.DDMMMYYYY));
			chequeDto.setChequeNo(chequeBean.getChequeNo());
		}
		return chequeDto;
	}

}
