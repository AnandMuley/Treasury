package com.treasury.validators;

import com.treasury.dtos.PaymentDto;

public class CashModeValidator extends PaymentValidator {

	@Override
	public void validate(PaymentDto paymentDto) {
		super.validate(paymentDto);
		if (null == paymentDto.getAmount() || paymentDto.getAmount() == 0) {
			paymentDto.getValidationErrors().add("Amount is mandatory");
		}
	}
}
