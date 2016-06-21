package com.treasury.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.treasury.beans.SettingsBean;
import com.treasury.repositories.SettingsRepository;

@Component
public class PaymentCalculator {

	@Autowired
	private SettingsRepository settingsRepository;

	private Double rate = 2.5;

	public Double calculateAmountPayable(Double area, String createdBy) {
		SettingsBean settingsBean = settingsRepository
				.findByCreatedBy(createdBy);
		if (settingsBean != null) {
			rate = settingsBean.getMaintRate();
		}
		if (area != null) {
			return area * rate;
		}
		return null;
	}

}
