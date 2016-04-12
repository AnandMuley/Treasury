package com.treasury.services;

import com.treasury.dtos.DateDto;

public class MonthCalculator {

	public int getNoOfMonths(DateDto fromDateDto, DateDto toDateDto) {
		int fromDiff = 12 - fromDateDto.getMonth();
		fromDiff += toDateDto.getMonth();
		int monthsInYrs = toDateDto.getYear() - fromDateDto.getYear();
		if (monthsInYrs > 1) {
			monthsInYrs = monthsInYrs * 2;
		}
		int total = fromDiff + monthsInYrs;
		return total;
	}

}
