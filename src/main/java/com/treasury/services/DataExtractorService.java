package com.treasury.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.treasury.beans.ResidentAmountBean;

@Service
public class DataExtractorService {

	public List<String> getResidentIds(
			List<ResidentAmountBean> residentAmountBeans) {
		List<String> residentIds = new ArrayList<>();
		for (ResidentAmountBean residentAmountBean : residentAmountBeans) {
			residentIds.add(residentAmountBean.getResidentId());
		}
		return residentIds;
	}

}
