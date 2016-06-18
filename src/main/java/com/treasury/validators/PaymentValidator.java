package com.treasury.validators;

import org.springframework.util.StringUtils;

import com.treasury.dtos.PaymentDto;

public class PaymentValidator {

	public void validate(PaymentDto paymentDto) {
		if (null == paymentDto.getFromDateDto()
				|| null == paymentDto.getFromDateDto().getMonth()
				|| paymentDto.getFromDateDto().getMonth() == 0
				|| null == paymentDto.getFromDateDto().getYear()
				|| paymentDto.getFromDateDto().getYear() == 0) {
			paymentDto.getValidationErrors().add("From Date is mandatory");
		}
		if (null == paymentDto.getToDateDto()
				|| null == paymentDto.getToDateDto().getMonth()
				|| paymentDto.getToDateDto().getMonth() == 0
				|| null == paymentDto.getToDateDto().getYear()
				|| paymentDto.getToDateDto().getYear() == 0) {
			paymentDto.getValidationErrors().add("To Date is mandatory");
		}
		if (StringUtils.isEmpty(paymentDto.getResidentId())) {
			paymentDto.getValidationErrors().add("Select a Resident");
		}
	}
}
