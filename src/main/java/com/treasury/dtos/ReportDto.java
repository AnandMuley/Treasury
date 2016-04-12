package com.treasury.dtos;

import java.util.ArrayList;
import java.util.List;

public class ReportDto {

	private List<PaymentDto> paymentDtos = new ArrayList<PaymentDto>();

	public List<PaymentDto> getPaymentDtos() {
		return paymentDtos;
	}

	@Override
	public String toString() {
		return "ReportDto [paymentDtos=" + paymentDtos + "]";
	}

}
