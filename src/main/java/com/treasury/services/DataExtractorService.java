package com.treasury.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.treasury.beans.UserAmountBean;

@Service
public class DataExtractorService {

	public List<String> getUserIds(List<UserAmountBean> amountBeans) {
		List<String> userIds = new ArrayList<>();
		for (UserAmountBean userAmountBean : amountBeans) {
			userIds.add(userAmountBean.getUserId());
		}
		return userIds;
	}

}
