package com.treasury.services;

import org.springframework.stereotype.Component;

@Component
public class PaymentCalculator {

	private Double rate = 2.5;

	public Double calculateAmountPayable(Double area) {
		if (area != null) {
			return area * rate;
		}
		return null;
	}

}