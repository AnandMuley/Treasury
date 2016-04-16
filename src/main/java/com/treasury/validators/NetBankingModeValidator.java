package com.treasury.validators;

import org.springframework.util.StringUtils;

import com.treasury.dtos.PaymentDto;

public class NetBankingModeValidator extends PaymentValidator {

	@Override
	public void validate(PaymentDto paymentDto) {
		super.validate(paymentDto);
		if (StringUtils.isEmpty(paymentDto.getPaymentDt())) {
			paymentDto.getValidationErrors().add("Payment Date is mandatory");
		}
		if (null == paymentDto.getAmount() || paymentDto.getAmount() == 0) {
			paymentDto.getValidationErrors().add("Amount is mandatory");
		}
		if (StringUtils.isEmpty(paymentDto.getNetBankingDto().getAccountNo())) {
			paymentDto.getValidationErrors().add("Account No is mandatory");
		}
		if (StringUtils.isEmpty(paymentDto.getNetBankingDto().getBankDetails())) {
			paymentDto.getValidationErrors().add("Bank Details is mandatory");
		}
		if (StringUtils.isEmpty(paymentDto.getNetBankingDto().getReferenceNo())) {
			paymentDto.getValidationErrors().add("Reference No is mandatory");
		}
	}

}
