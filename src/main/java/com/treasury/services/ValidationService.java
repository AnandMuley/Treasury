package com.treasury.services;

import org.springframework.stereotype.Service;

import com.treasury.dtos.PaymentDto;
import com.treasury.validators.CashModeValidator;
import com.treasury.validators.ChequeModeValidator;
import com.treasury.validators.NetBankingModeValidator;
import com.treasury.validators.PaymentValidator;

@Service
public class ValidationService {

	private PaymentValidator paymentValidator;

	public void validate(PaymentDto paymentDto) {
		switch (paymentDto.getMode()) {
		case "cash":
			paymentValidator = new CashModeValidator();
			break;
		case "cheque":
			paymentValidator = new ChequeModeValidator();
			break;
		case "netbanking":
			paymentValidator = new NetBankingModeValidator();
			break;
		default:
			break;
		}
		paymentValidator.validate(paymentDto);
	}

}
