package com.treasury.services;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.treasury.dtos.PaymentDto;
import com.treasury.dtos.UserDto;
import com.treasury.validators.CashModeValidator;
import com.treasury.validators.ChequeModeValidator;
import com.treasury.validators.NetBankingModeValidator;
import com.treasury.validators.PaymentValidator;

@Service
public class ValidationService {

	private PaymentValidator paymentValidator;

	public void validate(UserDto userDto) {
		if (StringUtils.isEmpty(userDto.getName())) {
			userDto.getValidationErrors().add("Name is mandatory");
		}
		if (null == userDto.getContactNo() || userDto.getContactNo() == 0) {
			userDto.getValidationErrors().add("Contact number is mandatory");
		}
		if (null == userDto.getArea() || userDto.getArea() == 0) {
			userDto.getValidationErrors().add("Area is mandatory");
		}
	}

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
