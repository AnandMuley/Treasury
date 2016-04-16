package com.treasury.services;

import java.text.ParseException;
import java.util.Date;

import org.joda.time.LocalDate;
import org.joda.time.Months;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.treasury.dtos.DateDto;
import com.treasury.utils.DateConvertorUtil;

@Component
public class MonthCalculator {

	private String startDate = "01-Jan-2016";

	@Autowired
	private DateConvertorUtil dateConvertorUtil;

	public int getNoOfMonths() throws ParseException {
		Date fromDate = dateConvertorUtil.toDate(startDate,
				DateConvertorUtil.DDMMMYYYY);
		LocalDate fromDateJT = new LocalDate(fromDate.getTime());
		LocalDate toDate = new LocalDate();
		return Months.monthsBetween(fromDateJT.withDayOfMonth(1),
				toDate.withDayOfMonth(1)).getMonths();
	}

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

	public String getStartDate() {
		return startDate;
	}

}
